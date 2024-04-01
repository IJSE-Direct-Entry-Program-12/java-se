import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OperationDemo9 {

    public static void main(String[] args) {
        Path ijse2Folder = Paths.get(System.getenv("HOME"), "Desktop", "ijse-2");
        // Path ijse = ijse2Folder.resolve("ijse");
         Path ijseFolder = ijse2Folder.resolveSibling("ijse");

        System.out.println("ijse-2 exists? " + Files.exists(ijse2Folder));
        System.out.println("ijse exists? " + Files.exists(ijseFolder));

        try {
            Files.move(ijse2Folder, ijseFolder);
            System.out.println("Renamed");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
