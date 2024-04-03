import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ReadFileDemo5 {

    public static void main(String[] args) throws IOException {
        File file = new File("sample.txt");
        File output = new File("output.txt");
        if (!output.exists()) output.createNewFile();

        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(output)) {

            while (true) {
                byte[] buffer = new byte[1024];
                int read = fis.read(buffer);
                if (read == -1) break;
                //System.out.println(Arrays.toString(buffer));
                System.out.println(new String(buffer,0,read));
                fos.write(buffer,0,read);
            }

        }
    }
}
