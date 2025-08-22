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

        enum Actions {
            TODO, DEADLINE, EVENT, LIST, MARK, UNMARK, DELETE, BYE
        }

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
                action[0] = action[0].toUpperCase();
                Actions currAction;
                int index;

                try {
                    currAction = Actions.valueOf(action[0]);

                } catch (IllegalArgumentException e) {
                    throw new ChiikawaException("wha...wha? i dun kno... scawy...");

                }

                switch(currAction) {
                    case BYE:
                        System.out.println("bye~ bye~!! soon... see soon? ₍ᐢ.  ̫.ᐢ₎");
                        scanner.close();
                        return;
                    case LIST:
                        System.out.println("i- i twhink these you tasks...?");
                        for (int i = 0; i < taskList.size(); i++) {
                            Task currTask = taskList.get(i);
                            System.out.println((i + 1) + "." + currTask.toString());
                        }
                        break;
                    case MARK:
                        index = Integer.parseInt(action[1]);
                        taskList.get(index - 1).markTask();
                        System.out.println("okee! you finis~~");
                        System.out.println(taskList.get(index - 1).toString());
                        break;
                    case UNMARK:
                        index = Integer.parseInt(action[1]);
                        taskList.get(index - 1).unmarkTask();
                        System.out.println("ohh.... slowpoke!!");
                        System.out.println(taskList.get(index - 1).toString());
                        break;
                    case DELETE:
                        index = Integer.parseInt(action[1]);
                        System.out.println("oke... i kill!! say bai bai to:");
                        System.out.println(taskList.get(index - 1).toString());
                        taskList.get(index - 1).deleteTask();
                        taskList.remove(index - 1);
                        System.out.println("now only have " + Task.getTaskCount() + " tasks...");
                        break;
                    case TODO:
                        if (action.length != 2) {
                            throw new ChiikawaException("no name!! u giv no name!!");
                        }

                        System.out.println("wahhh! oke, me add add:");
                        ToDoTask newToDoTask = new ToDoTask(action[1]);
                        taskList.add(newToDoTask);
                        System.out.println("  " + newToDoTask.toString());
                        System.out.println("wuuu! " + Task.getTaskCount() + " tasks in list now!");
                        break;
                    case DEADLINE:
                        specifiedTime = action[1].split("/");

                        if (specifiedTime.length != 2) {
                            throw new ChiikawaException("wher...where is time!!! giv me gud deadline!!!");
                        }

                        System.out.println("ohh! de..deadline?! uuuhh, me add me add:");
                        DeadlineTask newDeadlineTask = new DeadlineTask(specifiedTime[0], specifiedTime[1]);
                        taskList.add(newDeadlineTask);
                        System.out.println("  " + newDeadlineTask.toString());
                        System.out.println("wuuu! " + Task.getTaskCount() + " tasks in list now!");
                        break;
                    case EVENT:
                        specifiedTime = action[1].split("/");

                        if (specifiedTime.length != 3) {
                            throw new ChiikawaException("wher...where is time!!! giv me 2!! 2 time!!");
                        }

                        System.out.println("wowzies! yayy! can me go? me add me add:");
                        EventTask newEventTask = new EventTask(specifiedTime[0], specifiedTime[1], specifiedTime[2]);
                        taskList.add(newEventTask);
                        System.out.println("  " + newEventTask.toString());
                        System.out.println("wuuu! " + Task.getTaskCount() + " tasks in list now!");
                        break;
                }
            } catch (ChiikawaException e) {
                System.out.println(e.toString());

            } finally {
                System.out.println("__________________________________________________________________");

            }
        }
    }
}
