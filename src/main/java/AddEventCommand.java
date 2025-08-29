public class AddEventCommand extends Command {
    private String[] taskInfoArray;

    public AddEventCommand(String taskInfo) {
        this.taskInfoArray = taskInfo.split("/");

        for (int i = 0; i < this.taskInfoArray.length; i++) {
            this.taskInfoArray[i] = this.taskInfoArray[i].strip();
        }
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
