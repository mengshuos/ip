package chiikawa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import chiikawa.task.*;

public class Storage {
    private String filePath;
    private File f;
    private File parentDir;

    public Storage(String filePath) {
        this.filePath = filePath;
        this.f = new File(filePath);
        this.parentDir = f.getParentFile();
    }

    public ArrayList<Task> loadFile() throws ChiikawaException {
        Scanner s = null;
        ArrayList<Task> taskList = new ArrayList<>();

        if (!this.parentDir.exists()) {
            this.parentDir.mkdirs();
            throw new ChiikawaException("diwectory nawt faound!!\ni make, no worry");
        }

        if (!this.f.exists()) {
            try {
                this.f.createNewFile();
                throw new ChiikawaException("file nawt faound!!\ni make, no worry");
            } catch (IOException e) {
                throw new ChiikawaException("IOException or samting... idkk!!!");
            }
        }

        try {
            s = new Scanner(f);
        } catch (IOException e) {
            throw new ChiikawaException("scanner pwoblem....");
        }

        while(s.hasNextLine()) {
            String[] line = Parser.parseTaskInfo(s.nextLine(), "\\|", 4);
            boolean isCompleted = line[1].equals("1");
            String command = line[0];
            switch (command) {
            case "T":
                ToDoTask newToDoTask = new ToDoTask(line[2], isCompleted);
                taskList.add(newToDoTask);
                break;

            case "D":
                DeadlineTask newDeadlineTask = new DeadlineTask(line[2],
                        isCompleted,
                        line[3]);
                taskList.add(newDeadlineTask);
                break;

            case "E":
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

    public void saveFile(ArrayList<Task> taskList) throws ChiikawaException {
        try {
            FileWriter fw = new FileWriter(this.filePath, false);
            for (Task currTask : taskList) {
                fw.append(currTask.toString()).append("\n");
            }
            fw.close();

        } catch (IOException e) {
            throw new ChiikawaException("file got pwoblem!!");
        }
    }
}
