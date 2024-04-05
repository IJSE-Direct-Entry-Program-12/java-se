import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDemo3 {

    public static void main(String[] args) throws IOException {
        ClassC obj = new ClassC(10, 20, 30);

        File file = new File("objects.dep");
        file.createNewFile();

        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
        }

        System.out.println(obj);
    }
}
