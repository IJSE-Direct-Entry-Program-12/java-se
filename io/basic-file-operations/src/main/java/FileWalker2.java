import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileWalker2 {

    public static void main(String[] args) throws IOException {
        Path folderPath = Path.of(System.getenv("HOME"), "Desktop", "ijse");
        Files.walkFileTree(folderPath, new SimpleFileVisitor<>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println(dir);
                return super.postVisitDirectory(dir, exc);
            }
        });
    }
}
