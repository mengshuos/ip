import java.util.Objects;

public class AddToDoCommand extends Command {
    private String taskInfo;

    public AddToDoCommand(String taskInfo) {
        this.taskInfo = taskInfo.strip();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ChiikawaException {
        if (Objects.equals(taskInfo, "")) {
            throw new ChiikawaException("no name! where name!!");
        }

        ToDoTask newToDoTask = new ToDoTask(this.taskInfo);
        tasks.addTask(newToDoTask);
        ui.showAddTask(newToDoTask);
    }
}
