import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileDemo {

    public static void main(String[] args) throws IOException {
        File depFile = new File(new File(System.getenv("HOME"), "Desktop"), "dep.txt");
        //System.out.println("depFile exists?: " + depFile.exists());
        if (!depFile.exists()) depFile.createNewFile();

        try(FileOutputStream fos = new FileOutputStream(depFile)){
            fos.write(65);  // 0-255
            fos.write(66);  // 0-255
            fos.write(67);  // 0-255
        }
    }
}
