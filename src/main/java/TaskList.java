import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public TaskList() {
        this.taskList = new ArrayList<Task>();
    }

    public ArrayList<Task> getTaskList() {
        return this.taskList;
    }

    public Task markTask(int index) {
        this.taskList.get(index).markTask();
        return this.taskList.get(index);
    }

    public Task unmarkTask(int index) {
        this.taskList.get(index).unmarkTask();
        return this.taskList.get(index);
    }

    public void addTask(Task newTask) {
        this.taskList.add(newTask);
    }

    public Task deleteTask(int index) {
        Task deletedTask = this.taskList.get(index);
        deletedTask.deleteTask();
        this.taskList.remove(index);
        return deletedTask;
    }

    @Override
    public String toString() {
        String output = "";

        for (int i = 0; i < this.taskList.size(); i++) {
            Task currTask = this.taskList.get(i);
            output += (i + 1) + ". " + currTask.toString();
            output += i == this.taskList.size() - 1 ? "" : "\n";
        }

        return output;
    }
}
