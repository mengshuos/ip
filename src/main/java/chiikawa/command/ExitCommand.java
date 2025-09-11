package chiikawa.command;

import chiikawa.ChiikawaException;
import chiikawa.Storage;
import chiikawa.TaskList;
import chiikawa.Ui;

/**
 * Class for the exiting the program.
 */
public class ExitCommand extends Command {
    /**
     * Constructor for ExitCommand that sets to right conditions for the program to terminate.
     */
    public ExitCommand() {
        super.isExit = true;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ChiikawaException {
        ui.showBye();
        storage.saveFile(tasks.getTaskList());
    }
}
