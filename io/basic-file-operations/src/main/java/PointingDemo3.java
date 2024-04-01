import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PointingDemo3 {

    public static void main(String[] args) {
        String tempDirPath = System.getProperty("java.io.tmpdir");

        File ijseDir = new File(tempDirPath, "ijse");
        File dep12 = new File(ijseDir, "dep12");
        File pointer1 = new File(dep12, "io.txt");

        var pointer2 = new File(new File(new File(tempDirPath, "ijse"), "dep12"), "io.txt");

        var pointer3 = new File(tempDirPath + File.separator + "ijse" + File.separator +
                "dep12" + File.separator + "io.txt");

        Path pointer4 = Paths.get(tempDirPath, "ijse", "dep12", "io.txt");
    }
}
