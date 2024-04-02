import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativePathDemo {

    public static void main(String[] args) {
        Path path1 = Paths.get("/opt", "a", "b", "c");
        Path path2 = Paths.get("/opt", "a");
        Path path3 = Paths.get("/opt", "a", "e", "d");
        System.out.println(path1.relativize(path2));
        System.out.println(path2.relativize(path1));
        System.out.println("----------------");
        System.out.println(path1.relativize(path3));
        System.out.println(path3.relativize(path1));
    }
}
