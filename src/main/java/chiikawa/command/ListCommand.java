package chiikawa.command;

import chiikawa.Ui;
import chiikawa.TaskList;
import chiikawa.Storage;

/**
 * Class for when user wants to see the list of all inputted tasks.
 */
public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showList(tasks);
    }
}
