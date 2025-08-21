public class Task {
    protected String name;
    protected boolean isCompleted = false;

    public Task(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.name;
    }
}