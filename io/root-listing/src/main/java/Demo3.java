import java.io.File;

public class Demo3 {

    public static void main(String[] args) {
        // Via Env API
        String pathSeparator = System.getProperty("path.separator");
        System.out.println(pathSeparator);

        // Via IO API
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);
    }
}
