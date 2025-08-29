import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManagement {
    private String filePath;
    private File f;

    public FileManagement(String filePath, String dirPath) {
        this.filePath = filePath;
        f = new File(filePath);
        File dir = new File(dirPath);

        try {
            if (!dir.exists()) {
                System.out.println("diwectory nawt faound!!");
                System.out.println("i make, no worry");
                dir.mkdirs();
            }

            if (!f.exists()) {
                System.out.println("file nawt faound!!");
                System.out.println("i make, no worry");
                f.createNewFile();
            }

        } catch (IOException e) {
            System.out.println("something wrong!!");
        }
    }

    public ArrayList<Task> loadFile() {
        Scanner s = null;
        ArrayList<Task> taskList = new ArrayList<>();

        try {
            s = new Scanner(f);
        } catch (IOException e) {
            System.out.println("something wrong!!");
        }

        while(s.hasNextLine()) {
            String[] line = s.nextLine().split("\\|", 4);
            boolean isCompleted = line[1].strip().equals("1");
            switch (line[0].strip()) {
                case "T":
                    // Create ToDoTask.
                    ToDoTask newToDoTask = new ToDoTask(line[2].strip(), isCompleted);
                    taskList.add(newToDoTask);
                    break;

                case "D":
                    // Create DeadlineTask.
                    DeadlineTask newDeadlineTask = new DeadlineTask(line[2].strip(),
                            isCompleted,
                            line[3].strip());
                    taskList.add(newDeadlineTask);
                    break;

                case "E":
                    // Create EventTask.
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
        try {
            FileWriter fw = new FileWriter(this.filePath, false);
            for (int i = 0; i < taskList.size(); i++) {
                Task currTask = taskList.get(i);
                fw.append(currTask.toString() + "\n");
            }
            fw.close();

        } catch (IOException e) {
            System.out.println(e);
            System.out.println("file got pwoblem!");
        }
    }
}