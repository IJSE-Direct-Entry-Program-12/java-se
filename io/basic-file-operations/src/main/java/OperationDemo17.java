import java.io.File;

public class OperationDemo17 {

    public static void main(String[] args) {
        File folder = new File(new File(System.getenv("HOME"), "Desktop"), "dep");
        for (File file : folder.listFiles()) {
            file.delete();
        }
        boolean deleted = folder.delete();
        if (deleted){
            System.out.println("Folder deleted");
        }else{
            System.out.println("Failed to delete the folder");
        }
    }
}
