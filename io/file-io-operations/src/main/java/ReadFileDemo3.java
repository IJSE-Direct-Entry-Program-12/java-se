import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

public class ReadFileDemo3 {

    public static void main(String[] args) throws IOException {
        File bigFile = Paths.get(System.getenv("HOME"), "Desktop", "Avengers.mp4").toFile();
        try(FileInputStream fis = new FileInputStream(bigFile)){
            while (true) {
                byte[] myBytes = new byte[1024 * 10];
                int read = fis.read(myBytes);
                if (read == -1) break;
                System.out.println(read);
            }
        }

    }
}
