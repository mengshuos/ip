import java.io.File;
import java.util.ArrayList;

public class Storage {
    private String filePath;
    private File f;

    public Storage(String filePath) {
        this.filePath = filePath;
        this.f = new File(filePath);
    }

    public ArrayList<Task> loadFile() {
        return null;
    }

    public void saveFile(ArrayList<Task> taskList) {
        return;
    }
}
