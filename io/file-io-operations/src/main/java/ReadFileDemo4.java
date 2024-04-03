import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ReadFileDemo4 {

    public static void main(String[] args) throws IOException {
        File file = new File("sample.txt");

//        try(FileInputStream fis = new FileInputStream(file)){
//            int read = fis.read();
//            System.out.println(read);
//            read = fis.read();
//            System.out.println(read);
//            read = fis.read();
//            System.out.println(read);
//            read = fis.read();
//            System.out.println(read);
//        }

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[500];
            int read = fis.read(buffer);
            System.out.println(Arrays.toString(buffer));
            System.out.println(read);
        }

//        try(FileInputStream fis = new FileInputStream(file)){
//            while (true){
//                int readByte = fis.read();
//                if (readByte == -1) break;
//                System.out.print(readByte + " ");
//            }
//        }

//        try(FileInputStream fis = new FileInputStream(file)){
//            byte[] bytes = new byte[(int) file.length()];
//            System.out.println(Arrays.toString(bytes));
//            int read = fis.read(bytes);
//            System.out.println(Arrays.toString(bytes));
//        }

//        try(FileInputStream fis = new FileInputStream(file)){
//            byte[] bytes = fis.readAllBytes();
//            System.out.println(Arrays.toString(bytes));
//        }
    }
}
