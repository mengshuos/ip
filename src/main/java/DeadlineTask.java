/**
 * Class for Tasks with deadlines, due before a specific date/time.
 */
public class DeadlineTask extends Task {
    private String deadline;

    public DeadlineTask(String name, String deadline) {
        super(name);
        this.deadline = deadline;
    }

    public DeadlineTask(String name, boolean isCompleted, String deadline) {
        super(name, isCompleted);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "D " + super.toString() + " | " + this.deadline;
    }
}