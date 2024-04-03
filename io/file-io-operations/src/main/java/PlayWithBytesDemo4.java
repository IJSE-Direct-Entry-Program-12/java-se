import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class PlayWithBytesDemo4 {

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
            for (int i = 0; i < 138; i++) {
                fos.write(fis.read());
            }

            outer:
            while (true){
                for (int i = 0; i < 3; i++) {
                    int read = fis.read();
                    if (read == -1) break outer;
                    if (i==0 || i == 1){
                        fos.write(0);
                    }else{
                        fos.write(read);
                    }
                }
                // fos.write(new Random().nextInt(255));
            }
        }
    }
}
