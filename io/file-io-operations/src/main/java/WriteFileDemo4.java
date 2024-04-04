import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileDemo4 {

    public static void main(String[] args) throws IOException {
        File file = new File("abc.txt");

        // 447,990
//        long t1 = System.nanoTime();
//        try (FileOutputStream fos = new FileOutputStream(file)) {
//            fos.write('A');
//            fos.write('B');
//            fos.write('C');
//            fos.write('D');
//            fos.write('E');
//            fos.write('F');
//        }
//        long t2 = System.nanoTime();
//        System.out.println(t2 - t1);

        // 525,886
        long t1 = System.nanoTime();
        try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))){
            bos.write('A');
            bos.write('B');
            bos.write('C');
            bos.write('D');
            bos.write('E');
            bos.write('F');
        }
        long t2 = System.nanoTime();
        System.out.println(t2 - t1);
    }
}
