import java.io.File;

public class OperationDemo7 {

    public static void main(String[] args) {
        File source = new File(new File(System.getenv("HOME"), "Desktop"), "ijse");
        File target = new File(new File(System.getenv("HOME"), "Downloads"), "ijse");

        boolean moved = source.renameTo(target);
        if (moved){
            System.out.println("Moved");
        }else{
            System.out.println("Failed to move");
        }
    }
}
