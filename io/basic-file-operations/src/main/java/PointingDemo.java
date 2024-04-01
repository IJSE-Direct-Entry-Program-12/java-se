import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PointingDemo {

    public static void main(String[] args) {
        File desktopPath1 = new File("/home/ranjith-suranga/Desktop/");
        System.out.println(desktopPath1.exists());

        Path desktopPath2 = Paths.get("/home/ranjith-suranga/Desktop/");
        System.out.println(Files.exists(desktopPath2));

        File desktopPath3 = new File("/home/ranjith-suranga/Desktop/abc/edf");
        System.out.println(desktopPath3.exists());

        Path desktopPath4 = Paths.get("/home/ranjith-suranga/Desktop/abc/edf");
        System.out.println(Files.exists(desktopPath4));

        /* Since Java 11 */
        Path desktopPath5 = Path.of("/home/ranjith-suranga/Desktop/");
        System.out.println(Files.exists(desktopPath5));

        File file = new File("C:/Users/ranjith-suranga/Desktop");
    }
}
