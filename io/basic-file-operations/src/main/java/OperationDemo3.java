import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OperationDemo3 {
    public static void main(String[] args) throws IOException {
        Path test2Folder = Paths.get(System.getenv("HOME"), "Desktop", "test-2");
        if (Files.notExists(test2Folder)){
            Files.createDirectory(test2Folder);
        }
        for (int i = 1; i <= 1000; i++) {
            Path file = test2Folder.resolve(i + ".jpg");
            if (Files.notExists(file)){
                Files.createFile(file);
            }
        }
    }
}
