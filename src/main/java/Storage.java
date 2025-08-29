import java.io.File;
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
            // Call UI function to print out error.
            // Placeholder print statements.
            System.out.println("diwectory nawt faound!!");
            System.out.println("i make, no worry");
            parentDir.mkdirs();
        }

        // Checking if the file exists.
        try {
            if (!f.exists()) {
                System.out.println("file nawt faound!!");
                System.out.println("i make, no worry");
                f.createNewFile();
            }
        } catch (IOException e) {
            // Placeholder for UI function to print.
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
            String[] line = s.nextLine().split("\\|", 4);
            boolean isCompleted = line[1].strip().equals("1");
            switch (line[0].strip()) {
                case "T":
                    // Create ToDoTask.
                    // Placeholder for TaskList function that adds new Task.
                    ToDoTask newToDoTask = new ToDoTask(line[2].strip(), isCompleted);
                    taskList.add(newToDoTask);
                    break;

                case "D":
                    // Create DeadlineTask.
                    // Placeholder for TaskList function that adds new Task.
                    DeadlineTask newDeadlineTask = new DeadlineTask(line[2].strip(),
                            isCompleted,
                            line[3].strip());
                    taskList.add(newDeadlineTask);
                    break;

                case "E":
                    // Create EventTask.
                    // Placeholder for TaskList function that adds new Task.
                    String[] eventTime = line[3].split("to");
                    EventTask newEventTask = new EventTask(line[2].strip(),
                            isCompleted,
                            eventTime[0].strip(),
                            eventTime[1].strip());
                    taskList.add(newEventTask);
                    break;
            }
        }
        return taskList;
    }

    public void saveFile(ArrayList<Task> taskList) {
        return;
    }
}
