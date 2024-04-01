import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class PointingDemo5 {

    public static void main(String[] args) {
        String os = System.getProperty("os.name");
        Path root = null;
        if (os.toLowerCase().contains("windows")){
            // Windows OS
            for (Path rootDirectory : FileSystems.getDefault().getRootDirectories()) {
                if (Files.exists(rootDirectory.resolve("Windows"))){
                    root = rootDirectory;
                    break;
                }
            }
        }else{
            // Unix-like OS
            root = FileSystems.getDefault().getRootDirectories().iterator().next();
        }
        Path pointer = root.resolve("opt").resolve("java").resolve("21");
        System.out.println(pointer);
    }
}
