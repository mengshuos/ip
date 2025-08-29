public class AddDeadlineCommand extends Command {
    private String[] taskInfoArray;

    public AddDeadlineCommand(String taskInfo) {
        this.taskInfoArray = Parser.parseTaskInfo(taskInfo, "/", 2);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        DeadlineTask newDeadlineTask = new DeadlineTask(this.taskInfoArray[0], this.taskInfoArray[1]);
        tasks.addTask(newDeadlineTask);
        ui.showAddTask(newDeadlineTask);
    }
}
