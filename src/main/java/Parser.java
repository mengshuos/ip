/**
 * Parser makes sense of the user's commands. It will only interpret what the user wants to do and
 * carry out the corresponding command. The only check should be for invalid commands, all other checks
 * should be carried out in the command class itself.
 */
public class Parser {
    enum Commands {
        TODO, DEADLINE, EVENT, LIST, MARK, UNMARK, DELETE, BYE
    }

    public void parse(String fullCommand) {
        fullCommand = fullCommand.strip();
        String[] fullCommandArray = fullCommand.split(" ", 2);
        Commands command = null;

        // Clean the strings of whitespaces.
        for (int i = 0; i < fullCommandArray.length; i++) {
            fullCommandArray[i].strip();
        }

        try {
            command = Commands.valueOf(fullCommandArray[0].toUpperCase());
        } catch (IllegalArgumentException e) {
            // UI print ChiikawaException string
            // do something.
        }

        switch (command) {
            case BYE:
                // UI print "bye~ bye~!! soon... see soon? ₍ᐢ.  ̫.ᐢ₎"
                // Storage save the arraylist
                break;

            case LIST:
                // UI print "i- i twhink these you tasks...?"
                // Access every element in the ArrayList and print them out
                break;

            case MARK:
                // UI print "okee! you finis~~"
                // UI print the task that they finished
                // TaskList marks the task as finished
                break;

            case UNMARK:
                // UI print "ohh.... slowpoke!!"
                // UI print the task that is unmarked
                // TaskList unmark the task
                break;

            case DELETE:
                // UI print "oke... i kill!! say bai bai to:"
                // UI print the task that is to be deeleted
                // TaskList remove the task
                // UI print the number of tasks left, "now only have " + Task.getTaskCount() + " tasks..."
                break;

            case TODO:
                // UI print "wahhh! oke, me add add:"
                // TaskList add todo task
                // UI print the task to be added
                // UI print the System.out.println("wuuu! " + Task.getTaskCount() + " tasks in list now!");
                break;

            case DEADLINE:
                // Splits the command further into task with deadline date
                // UI print System.out.println("ohh! de..deadline?! uuuhh, me add me add:");
                // TaskList add deadline task
                // UI print the task to be added
                // UI print the System.out.println("wuuu! " + Task.getTaskCount() + " tasks in list now!");
                break;

            case EVENT:
                // Splits the command further into task with 2 dates
                // UI print System.out.println("wowzies! yayy! can me go? me add me add:");
                // TaskList create new event task
                // UI print the task to be added
                // UI print the System.out.println("wuuu! " + Task.getTaskCount() + " tasks in list now!");
                break;
        }
    }
}
