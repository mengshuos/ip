import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for Tasks with deadlines, due before a specific date/time.
 */
public class DeadlineTask extends Task {
    private String deadline;
    private String formattedDeadline;
    private Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
    private Matcher matcher;

    public DeadlineTask(String name, String deadline) {
        super(name);
        this.deadline = deadline;
        this.formattedDeadline = reformatTime(deadline);
    }

    public DeadlineTask(String name, boolean isCompleted, String deadline) {
        super(name, isCompleted);
        this.deadline = deadline;
        this.formattedDeadline = reformatTime(deadline);
    }

    private String reformatTime(String time) {
        matcher = pattern.matcher(time);
        LocalDate localDateTime = null;
        String formattedDate = "";

        if (matcher.find()) {
            deadline = matcher.group();
            localDateTime = LocalDate.parse(time);
            formattedDate = localDateTime.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        }
        
        return formattedDate;
    }

    @Override
    public String toString() {
        String outputTime = this.formattedDeadline == "" ? this.deadline : this.formattedDeadline;
        return "D " + super.toString() + " | " + outputTime;
    }
}