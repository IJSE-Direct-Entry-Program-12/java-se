import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDemo8 {

    public static void main(String[] args) throws IOException {
        File file = new File("pom.xml");

//        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){
//            byte[] byteBuffer = new byte[512];
//            int read;
//            while ((read = bis.read(byteBuffer)) != -1){
//                System.out.print(new String(byteBuffer, 0, read));
//            }
//        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
