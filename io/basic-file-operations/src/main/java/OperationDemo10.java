import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class OperationDemo10 {

    public static void main(String[] args) {
        /* We still don't have a straight forward API in Java SE to copy directories that have content */

        Path source = Paths.get(System.getenv("HOME"), "Desktop", "among-trees.jpg");
        Path target = Paths.get(System.getenv("HOME"), "Downloads", "among-trees.jpg");

        System.out.println("Source exists?: " + Files.exists(source));
        System.out.println("Target exists?: " + Files.exists(target));

        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Copied");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
