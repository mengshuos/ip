package chiikawa.command;

import chiikawa.Ui;
import chiikawa.TaskList;
import chiikawa.Storage;
import chiikawa.ChiikawaException;

/**
 * Abstract class that all other Commands will inherit from.
 */
public abstract class Command {
    protected boolean isExit = false;

    /**
     * Executes the corresponding commands.
     * @param tasks TaskList that holds all the current tasks.
     * @param ui Ui that is in charge of all the outputs to the screen.
     * @param storage Storage that is in charge of saving and loading save files.
     * @throws ChiikawaException Exceptions unique to Chiikawa.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws ChiikawaException;

    /**
     * Getter for isExit, representing if the program should terminate.
     *
     * @return boolean representing if the program should terminate.
     */
    public boolean isExit() {
        return this.isExit;
    }
}
