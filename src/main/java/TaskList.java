import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public TaskList() {
        this.taskList = new ArrayList<Task>();
    }

    public void markTask(int index) {
        this.taskList.get(index).markTask();
    }

    public void unmarkTask(int index) {
        this.taskList.get(index).unmarkTask();
    }

    public void addTask(Task newTask) {
        this.taskList.add(newTask);
    }

    public void deleteTask(int index) {
        this.taskList.get(index).deleteTask();
        this.taskList.remove(index);
    }

    @Override
    public String toString() {
        String output = "";

        for (int i = 0; i < this.taskList.size(); i++) {
            Task currTask = this.taskList.get(i);
            output += (i + 1) + ". " + currTask.toString() + "\n";
        }

        return output;
    }
}
