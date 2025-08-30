package chiikawa.task;

/**
 * Class for ToDos which do not have any date/time attached to it.
 */
public class ToDoTask extends Task {
    public ToDoTask(String name) {
        super(name);
    }

    public ToDoTask(String name, boolean isCompleted) {
        super(name, isCompleted);
    }

    @Override
    public String toString() {
        return "T " + super.toString();
    }
}
