import java.util.Objects;
import java.util.Scanner;

public class Chiikawa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task[] taskList = new Task[100];
        int taskListItemCount = 0;
        String nextLine = "";
        String[] action;

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

            } else if (Objects.equals(action[0], "mark")) {
                int index = Integer.parseInt(action[1]);
                taskList[index].markTask();

            } else if (Objects.equals(action[0], "unmark")) {
                int index = Integer.parseInt(action[1]);
                taskList[index].unmarkTask();

            } else {
                taskList[taskListItemCount] = new Task(nextLine);
                taskListItemCount++;
                System.out.println("added!!: " + nextLine);
                System.out.println("__________________________________________________________________");
            }
        }

    }
}
