import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OperationDemo15 {

    public static void main(String[] args) throws IOException {
        Path source = Paths.get(System.getenv("HOME"), "Desktop", "ijse");
        Path target = Paths.get(System.getenv("HOME"), "Downloads", "ijse");

        Files.copy(source, target);

        for (Path path : Files.newDirectoryStream(source)) {
            Files.copy(path, target.resolve(path.getFileName()));
        }
    }
}
