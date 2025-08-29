import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private String filePath;
    private File f;
    private File parentDir;

    public Storage(String filePath) {
        this.filePath = filePath;
        this.f = new File(filePath);
        this.parentDir = f.getParentFile();

        // Checking if parent directory exists.
        if (!parentDir.exists()) {
            // THROW ERROR THAT HAS THE FOLLOWING PRINTS
            System.out.println("diwectory nawt faound!!");
            System.out.println("i make, no worry");
            parentDir.mkdirs();
        }

        // Checking if the file exists.
        try {
            if (!f.exists()) {
                // THROW ERROR THAT HAS THE FOLLOWING PRINTS
                System.out.println("file nawt faound!!");
                System.out.println("i make, no worry");
                f.createNewFile();
            }
        } catch (IOException e) {
            // NEED FIX TMR
        }
    }

    public ArrayList<Task> loadFile() {
        Scanner s = null;
        ArrayList<Task> taskList = new ArrayList<>();

        try {
            s = new Scanner(f);
        } catch (IOException e) {
            // Placeholder for UI function.
            System.out.println("something wrong!!");
        }

        while(s.hasNextLine()) {
            // Placeholder for parser that would return a String[] containing information we need.
            String[] line = Parser.parseTaskInfo(s.nextLine(), "\\|", 4);
            boolean isCompleted = line[1].equals("1");
            switch (line[0]) {
                case "T":
                    // Create ToDoTask.
                    // Placeholder for TaskList function that adds new Task.
                    ToDoTask newToDoTask = new ToDoTask(line[2], isCompleted);
                    taskList.add(newToDoTask);
                    break;

                case "D":
                    // Create DeadlineTask.
                    // Placeholder for TaskList function that adds new Task.
                    DeadlineTask newDeadlineTask = new DeadlineTask(line[2],
                            isCompleted,
                            line[3]);
                    taskList.add(newDeadlineTask);
                    break;

                case "E":
                    // Create EventTask.
                    // Placeholder for TaskList function that adds new Task.
                    String[] eventTime = Parser.parseTaskInfo(line[3], "to", 2);
                    EventTask newEventTask = new EventTask(
                            line[2],
                            isCompleted,
                            eventTime[0],
                            eventTime[1]);
                    taskList.add(newEventTask);
                    break;
            }
        }
        return taskList;
    }

    public void saveFile(ArrayList<Task> taskList) {
        try {
            FileWriter fw = new FileWriter(this.filePath, false);
            for (int i = 0; i < taskList.size(); i++) {
                Task currTask = taskList.get(i);
                fw.append(currTask.toString() + "\n");
            }
            fw.close();

        } catch (IOException e) {
            // THROW ERROR THAT DOES THE FOLLOWING
            // Placeholder for UI function.
            System.out.println(e);
            System.out.println("file got pwoblem!");
        }
    }
}
