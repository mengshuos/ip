package chiikawa.command;

import chiikawa.Ui;
import chiikawa.TaskList;
import chiikawa.Storage;
import chiikawa.ChiikawaException;
import chiikawa.task.ToDoTask;

public class AddToDoCommand extends Command {
    private String taskInfo;

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
