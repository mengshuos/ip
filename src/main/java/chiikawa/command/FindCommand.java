package chiikawa.command;

import chiikawa.Ui;
import chiikawa.TaskList;
import chiikawa.Storage;
import chiikawa.ChiikawaException;
import chiikawa.task.Task;

import java.util.ArrayList;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws ChiikawaException {
        if (this.keyword.isEmpty()) {
            throw new ChiikawaException("find wat? hah?");
        }

        this.keyword = this.keyword.strip();
        ArrayList<Task> taskList = tasks.getTaskList();

        for (int i = 0; i < tasks.getTaskList().size(); i++) {
            if (!taskList.get(i).getName().contains(this.keyword)) {
                taskList.get(i).hideTask();
            }
        }

        ui.showFind(this.keyword);
        ui.showList(tasks);

        for (int i = 0; i < tasks.getTaskList().size(); i++) {
            taskList.get(i).unhideTask();
        }
    }
}
