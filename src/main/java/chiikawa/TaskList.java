package chiikawa;

import java.util.ArrayList;
import chiikawa.task.*;

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
        this.taskList.get(index - 1).markTask();
        return this.taskList.get(index - 1);
    }

    public Task unmarkTask(int index) {
        this.taskList.get(index - 1).unmarkTask();
        return this.taskList.get(index - 1);
    }

    public void addTask(Task newTask) {
        this.taskList.add(newTask);
    }

    public Task deleteTask(int index) {
        Task deletedTask = this.taskList.get(index - 1);
        deletedTask.deleteTask();
        this.taskList.remove(index - 1);
        return deletedTask;
    }

    @Override
    public String toString() {
        String output = "";
        int counter = 0;

        for (int i = 0; i < this.taskList.size(); i++) {
            Task currTask = this.taskList.get(i);
            if (!currTask.isHidden()) {
                if (counter != 0) {
                    output += "\n";
                }
                output += (counter + 1) + ". " + currTask.toString();
                counter++;
            }
        }

        counter = 0;
        return output;
    }
}
