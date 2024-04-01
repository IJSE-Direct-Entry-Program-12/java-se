import java.io.File;
import java.nio.file.Path;

public class PointingDemo6 {

    public static void main(String[] args) {
        String homeDirPath = System.getProperty("user.home");
        File pointer = new File(new File(new File(new File(homeDirPath, "Downloads"), "Images"),
                "abc"), "2.jpg");
        System.out.println(pointer);

        Path pointer2 = Path.of(homeDirPath, "Downloads", "Images", "abc", "2.jpg");
        System.out.println(pointer2);
    }
}
