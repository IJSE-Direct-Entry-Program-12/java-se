import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OperationDemo14 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(System.getenv("HOME"), "Desktop");

        DirectoryStream<Path> folderContent = Files.newDirectoryStream(path);
        for (Path p : folderContent) {
            System.out.println(p + "-" + (Files.isDirectory(p) ? "Folder": "File"));
        }
    }
}
