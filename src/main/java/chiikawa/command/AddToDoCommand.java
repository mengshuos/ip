package chiikawa.command;

import chiikawa.Ui;
import chiikawa.TaskList;
import chiikawa.Storage;
import chiikawa.ChiikawaException;
import chiikawa.task.ToDoTask;

/**
 * Class for adding a new to do task.
 */
public class AddToDoCommand extends Command {
    private String taskInfo;

    /**
     * Constructor that takes in String representation of the taskInfo and converts it to String array.
     * * @param taskInfo String representation of the rest of the user's input.
     */
    public AddToDoCommand(String taskInfo) {
        this.taskInfo = taskInfo.strip();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ChiikawaException {
        if (taskInfo.isEmpty()) {
            throw new ChiikawaException("no name! where name!!");
        }

        ToDoTask newToDoTask = new ToDoTask(this.taskInfo);
        tasks.addTask(newToDoTask);
        ui.showAddTask(newToDoTask);
    }
}
