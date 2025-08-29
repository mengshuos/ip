import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
        return null;
    }

    public void saveFile(ArrayList<Task> taskList) {
        return;
    }
}
