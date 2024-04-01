import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OperationDemo1 {

    public static void main(String[] args) {
        Path desktopFolder = Paths.get(System.getenv("HOME"), "Desktop");
        Path expFolder = desktopFolder.resolve("experiment-2");

        System.out.println("Desktop folder exists?: " + Files.exists(desktopFolder));
        System.out.println("experiment-2 folder exists?: " + Files.exists(expFolder));

        if (Files.notExists(expFolder)) {
            try {
                Files.createDirectory(expFolder);
                System.out.println("Folder created");
            } catch (IOException e) {
                System.out.println("Failed to create the folder");
                e.printStackTrace();
            }
        }else{
            System.out.println("Folder already exists");
        }

        Path ijseFile = expFolder.resolve("ijse.dep12");
        System.out.println("ijseFile exists?: " + Files.exists(ijseFile));

        if (Files.notExists(ijseFile)) {
            try {
                Files.createFile(ijseFile);
                System.out.println("File created");
            } catch (IOException e) {
                System.out.println("Failed to create the file");
                e.printStackTrace();
            }
        }else{
            System.out.println("File already exists");
        }
    }
}
