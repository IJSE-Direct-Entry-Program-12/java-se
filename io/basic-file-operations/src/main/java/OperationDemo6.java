import java.io.File;

public class OperationDemo6 {

    public static void main(String[] args) {
        File testFolder = new File(new File(System.getenv("HOME"), "Desktop"), "test");
        File abcFolder = new File(new File(System.getenv("HOME"), "Desktop"), "abc");

        System.out.println("testFolder exists? " + testFolder.exists());
        System.out.println("abcFolder exists? " + abcFolder.exists());

        boolean renamed = testFolder.renameTo(abcFolder);
        if (renamed){
            System.out.println("Renamed");
        }else{
            System.out.println("Failed");
        }
    }
}
