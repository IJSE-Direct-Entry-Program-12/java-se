import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OperationDemo12 {

    public static void main(String[] args) {
        File desktopFolder = new File(System.getenv("HOME"), "Desktop");
        File pointer1 = new File(desktopFolder, "short-cut-ijse");
        File pointer2 = new File(desktopFolder, "short-cut.jpg");

        System.out.println("Is pointer1 a directory?: " + pointer1.isDirectory());
        System.out.println("Is pointer1 a file?: " + pointer1.isFile());

        System.out.println("Is pointer2 a directory?: " + pointer2.isDirectory());
        System.out.println("Is pointer2 a file?: " + pointer2.isFile());

        Path path1 = Path.of(System.getenv("HOME"), "Desktop", "short-cut-ijse");
        Path path2 = Path.of(System.getenv("HOME"), "Desktop", "short-cut.jpg");

        System.out.println("Is path1 a directory?: " + Files.isDirectory(path1));
        System.out.println("Is path1 a file?: " + Files.isRegularFile(path1));
        System.out.println("Is path1 a shortcut?: " + Files.isSymbolicLink(path1));

        System.out.println("Is path2 a directory?: " + Files.isDirectory(path2));
        System.out.println("Is path2 a file?: " + Files.isRegularFile(path2));
        System.out.println("Is path2 a shortcut?: " + Files.isSymbolicLink(path2));
    }
}
