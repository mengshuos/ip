package chiikawa.command;

import chiikawa.Ui;
import chiikawa.Parser;
import chiikawa.TaskList;
import chiikawa.Storage;
import chiikawa.ChiikawaException;
import chiikawa.task.EventTask;

/**
 * Class for adding a new event task.
 */
public class AddEventCommand extends Command {
    private String[] taskInfoArray;

    /**
     * Constructor that takes in String representation of the taskInfo and converts it to String array.
     *
     * @param taskInfo String representation of the rest of the user's input.
     */
    public AddEventCommand(String taskInfo) {
        this.taskInfoArray = Parser.parseTaskInfo(taskInfo, "/", 3);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ChiikawaException {
        if (taskInfoArray.length != 3) {
            throw new ChiikawaException("you no give enuff info!! more more!!!!");
        }

        for (String s: taskInfoArray) {
            if (s.isEmpty()) {
                throw new ChiikawaException("blank!! u gave me blanks!!");
            }
        }

        EventTask newEventTask = new EventTask(
                this.taskInfoArray[0],
                this.taskInfoArray[1],
                this.taskInfoArray[2]);
        tasks.addTask(newEventTask);
        ui.showAddTask(newEventTask);
    }
}
