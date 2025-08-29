public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand(String command) {
        this.index = Integer.parseInt(command);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task unmarkedTask = tasks.unmarkTask(this.index);
        ui.showUnmark(unmarkedTask);
    }
}
