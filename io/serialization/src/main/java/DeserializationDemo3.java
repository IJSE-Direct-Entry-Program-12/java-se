import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDemo3 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("objects.dep");

        try(FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            Object o = ois.readObject();
            System.out.println(o);
        }
    }
}
