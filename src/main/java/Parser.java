/**
 * Parser makes sense of the user's commands. It will only interpret what the user wants to do and
 * carry out the corresponding command. The only check should be for invalid commands, all other checks
 * should be carried out in the command class itself.
 */
public class Parser {
    enum Commands {
        TODO, DEADLINE, EVENT, LIST, MARK, UNMARK, DELETE, BYE
    }

    public static Command parse(String fullCommand) {
        fullCommand = fullCommand.strip();
        Commands command = null;
        String[] fullCommandArray = fullCommand.split(" ", 2);
        String taskInfo = fullCommandArray[1].strip();

        try {
            command = Commands.valueOf(fullCommandArray[0].toUpperCase());
        } catch (IllegalArgumentException e) {
            return new InvalidCommand();
        }

        switch (command) {
            case BYE:
                return new ExitCommand();

            case LIST:
                return new ListCommand();

            case MARK:
                return new MarkCommand(taskInfo);

            case UNMARK:
                return new UnmarkCommand(taskInfo);

            case DELETE:
                return new DeleteCommand(taskInfo);

            case TODO:
                return new AddToDoCommand(taskInfo);

            case DEADLINE:
                return new AddDeadlineCommand(taskInfo);

            case EVENT:
                return new AddEventCommand(taskInfo);

            default:
                return new InvalidCommand();
        }
    }

    public static String[] parseTaskInfo(String taskInfo, String regex, int limit) {
        String[] taskInfoArray = taskInfo.split(regex, limit);

        for (int i = 0; i < taskInfoArray.length; i++) {
            taskInfoArray[i] = taskInfoArray[i].strip();
        }

        return taskInfoArray;
    }
}
