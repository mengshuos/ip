package chiikawa;

import java.util.Scanner;

import chiikawa.task.DeadlineTask;
import chiikawa.task.EventTask;
import chiikawa.task.Task;
import chiikawa.task.ToDoTask;

/**
 * Class consisting of all outputs that users will see.
 */
public class Ui {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Returns the next line of input.
     *
     * @return next line of input by user.
     */
    public String readCommand() {
        return this.scanner.nextLine();
    }

    /**
     * Prints out what Chiikawa would say when bidding farewell.
     */
    public void showBye() {
        System.out.println("bye~ bye~!! soon... see soon? ₍ᐢ.  ̫.ᐢ₎");
        this.scanner.close();
    }

    /**
     * Prints out what Chiikawa would say when showing users the list
     * and the actual list.
     *
     * @param taskList the taskList that the user is operating with.
     */
    public void showList(TaskList taskList) {
        System.out.println("i- i twhink these you tasks...?");
        if (!taskList.toString().isEmpty()) {
            System.out.println(taskList);
        }
    }

    /**
     * Prints out what Chiikawa would say when a task is marked as complete,
     * and the actual task itself.
     *
     * @param markedTask Task that has just been marked complete.
     */
    public void showMark(Task markedTask) {
        System.out.println("okee! you finis~~");
        System.out.println(markedTask.toString());
    }

    /**
     * Prints out what Chiikawa would say when a task is marked as incomplete,
     * and the actual task itself.
     *
     * @param unmarkedTask Task that has just been marked incomplete.
     */
    public void showUnmark(Task unmarkedTask) {
        System.out.println("ohh.... slowpoke!!");
        System.out.println(unmarkedTask.toString());
    }

    /**
     * Prints out what Chiikawa would say when a task is deleted
     * and the actual task itself.
     *
     * @param deletedTask Task that has just been deleted.
     */
    public void showDelete(Task deletedTask) {
        System.out.println("oke... i kill!! say bai bai to:");
        System.out.println(deletedTask.toString());
        System.out.println("now only have " + Task.getTaskCount() + " tasks...");
    }

    /**
     * Prints Chiikawa's reply to user finding tasks that contains keyword.
     *
     * @param keyword
     */
    public void showFind(String keyword) {
        System.out.println("okay.. i keep look out for: " + keyword);
    }

    /**
     * Prints out what Chiikawa would say when any new Task is added
     * and the actual task itself.
     *
     * @param newTask new Task that is created.
     */
    public void showAddTask(Task newTask) {
        if (newTask instanceof ToDoTask) {
            System.out.println("wahhh! oke, me add add:");
        } else if (newTask instanceof DeadlineTask) {
            System.out.println("ohh! de..deadline?! uuuhh, me add me add:");
        } else if (newTask instanceof EventTask) {
            System.out.println("wowzies! yayy! can me go? me add me add:");
        }

        System.out.println("  " + newTask.toString());
        System.out.println("wuuu! " + Task.getTaskCount() + " tasks in list now!");
    }

    /**
     * Prints out what Chiikawa would say when user enters an invalid command.
     */
    public void showInvalid() {
        System.out.println("wha...wha? i dun kno... scawy...");
    }

    /**
     * Prints out what Chiikawa would say when there is an error
     * and the error that is being thrown.
     *
     * @param errorMessage String representation of the error.
     */
    public void showError(String errorMessage) {
        System.out.println("uh oh.." + errorMessage);
    }

    /**
     * Prints out what Chiikawa would say when there is a loading error.
     */
    public void showLoadingError() {
        System.out.println("load loadin loadin pwobem!!");
    }

