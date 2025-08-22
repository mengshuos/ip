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
}