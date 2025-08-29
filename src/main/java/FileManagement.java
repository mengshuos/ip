import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManagement {
    private String filePath;
    private File f;
    private FileWriter fw;

    public FileManagement(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Task> loadFile() {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

            }
        } catch (FileNotFoundException e) {
            System.out.println("cwan't start!! no can find file!!");
        }

        return null;
    }

    public void saveFile(ArrayList<Task> taskList) {
        try {
            FileWriter fw = new FileWriter(this.filePath, false);
            for (int i = 0; i < taskList.size(); i++) {
                Task currTask = taskList.get(i);
                fw.append(currTask.toString());
            }
            fw.close();

        } catch (IOException e) {
            System.out.println("file got pwoblem!");
        }
    }

    public void writeToFile(String textToWrite) throws IOException {
        fw = new FileWriter(filePath);
        this.fw.write(textToWrite);
        this.fw.close();
    }
}
