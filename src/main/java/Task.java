public class Task {
    private String name;
    private boolean isCompleted = false;

    public Task(String name) {
        this.name = name;
    }

    public String getStatusIcon() {
        return (isCompleted ? "X" : " ");
    }

}