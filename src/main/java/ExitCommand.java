public class ExitCommand extends Command {
    public ExitCommand() {
        super.isExit = true;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ChiikawaException {
        ui.showBye();
        storage.saveFile(tasks.getTaskList());
    }
}
