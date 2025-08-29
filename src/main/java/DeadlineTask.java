import java.util.Objects;

/**
 * Class for Tasks with deadlines, due before a specific date/time.
 */
public class DeadlineTask extends Task {
    private String deadline;
    private String formattedDeadline;

    public DeadlineTask(String name, String deadline) {
        super(name);
        this.deadline = deadline;
        this.formattedDeadline = super.reformatTime(deadline);
    }

    public DeadlineTask(String name, boolean isCompleted, String deadline) {
        super(name, isCompleted);
        this.deadline = deadline;
        this.formattedDeadline = super.reformatTime(deadline);
    }

    @Override
    public String toString() {
        String outputTime = Objects.equals(this.formattedDeadline, "") ? this.deadline : this.formattedDeadline;
        return "D " + super.toString() + " | " + outputTime;
    }
}