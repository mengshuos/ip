import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManagement {
    File f;
    Scanner s;
    FileWriter fw;

    public FileManagement(String filePath) {
        this.f = new File(filePath);
        try {
            this.fw = new FileWriter(this.f, true);
            this.s = new Scanner(this.f);
        } catch (IOException e) {
            System.out.println("wha wha is IOException?");
        }
    }

    public void printFileContents() throws FileNotFoundException {
        while (this.s.hasNext()) {
            System.out.println(this.s.nextLine());
        }
    }

    public void appendToFile(String textToAppend) throws IOException {
        this.fw.append(textToAppend);
        this.fw.close();
    }
}
