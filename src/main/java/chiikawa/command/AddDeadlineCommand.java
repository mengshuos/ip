package chiikawa.command;

import chiikawa.Ui;
import chiikawa.Parser;
import chiikawa.TaskList;
import chiikawa.Storage;
import chiikawa.ChiikawaException;
import chiikawa.task.DeadlineTask;


public class AddDeadlineCommand extends Command {
    private String[] taskInfoArray;

    public AddDeadlineCommand(String taskInfo) {
        this.taskInfoArray = Parser.parseTaskInfo(taskInfo, "/", 2);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ChiikawaException {
        if (taskInfoArray.length != 2) {
            throw new ChiikawaException("you no give enuff info!! more more!!!!");
        }

        for (String s: taskInfoArray) {
            if (s.isEmpty()) {
                throw new ChiikawaException("blank!! u gave me blanks!!");
            }
        }

        DeadlineTask newDeadlineTask = new DeadlineTask(this.taskInfoArray[0], this.taskInfoArray[1]);
        tasks.addTask(newDeadlineTask);
        ui.showAddTask(newDeadlineTask);
    }
}
