import java.io.File;

public class FileWalker {

    public static void main(String[] args) {
        File folder = new File(new File(System.getenv("HOME"), "Desktop"), "ijse");
        fileWalker(folder);
    }

    public static void fileWalker(File folder){
        File[] folderContent = folder.listFiles();
        for (File pointer : folderContent) {
            System.out.println(pointer);
            if (pointer.isDirectory()){
                fileWalker(pointer);
            }
        }
    }
}
