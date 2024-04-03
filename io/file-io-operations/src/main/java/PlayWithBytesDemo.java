import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PlayWithBytesDemo {

    public static void main(String[] args) throws IOException {
        String imageName = "DEP.png";
        File file = new File(new File(System.getenv("HOME"), "Desktop"), imageName);

        try(FileOutputStream fos = new FileOutputStream(file, true)){
            fos.write('C');
            fos.write('O');
            fos.write('P');
            fos.write('Y');
            fos.write('R');
            fos.write('I');
            fos.write('G');
            fos.write('H');
            fos.write('T');
            fos.write('D');
            fos.write('E');
            fos.write('P');
        }

    }
}
