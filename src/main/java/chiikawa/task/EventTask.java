package chiikawa.task;

/**
 * Class for Events which are tasks that start at a specific date/time and ends at specific date/time.
 */
public class EventTask extends Task {
    private String startTime = "";
    private String endTime = "";
    private String formattedStartTime = "";
    private String formattedEndTime = "";

    public EventTask(String name, String startTime, String endTime) {
        super(name);
        this.startTime = startTime;
        this.endTime = endTime;
        this.formattedStartTime = super.reformatTime(this.startTime);
        this.formattedEndTime = super.reformatTime(this.endTime);
    }

    public EventTask(String name, boolean isCompleted, String startTime, String endTime) {
        super(name, isCompleted);
        this.startTime = startTime;
        this.endTime = endTime;
        this.formattedStartTime = super.reformatTime(this.startTime);
        this.formattedEndTime = super.reformatTime(this.endTime);
    }

    @Override
    public String toString() {
        String outputStartTime = this.formattedStartTime.isEmpty() ? this.startTime : this.formattedStartTime;
        String outputEndTime = this.formattedEndTime.isEmpty() ? this.endTime : this.formattedEndTime;
        return "E " + super.toString() + " | " + outputStartTime + " to " + outputEndTime;
    }
}