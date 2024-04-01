import java.io.File;

public class OperationDemo8 {

    public static void main(String[] args) {
        File source = new File(new File(System.getenv("HOME"), "Desktop"), "abc");
        File target = new File(new File(System.getenv("HOME"), "Downloads"), "edf");

        boolean moved = source.renameTo(target);
        if (moved){
            System.out.println("Moved");
        }else{
            System.out.println("Failed to move");
        }
    }
}
