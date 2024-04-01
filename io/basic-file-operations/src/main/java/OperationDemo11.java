import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OperationDemo11 {

    public static void main(String[] args) {
        File desktopFolder = new File(System.getenv("HOME"), "Desktop");
        File ijseFolder = new File(desktopFolder, "ijse");
        File imageFile = new File(desktopFolder, "among-trees.jpg");

        System.out.println("is ijse folder?: " + ijseFolder.isDirectory());
        System.out.println("is ijse file?: " + ijseFolder.isFile());

        System.out.println("is imageFile folder?: " + imageFile.isDirectory());
        System.out.println("is imageFile file?: " + imageFile.isFile());

        Path path1 = Paths.get(System.getenv("HOME"), "Desktop", "ijse");
        Path path2 = Paths.get(System.getenv("HOME"), "Desktop", "among-trees.jpg");

        System.out.println("is path1 folder?: " + Files.isDirectory(path1));
        System.out.println("is path1 file?: " + Files.isRegularFile(path1));
        System.out.println("is path1 link?: " + Files.isSymbolicLink(path1));

        System.out.println("is path2 folder?: " + Files.isDirectory(path2));
        System.out.println("is path2 file?: " + Files.isRegularFile(path2));
        System.out.println("is path2 link?: " + Files.isSymbolicLink(path2));
    }
}
