import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PlayWithBytesDemo2 {

    public static void main(String[] args) throws IOException {
        File file = new File(new File(System.getenv("HOME"), "Desktop"), "sample.psd");
        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            //for (int i = 0; i < 14; i++) fis.read();
            fis.skip(14);
            System.out.println("Height");
            System.out.printf("%s %s %s %s \n", fis.read(), fis.read(), fis.read(), fis.read());
            System.out.println("Width");
            System.out.printf("%s %s %s %s \n", fis.read(), fis.read(), fis.read(), fis.read());
        }
    }
}
