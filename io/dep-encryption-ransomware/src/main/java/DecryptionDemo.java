import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;

public class DecryptionDemo {

    public static void main(String[] args) throws Exception {
        final String SIGNATURE = "SALLI GEWAPAN, API IJSE - DEP 12";

        File originalFile = Path.of(System.getenv("HOME"), "Desktop", "abc.txt").toFile();
        File encryptedFile = originalFile.toPath().getParent().resolve(originalFile.getName() + ".encrypted").toFile();
        if (!originalFile.exists()) originalFile.createNewFile();

        try (FileInputStream fis = new FileInputStream(encryptedFile);
             FileOutputStream fos = new FileOutputStream(originalFile)) {
            fis.skip(SIGNATURE.getBytes().length);

            while (true){
                int readByte = fis.read();
                if (readByte == -1) break;
                fos.write(~readByte);
            }
        }
        encryptedFile.delete();
    }
}
