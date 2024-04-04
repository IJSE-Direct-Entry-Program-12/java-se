import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDemo5 {

    public static void main(String[] args) throws IOException {
        File file = new File("dep12.txt");

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            bw.write("Hello! \n");
            bw.write("Direct Entry Program \n");
            bw.write("We can now write Strings \n");
        }
    }
}
