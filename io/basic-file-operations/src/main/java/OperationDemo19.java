import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OperationDemo19 {

    public static void main(String[] args) throws IOException {
        String folderName = "dep";
        Path folderPath = Paths.get(System.getenv("HOME"), "Desktop", folderName);

        try(DirectoryStream<Path> folderContent = Files.newDirectoryStream(folderPath)) {
            folderContent.forEach(p -> {
                try {
                    Files.delete(p);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        //folderContent.close();

        // if (Files.exists(path)) Files.delete(path);
        Files.deleteIfExists(folderPath);
    }
}
