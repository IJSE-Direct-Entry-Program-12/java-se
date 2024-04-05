import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDemo2 {

    public static void main(String[] args) throws IOException {
        Customer c1 = new Customer(1, "Kasun", "077-1234567");
        Customer c2 = new Customer(2, "Sampath", "078-1234567");

        File file = new File("customers.dep");
        file.createNewFile();

        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(c1);
            oos.writeObject(c2);
        }

        System.out.println(c1);
        System.out.println(c2);
    }
}
