import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ReadFileDemo2 {

    public static void main(String[] args) throws IOException {
        File file = new File("sample.txt");
        if (!file.exists()){
            System.out.println("File not found");
            return;
        }

//        try (FileInputStream fis = new FileInputStream(file)) {
//            while (true){
//                int read = fis.read();
//                if (read == -1) break;
//                System.out.print((char) read);
//            }
//        }

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) file.length()];
            System.out.println(Arrays.toString(bytes));
            fis.read(bytes);
            System.out.println(Arrays.toString(bytes));
            System.out.println(new String(bytes));
//            for (byte aByte : bytes) {
//                System.out.print((char) aByte);
//            }
        }

        byte[] myBytes = {65,66,67};
        String str = new String(myBytes);
        System.out.println(str);
    }
}
