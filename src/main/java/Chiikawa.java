import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Chiikawa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<>();
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
            try {
                nextLine = scanner.nextLine();
                action = nextLine.split(" ", 2);

                if (Objects.equals(nextLine, "bye")) {
                    System.out.println("bye~ bye~!! soon... see soon? ₍ᐢ.  ̫.ᐢ₎");
                    System.out.println("__________________________________________________________________");
                    scanner.close();
                    return;

                } else if (Objects.equals(nextLine, "list")) {
                    System.out.println("i- i twhink these you tasks...?");
                    for (int index = 0; index < taskList.size(); index++) {
                        Task currTask = taskList.get(index);
                        System.out.println((index + 1) + "." + currTask.toString());
                    }

                } else if (Objects.equals(action[0], "mark")) {
                    int index = Integer.parseInt(action[1]);
                    taskList.get(index - 1).markTask();
                    System.out.println("okee! you finis~~");
                    System.out.println(taskList.get(index - 1).toString());

                } else if (Objects.equals(action[0], "unmark")) {
                    int index = Integer.parseInt(action[1]);
                    taskList.get(index - 1).unmarkTask();
                    System.out.println("ohh.... slowpoke!!");
                    System.out.println(taskList.get(index - 1).toString());

                } else if (Objects.equals(action[0], "delete")) {
                    int index = Integer.parseInt(action[1]);
                    System.out.println("oke... i kill!! say bai bai to:");
                    System.out.println(taskList.get(index - 1).toString());
                    taskList.get(index - 1).deleteTask();
                    taskList.remove(index - 1);
                    System.out.println("now only have " + Task.getTaskCount() + " tasks...");


                } else if (Objects.equals(action[0], "todo")) {
                    if (action.length != 2) {
                        throw new ChiikawaException("no name!! u giv no name!!");
                    }

                    System.out.println("wahhh! oke, me add add:");
                    ToDoTask newToDoTask = new ToDoTask(action[1]);
                    taskList.add(newToDoTask);
                    System.out.println("  " + newToDoTask.toString());
                    System.out.println("wuuu! " + Task.getTaskCount() + " tasks in list now!");

                } else if (Objects.equals(action[0], "deadline")) {
                    specifiedTime = action[1].split("/");

                    if (specifiedTime.length != 3) {
                        throw new ChiikawaException("wher...where is time!!! giv me gud deadline!!!");
                    }

                    System.out.println("ohh! de..deadline?! uuuhh, me add me add:");
                    DeadlineTask newDeadlineTask = new DeadlineTask(specifiedTime[0], specifiedTime[1]);
                    taskList.add(newDeadlineTask);
                    System.out.println("  " + newDeadlineTask.toString());
                    System.out.println("wuuu! " + Task.getTaskCount() + " tasks in list now!");

                } else if (Objects.equals(action[0], "event")) {
                    specifiedTime = action[1].split("/");

                    if (specifiedTime.length != 3) {
                        throw new ChiikawaException("wher...where is time!!! giv me 2!! 2 time!!");
                    }

                    System.out.println("wowzies! yayy! can me go? me add me add:");
                    EventTask newEventTask = new EventTask(specifiedTime[0], specifiedTime[1], specifiedTime[2]);
                    taskList.add(newEventTask);
                    System.out.println("  " + newEventTask.toString());
                    System.out.println("wuuu! " + Task.getTaskCount() + " tasks in list now!");

                } else {
                    throw new ChiikawaException("wha...wha? i dun kno... scawy...");

                }

            } catch (ChiikawaException e) {
                System.out.println(e.toString());

            } finally {
                System.out.println("__________________________________________________________________");

            }
        }
    }
}
