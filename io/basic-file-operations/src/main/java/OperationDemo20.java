import java.io.File;
import java.nio.file.Path;

public class OperationDemo20 {

    public static void main(String[] args) {
        File file = new File(System.getenv("HOME"));
        Path path = file.toPath();
        file = path.toFile();
    }
}
