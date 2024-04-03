import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileDemo3 {

    public static void main(String[] args) throws IOException {
        File file = new File("something.txt");
        if (!file.exists()) file.createNewFile();

        try (var fos = new FileOutputStream(file)) {
            byte[] myBytes = {65, 66, 67, 68, 69, 0, 0, 0, 0, 0, 0, 0, 0};
            fos.write(myBytes, 0, 5);
        }
    }
}
