import java.util.Objects;
import java.util.Scanner;

public class Chiikawa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task[] taskList = new Task[100];
        int taskListItemCount = 0;
        String nextLine = "";
        String[] action;
        String[] specifiedTime;

        String chiikawaArt = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣶⠿⣶⣦⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡿⠟⠿⣷⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⡿⠁⠀⠀⣿⣇⣠⣤⣴⣶⣶⣶⣶⡶⢶⣶⣶⣶⣤⣼⣿⠀⠀⠀⣸⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣧⠀⠀⠀⠛⠛⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⠛⠀⠀⢸⣟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⣼⡄⠀⠀⠀⠀⠀⠀⢀⣴⣾⠿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠿⣶⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠠⣶⡆⠁⠳⣤⣠⠀⠀⢀⣴⡿⠋⠁⠀⠀⠀⠀⠀⢀⣀⣤⣤⡄⠀⠀⠀⠀⠀⠀⢠⣴⣤⣤⡀⠀⠀⠀⠀⠀⠈⠻⣿⣆⠀⠀⠀⠀⠀⠀⠄⠀⠀⠀\n" +
                "⠀⠈⢻⣤⡾⠋⠁⠀⢠⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠘⠿⠀⠀⠀⢠⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣶⢶⣦⡄⠀⠀⠀⠀⠀⠀⢀⣠⣶⢶⣦⡀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣧⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⣾⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣷⣶⣿⣿⠆⠀⠀⠀⠀⠀⢸⣿⣅⣲⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⢰⣿⡇⠀⠀⠀⠀⠀⢀⣤⣤⣤⣝⣿⣿⣯⡿⠋⠀⠀⠀⠀⠀⠀⠈⢿⣯⣿⣿⠿⢀⡤⣄⡀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⢸⣿⡃⠀⠀⠀⠀⠀⣿⣿⣯⣿⣻⣿⠀⠀⠀⠀⢠⣆⣰⣷⡀⣶⡀⠀⠀⠀⣴⣟⣾⣿⣿⡿⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠘⣿⡇⠀⠀⠀⠀⢀⣙⠻⠿⠧⠟⠉⠀⠀⠀⠀⠈⠛⣿⢻⣿⠛⠁⠀⠀⠀⠙⠾⠯⠿⠿⠁⠀⠀⠀⠀⢠⣿⠁⠀⠀⠀⠀⠀⠀⢀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢹⣷⡀⠀⢠⣾⠟⠛⢿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⣛⣛⣋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⡟⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣀⠀⠻⣷⣄⢻⣯⠀⠀⠈⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠙⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⢰⣿⢻⣦⠛⣻⣿⡿⠶⢶⣾⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣤⣤⣤⣴⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⢠⣶⠀⠀⠈⢿⡜⠿⠃⣿⠋⠀⠀⠀⣶⢿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣧⣀⠙⣿⡄⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀\n" +
                "⣤⠾⠙⢧⣄⠀⠀⠀⠀⠀⢿⣦⡀⠀⠀⢻⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⢩⣷⡿⠃⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀\n" +
                "⠙⢧⣴⠟⠁⠀⠀⠀⠀⠀⠀⠙⠻⠿⣿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⡬⠁⠀⠀⠀⠀⠀⠀⠀⠤⠀⠀⣠⠄⠀\n" +
                "⠀⠘⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⠇⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣶⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⢷⣦⣤⣀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣠⣤⣴⡿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠛⢿⣧⠀⣿⠀⣸⡟⠛⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢘⣿⣶⣿⣦⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀";

        System.out.println("__________________________________________________________________");
        System.out.println("hewwo~!");
        System.out.println(chiikawaArt);
        System.out.println("me chiikawa!!");
        System.out.println("you... do somethin'?");
        System.out.println("__________________________________________________________________");

        while (true) {
            nextLine = scanner.nextLine();
            action = nextLine.split(" ", 2);

            if (Objects.equals(nextLine, "bye")) {
                System.out.println("bye~ bye~!! soon... see soon? ₍ᐢ.  ̫.ᐢ₎");
                System.out.println("__________________________________________________________________");
                scanner.close();
                return;

            } else if (Objects.equals(nextLine, "list")) {
                System.out.println("i- i twhink these you tasks...?");
                for (int index = 0; index < taskListItemCount; index++) {
                    Task currTask = taskList[index];
                    System.out.println((index + 1) + "." + currTask.toString());
                }
                System.out.println("__________________________________________________________________");

            } else if (Objects.equals(action[0], "mark")) {
                int index = Integer.parseInt(action[1]);
                taskList[index - 1].markTask();
                System.out.println("okee! you finis~~");
                System.out.println(taskList[index - 1].toString());
                System.out.println("__________________________________________________________________");

            } else if (Objects.equals(action[0], "unmark")) {
                int index = Integer.parseInt(action[1]);
                taskList[index - 1].unmarkTask();
                System.out.println("ohh.... slowpoke!!");
                System.out.println(taskList[index - 1].toString());
                System.out.println("__________________________________________________________________");

            } else if (Objects.equals(action[0], "todo")) {
                System.out.println("wahhh! oke, me add add:");
                taskList[taskListItemCount] = new ToDoTask(action[1]);
                System.out.println("  " + taskList[taskListItemCount].toString());
                taskListItemCount++;
                System.out.println("wuuu! " + Task.getTaskCount() + " tasks in list now!");
                System.out.println("__________________________________________________________________");

            } else if (Objects.equals(action[0], "deadline")) {
                specifiedTime = action[1].split("/");
                System.out.println("ohh! de..deadline?! uuuhh, me add me add:");
                taskList[taskListItemCount] = new DeadlineTask(specifiedTime[0], specifiedTime[1]);
                System.out.println("  " + taskList[taskListItemCount].toString());
                taskListItemCount++;
                System.out.println("wuuu! " + Task.getTaskCount() + " tasks in list now!");
                System.out.println("__________________________________________________________________");

            } else if (Objects.equals(action[0], "event")) {
                specifiedTime = action[1].split("/");
                System.out.println("wowzies! yayy! can me go? me add me add:");
                taskList[taskListItemCount] = new EventTask(specifiedTime[0], specifiedTime[1], specifiedTime[2]);
                System.out.println("  " + taskList[taskListItemCount].toString());
                taskListItemCount++;
                System.out.println("wuuu! " + Task.getTaskCount() + " tasks in list now!");
                System.out.println("__________________________________________________________________");

            } else {
                taskList[taskListItemCount] = new Task(nextLine);
                taskListItemCount++;
                System.out.println("added!!: " + nextLine);
                System.out.println("__________________________________________________________________");

            }
        }

    }
}
