public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(String command) {
        this.index = Integer.parseInt(command);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task deletedTask = tasks.deleteTask(this.index);
        ui.showDelete(deletedTask);
    }
}
