import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Demo1 {
    public static void main(String[] args) {
        // If we execute this on Windows, then we should get the partition list like C:, D:, E:, etc.
        File[] roots = File.listRoots();
        for (File root : roots) {
            System.out.println(root);
        }

        System.out.println("------------------");

        for (Path rootDirectory : FileSystems.getDefault().getRootDirectories()) {
            System.out.println(rootDirectory);
        }
    }
}
