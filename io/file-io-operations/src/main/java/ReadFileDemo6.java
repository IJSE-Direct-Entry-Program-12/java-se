import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ReadFileDemo6 {

    public static void main(String[] args) throws IOException {
        File file = Paths.get(System.getenv("HOME"), "Desktop", "image.jpg").toFile();
        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }

        // 390.8
//        long t1 = System.currentTimeMillis();
//        try(FileInputStream fs = new FileInputStream(file)) {
//            int read;
//            while ((read = fs.read()) != -1){
//                //System.out.print(read + " ");
//            }
//        }
//        long t2 = System.currentTimeMillis();
//        System.out.println(t2 -t1);
//
//        try(FileInputStream fs = new FileInputStream(file)) {
//            byte[] byteBuffer = new byte[1024];
//            while (fs.read(byteBuffer) != -1){
//                System.out.println(Arrays.toString(byteBuffer));
//                Arrays.fill(byteBuffer, (byte) 0);
//            }
//        }

        // 27
        long t1 = System.currentTimeMillis();
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){
            int read;
            while ((read = bis.read()) != -1){
//                System.out.print(read + " ");
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);

//        int[] nums = new int[10];
//        Arrays.fill(nums, 5);
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = 5;
//        }
//        System.out.println(Arrays.toString(nums));

//        ArrayList<Integer> numbers = new ArrayList<>();
//        numbers.add(0);
//        numbers.add(0);
//        numbers.add(0);
//        numbers.add(0);
//        numbers.add(0);
//        System.out.println(numbers);
//        Collections.fill(numbers, 5);
//        System.out.println(numbers);


    }
}
