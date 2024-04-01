import java.io.File;
import java.nio.file.FileSystems;

public class Demo2 {

    public static void main(String[] args) {
        // FileSeparator        C:\Windows\temp    Root[FileSeparator]Windows[FileSeparator]Temp

        // Via Env API
        String fileSeparator = System.getProperty("file.separator");
        System.out.println(fileSeparator);

        // Via IO API
        System.out.println(File.separator);
        System.out.println(File.separatorChar);

        // Via NIO API
        System.out.println(FileSystems.getDefault().getSeparator());
    }
}
