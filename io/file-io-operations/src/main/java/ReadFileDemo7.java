import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDemo7 {

    public static void main(String[] args) throws IOException {
        // Plain Files (Plain Text Files, Plain XML Files, Plain HTML Files)

        File file = new File("pom.xml");

//        try(var fis = new FileInputStream(file)){
//            int read;
//            while ((read = fis.read())!= -1){
//                System.out.print((char) read);
//            }
//        }

        try (FileReader fr = new FileReader(file)) {
            char[] chars = new char[1024];
            int read;
            while ((read = fr.read(chars)) != -1) {
                System.out.print(new String(chars, 0, read));
            }
        }
    }
}
