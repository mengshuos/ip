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
        String[] fullCommandArray = parseTaskInfo(fullCommand, " ", 2);

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
                return new MarkCommand(fullCommandArray[1]);

            case UNMARK:
                return new UnmarkCommand(fullCommandArray[1]);

            case DELETE:
                return new DeleteCommand(fullCommandArray[1]);

            case TODO:
                return new AddToDoCommand(fullCommandArray[1]);

            case DEADLINE:
                return new AddDeadlineCommand(fullCommandArray[1]);

            case EVENT:
                return new AddEventCommand(fullCommandArray[1]);

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
