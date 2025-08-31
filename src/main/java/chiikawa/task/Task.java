package chiikawa.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
    private final Pattern PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
    private Matcher matcher;

    protected String name;
    protected boolean isCompleted = false;
    protected boolean isHidden = false;
    private static int TASK_COUNT = 0;

    public Task(String name) {
        this.name = name;
        TASK_COUNT++;
    }

    public Task(String name, boolean isCompleted) {
        this.name = name;
        this.isCompleted = isCompleted;
        TASK_COUNT++;
    }

    public String getName() {
        return this.name;
    }

    public String getStatusIcon() {
        return (this.isCompleted ? "1" : "0");
    }

    public void markTask() {
        this.isCompleted = true;
    }

    public void unmarkTask() {
        this.isCompleted = false;
    }

    public static int getTaskCount() {
        return TASK_COUNT;
    }

    public void deleteTask() {
        TASK_COUNT--;
    }

    /**
     * Hides the task from the display.
     */
    public void hideTask() {
        this.isHidden = true;
    }

    /**
     * Unhides the task from the display.
     */
    public void unhideTask() {
        this.isHidden = false;
    }

    public boolean isHidden() {
        return this.isHidden;
    }

    protected String reformatTime(String time) {
        matcher = PATTERN.matcher(time);
        LocalDate localDateTime = null;
        String formattedDate = "";

        if (matcher.find()) {
            time = matcher.group();
            localDateTime = LocalDate.parse(time);
            formattedDate = localDateTime.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        }

        return formattedDate;
    }

    @Override
    public String toString() {
        return "| " + this.getStatusIcon() + " | " + this.name;
    }
}