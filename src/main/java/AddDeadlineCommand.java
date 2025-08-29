public class AddDeadlineCommand extends Command {
    private String[] taskInfoArray;

    public AddDeadlineCommand(String taskInfo) {
        this.taskInfoArray = taskInfo.split("/");

        for (int i = 0; i < this.taskInfoArray.length; i++) {
            this.taskInfoArray[i] = this.taskInfoArray[i].strip();
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        DeadlineTask newDeadlineTask = new DeadlineTask(this.taskInfoArray[0], this.taskInfoArray[1]);
        tasks.addTask(newDeadlineTask);
        ui.showAddTask(newDeadlineTask);
    }
}