    /**
     * Prints out Chiikawa's greeting.
     */
    public void showWelcome() {
        String chiikawaArt =
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣶⠿⣶⣦⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡿⠟⠿⣷⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
                + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⡿⠁⠀⠀⣿⣇⣠⣤⣴⣶⣶⣶⣶⡶⢶⣶⣶⣶⣤⣼⣿⠀⠀⠀⣸⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
                + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣧⠀⠀⠀⠛⠛⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠛⠀⠀⢸⣟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
                + "⠀⠀⠀⣼⡄⠀⠀⠀⠀⠀⠀⢀⣴⣾⠿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠿⣶⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
                + "⠠⣶⡆⠁⠳⣤⣠⠀⠀⢀⣴⡿⠋⠁⠀⠀⠀⠀⠀⢀⣀⣤⣤⡄⠀⠀⠀⠀⠀⠀⢠⣴⣤⣤⡀⠀⠀⠀⠀⠀⠈⠻⣿⣆⠀⠀⠀⠀⠀⠀⠄⠀⠀⠀\n"
                + "⠀⠈⢻⣤⡾⠋⠁⠀⢠⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀\n"
                + "⠀⠀⠘⠿⠀⠀⠀⢠⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣶⢶⣦⡄⠀⠀⠀⠀⠀⠀⢀⣠⣶⢶⣦⡀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣧⠀⠀⠀⠀⠀⠀⠀⠀\n"
                + "⠀⠀⠀⠀⠀⠀⠀⣾⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣷⣶⣿⣿⠆⠀⠀⠀⠀⠀⢸⣿⣅⣲⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡀⠀⠀⠀⠀⠀⠀⠀\n"
                + "⠀⠀⠀⠀⠀⠀⢰⣿⡇⠀⠀⠀⠀⠀⢀⣤⣤⣤⣝⣿⣿⣯⡿⠋⠀⠀⠀⠀⠀⠀⠈⢿⣯⣿⣿⠿⢀⡤⣄⡀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀\n"
                + "⠀⠀⠀⠀⠀⠀⢸⣿⡃⠀⠀⠀⠀⠀⣿⣿⣯⣿⣻⣿⠀⠀⠀⠀⢠⣆⣰⣷⡀⣶⡀⠀⠀⠀⣴⣟⣾⣿⣿⡿⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀\n"
                + "⠀⠀⠀⠀⠀⠀⠘⣿⡇⠀⠀⠀⠀⢀⣙⠻⠿⠧⠟⠉⠀⠀⠀⠀⠈⠛⣿⢻⣿⠛⠁⠀⠀⠀⠙⠾⠯⠿⠿⠁⠀⠀⠀⠀⢠⣿⠁⠀⠀⠀⠀⠀⠀⢀\n"
                + "⠀⠀⠀⠀⠀⠀⠀⢹⣷⡀⠀⢠⣾⠟⠛⢿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⣛⣛⣋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⡟⠀⠀⠀⠀⠀⠀⠀⠀\n"
                + "⠀⠀⠀⠀⠀⠀⣀⠀⠻⣷⣄⢻⣯⠀⠀⠈⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠙⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀\n"
                + "⠀⠀⠀⠀⠀⢰⣿⢻⣦⠛⣻⣿⡿⠶⢶⣾⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣤⣤⣤⣴⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
                + "⠀⢠⣶⠀⠀⠈⢿⡜⠿⠃⣿⠋⠀⠀⠀⣶⢿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣧⣀⠙⣿⡄⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀\n"
                + "⣤⠾⠙⢧⣄⠀⠀⠀⠀⠀⢿⣦⡀⠀⠀⢻⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⢩⣷⡿⠃⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀\n"
                + "⠙⢧⣴⠟⠁⠀⠀⠀⠀⠀⠀⠙⠻⠿⣿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⡬⠁⠀⠀⠀⠀⠀⠀⠀⠤⠀⠀⣠⠄⠀\n"
                + "⠀⠘⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⠇⠀⠀\n"
                + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣶⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
                + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⢷⣦⣤⣀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣠⣤⣴⡿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
                + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠛⢿⣧⠀⣿⠀⣸⡟⠛⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
                + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢘⣿⣶⣿⣦⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀";

        showLine();
        System.out.println("hewwo~!");
        System.out.println(chiikawaArt);
        System.out.println("me chiikawa!!");
        System.out.println("you... do somethin'?");
    }

    /**
     * Prints a new line.
     */
    public void showLine() {
        System.out.println("__________________________________________________________________");
    }
}
