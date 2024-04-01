import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OperationDemo5 {
    public static void main(String[] args) throws IOException {
        Path dep12Folder = Path.of(System.getenv("HOME"), "Desktop", "ijse-2", "dep", "12");

        if (Files.notExists(dep12Folder)){
            Files.createDirectories(dep12Folder);
            System.out.println("Folder created");
        }else{
            System.out.println("Folder already exists");
        }
    }
}
