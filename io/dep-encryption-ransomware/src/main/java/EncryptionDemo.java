import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class EncryptionDemo {

    public static void main(String[] args) throws IOException {
        final String SIGNATURE = "SALLI GEWAPAN, API IJSE - DEP 12";

        File originalFile = Path.of(System.getenv("HOME"), "Desktop", "test.bmp").toFile();
        File encryptedFile = originalFile.toPath().getParent().resolve(originalFile.getName() + ".encrypted").toFile();
        if (!encryptedFile.exists()) encryptedFile.createNewFile();

        try (FileInputStream fis = new FileInputStream(originalFile);
             FileOutputStream fos = new FileOutputStream(encryptedFile)) {
            fos.write(SIGNATURE.getBytes());

            while (true){
                int readByte = fis.read();
                if (readByte == -1) break;
                fos.write(~readByte);
            }
        }
        originalFile.delete();
    }
}
