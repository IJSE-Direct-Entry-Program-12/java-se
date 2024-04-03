import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileDemo2 {

    public static void main(String[] args) throws IOException {
        String content = "Hello Direct Entry Program-12";
        File file = new File("sample.txt");
        file.createNewFile();

//        try(FileOutputStream fos = new FileOutputStream(file)){
//            char[] chars = content.toCharArray();
//            for (char c : chars) {
//                fos.write(c);
//            }
//        }

//        try (FileOutputStream fos = new FileOutputStream(file)) {
////            fos.write(65);
////            fos.write(66);
////            fos.write(67);
//
//            byte[] bytes = {65, 66, 67, 68, 69, 70};
//            fos.write(bytes);
//        }

        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] bytes = content.getBytes();
            fos.write(bytes);
        }
    }
}
