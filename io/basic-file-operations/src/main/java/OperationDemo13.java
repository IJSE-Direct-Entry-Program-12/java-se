import java.io.File;

public class OperationDemo13 {

    public static void main(String[] args) {
        File folder = new File(System.getenv("HOME"), "Desktop");
        System.out.println("is this a directory?: " + folder.isDirectory());
        System.out.println("is this a file?: " + folder.isFile());

        File[] folderContent = folder.listFiles();
        for (File file : folderContent) {
            System.out.println(file + "-" + (file.isFile() ? "File": "Directory"));
        }
    }
}
