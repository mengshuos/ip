public class AddEventCommand extends Command {
    private String[] taskInfoArray;

    public AddEventCommand(String taskInfo) {
        this.taskInfoArray = Parser.parseTaskInfo(taskInfo, "/", 3);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        EventTask newEventTask = new EventTask(
                this.taskInfoArray[0],
                this.taskInfoArray[1],
                this.taskInfoArray[2]);
        tasks.addTask(newEventTask);
        ui.showAddTask(newEventTask);
    }
}
