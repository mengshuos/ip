package chiikawa.command;

import chiikawa.Ui;
import chiikawa.TaskList;
import chiikawa.Storage;
import chiikawa.ChiikawaException;

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
