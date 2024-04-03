import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PlayWithBytesDemo3 {

    public static void main(String[] args) throws IOException {
        File file = new File(new File(System.getenv("HOME"), "Desktop"), "sample-3.bmp");
        File output = new File(file.getParent(), "test.bmp");

        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }
        if (!output.exists()) output.createNewFile();

        // 138
        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(output)) {
            while (true) {
                int readByte = fis.read();
                if (readByte == -1) break;
                fos.write(readByte);
            }
        }
    }
}
