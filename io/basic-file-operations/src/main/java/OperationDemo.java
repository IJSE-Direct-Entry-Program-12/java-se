import java.io.File;
import java.io.IOException;

public class OperationDemo {

    public static void main(String[] args) {
        File desktopFolder = new File(System.getenv("HOME"), "Desktop");
        File expFolder = new File(desktopFolder, "experiment");

        System.out.println("Desktop folder exists?: " + desktopFolder.exists());
        System.out.println("Experiment folder exists?: " + expFolder.exists());

        boolean created = expFolder.mkdir();
        if (created){
            System.out.println("Folder created");
        }else{
            System.out.println("Folder already exists");
        }

        File dep12File = new File(expFolder, "dep-12.ijse");
        System.out.println("dep-12 file exists?: " + dep12File.exists());

        try {
            created = dep12File.createNewFile();
            if (created){
                System.out.println("An empty file created");
            }else{
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Failed to create the file");
            e.printStackTrace();
        }
    }
}
