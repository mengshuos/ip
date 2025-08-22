public class Task {
    protected String name;
    protected boolean isCompleted = false;
    private static int TASK_COUNT = 0;

    public Task(String name) {
        this.name = name;
        TASK_COUNT++;
    }

    public String getStatusIcon() {
        return (this.isCompleted ? "X" : " ");
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

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.name;
    }
}