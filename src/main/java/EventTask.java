/**
 * Class for Events which are tasks that start at a specific date/time and ends at specific date/time.
 */
public class EventTask extends Task {
    private String startTime;
    private String endTime;

    public EventTask(String name, String startTime, String endTime) {
        super(name);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public EventTask(String name, boolean isCompleted, String startTime, String endTime) {
        super(name, isCompleted);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "E " + super.toString() + "| " + this.startTime + "to " + this.endTime;
    }
}