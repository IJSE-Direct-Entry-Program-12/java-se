import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class ReadFileDemo {

    public static void main(String[] args) throws IOException {
        String filename = "among-trees.jpg";
        File file = new File(new File(System.getenv("HOME"), "Desktop"), filename);

        if (!file.exists()){
            System.out.println("File not found");
            return;
        }else if(!file.isFile()){
            System.out.println("Not a file");
            return;
        }

        FileInputStream fis = new FileInputStream(file);
//        byte[] fileContent = new byte[(int) file.length()];
//        fis.read(fileContent);
//        System.out.println(Arrays.toString(fileContent));

        while (true) {
            int read = fis.read();
            if (read == -1) break;
            System.out.print(read + " ");
        }
    }
}
