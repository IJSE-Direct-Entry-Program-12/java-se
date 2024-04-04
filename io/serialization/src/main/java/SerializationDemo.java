import java.io.*;
import java.util.Arrays;

public class SerializationDemo {

    public static void main(String[] args) throws IOException {
        Employee employee = new Employee(1, "Kasun", "Galle");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(employee);
        byte[] byteArray = baos.toByteArray();
        System.out.println(Arrays.toString(byteArray));


    }
}
