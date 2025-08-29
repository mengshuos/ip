public class MarkCommand extends Command {
    private int index;

    public MarkCommand(String command) {
        this.index = Integer.parseInt(command);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task markedTask = tasks.markTask(this.index);
        ui.showMark(markedTask);
    }
}
