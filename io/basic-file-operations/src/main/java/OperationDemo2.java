import java.io.File;
import java.io.IOException;

public class OperationDemo2 {
    public static void main(String[] args) {
        File testFolder = new File(new File(System.getenv("HOME"), "Desktop"), "test");
        testFolder.mkdir();
        for (int i = 1; i <= 1000; i++) {
            File file = new File(testFolder, i + ".jpg");
            try {
                file.createNewFile();
            } catch (IOException e) {
                // Do nothing
            }
        }
    }
}
