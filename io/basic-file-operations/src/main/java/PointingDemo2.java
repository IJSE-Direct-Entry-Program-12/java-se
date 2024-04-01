import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PointingDemo2 {

    public static void main(String[] args) {
        System.out.println(System.getenv("HOME"));
        System.out.println(System.getProperty("user.home"));

        File homeDir1 = new File(System.getenv("HOME"));
        System.out.println(homeDir1.exists());
        Path homeDir2 = Paths.get(System.getProperty("user.home"));
        System.out.println(Files.exists(homeDir2));

        /* This is not a good practice since we have hard coded the file separator here */
        // File desktopDir = new File(System.getenv("HOME") + "/Desktop");

        /* This is a good practice because we haven't hard coded the file separator here
        *  instead we have used the OS file separator */
        //File desktopDir = new File(System.getenv("HOME") + File.separator +  "Desktop");
        File desktopDir = new File(System.getenv("HOME") ,  "Desktop");
        File abcInDesktopDir = new File(desktopDir, "abc");
        System.out.println(desktopDir);
        System.out.println(abcInDesktopDir);

        // Path desktopPath = Paths.get(System.getProperty("user.home") +  FileSystems.getDefault().getSeparator() + "Desktop");
        Path desktopPath = Paths.get(System.getProperty("user.home"), "Desktop");
        Path defInAbcInDesktop = Paths.get(System.getProperty("user.home"), "Desktop", "abc", "edf");
        System.out.println(desktopPath);
        System.out.println(defInAbcInDesktop);

        Path homeDir = Paths.get(System.getenv("HOME"));
        Path deskPath = homeDir.resolve("Desktop");
        System.out.println(deskPath);
    }
}
