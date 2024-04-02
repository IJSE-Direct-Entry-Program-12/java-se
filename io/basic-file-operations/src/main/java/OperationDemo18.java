import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OperationDemo18 {

    public static void main(String[] args) throws IOException {
        String filename = "among-trees.jpg";
        Path path = Paths.get(System.getenv("HOME"), "Desktop", filename);

        // if (Files.exists(path)) Files.delete(path);
        Files.deleteIfExists(path);
    }
}
