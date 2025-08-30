public abstract class Command {
    protected boolean isExit = false;

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws ChiikawaException;

    public boolean isExit() {
        return this.isExit;
    }
}
