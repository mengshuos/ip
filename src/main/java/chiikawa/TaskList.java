package chiikawa;

import java.util.ArrayList;

import chiikawa.task.Task;

/**
 * Class representing the ArrayList of Tasks with many methods.
 */
public class TaskList {
    private ArrayList<Task> taskList;

    /**
     * Constructor for TaskList, assigns existing taskList to
     * its own field taskList.
     *
     * @param taskList ArrayList of Tasks that was obtained from a save file.
     */
    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    /**
     * Constructor for TaskList if there was no save file,
     * creates a new ArrayList of Tasks.
     */
    public TaskList() {
        this.taskList = new ArrayList<Task>();
    }

    public ArrayList<Task> getTaskList() {
        return this.taskList;
    }

    /**
     * Marks the specified task and returns it.
     *
     * @param index The index the task is at in the ArrayList + 1.
     * @return The task that was marked.
     */
    public Task markTask(int index) {
        this.taskList.get(index - 1).markTask();
        return this.taskList.get(index - 1);
    }

    /**
     * Unmarks the specified task and returns it.
     *
     * @param index The index the task is at in the ArrayList + 1.
     * @return The task that was unmarked.
     */
    public Task unmarkTask(int index) {
        this.taskList.get(index - 1).unmarkTask();
        return this.taskList.get(index - 1);
    }

    /**
     * Adds newTask to the end of taskList.
     *
     * @param newTask new Task to be added.
     */
    public void addTask(Task newTask) {
        this.taskList.add(newTask);
    }

    /**
     * Deletes the specified task and returns it.
     *
     * @param index The index the task is at in the ArrayList + 1.
     * @return The task that was deleted.
     */
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
            if (!currTask.isHidden() && counter != 0) {
                output += "\n";
            }

            if (!currTask.isHidden()) {
                output += (counter + 1) + ". " + currTask;
                counter++;
            }
        }

        return output;
    }
}
