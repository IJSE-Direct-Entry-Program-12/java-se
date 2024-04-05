import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDemo2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("customers.dep");

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Customer c1 = (Customer) ois.readObject();
            System.out.println(c1);
            Customer c2 = (Customer) ois.readObject();
            System.out.println(c2);
        }
    }
}
