import java.io.File;

public class OperationDemo16 {

    public static void main(String[] args) throws InterruptedException {
        final String FILE_NAME = "among-trees.jpg";
        File file = new File(new File(System.getenv("HOME"), "Desktop"), FILE_NAME);
        file.deleteOnExit();
        System.out.println("File has been scheduled to delete");
        Thread.sleep(1000 * 10);
        System.out.println("App is about to die");

//        boolean deleted = file.delete();
//        if (deleted){
//            System.out.println("File deleted");
//        }else{
//            System.out.println("File may not exist");
//        }
    }
}
