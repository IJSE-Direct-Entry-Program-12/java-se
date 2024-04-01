import java.io.File;
import java.io.IOException;

public class OperationDemo4 {
    public static void main(String[] args) throws IOException {
        File desktopFolder = new File(System.getenv("HOME"), "Desktop");
        File dep12Folder = new File(new File(new File(desktopFolder, "ijse"), "dep"), "12");

        System.out.println("Desktop exists?: " + desktopFolder.exists());
        System.out.println("dep12 exists?: " + dep12Folder.exists());

        boolean created = dep12Folder.mkdirs();
        if (created){
            System.out.println("Folder created");
        }else{
            System.out.println("Folder already exists");
        }
    }
}
