package chiikawa.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that represents tasks in general.
 */
public class Task {
    private final Pattern PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
    private Matcher matcher;

    protected String name;
    protected boolean isCompleted = false;
    private static int TASK_COUNT = 0;

    /**
     * Constructor for creating a task, and increasing the TASK_COUNT.
     * @param name Name of the task.
     */
    public Task(String name) {
        this.name = name;
        TASK_COUNT++;
    }

    /**
     * Constructor for creating a task that is being loaded from save files.
     * @param name Name of the task.
     * @param isCompleted Status of the task.
     */
    public Task(String name, boolean isCompleted) {
        this.name = name;
        this.isCompleted = isCompleted;
        TASK_COUNT++;
    }

    /**
     * Returns String representation of the completion status of the task.
     * @return 1 if task is complete else 0.
     */
    public String getStatusIcon() {
        return (this.isCompleted ? "1" : "0");
    }

    /**
     * Marks the task as completed.
     */
    public void markTask() {
        this.isCompleted = true;
    }

    /**
     * Marks the task as incomplete.
     */
    public void unmarkTask() {
        this.isCompleted = false;
    }

    public static int getTaskCount() {
        return TASK_COUNT;
    }

    /**
     * Decrements the number of tasks that has not been deleted.
     */
    public void deleteTask() {
        TASK_COUNT--;
    }

    /**
     * Reformats the time from one format to another.
     *
     * @param time String representation of the time.
     * @return Reformatted String representation of the time.
     */
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