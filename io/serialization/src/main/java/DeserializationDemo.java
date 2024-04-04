import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        byte[] employeeObjectBytes = {-84, -19, 0, 5, 115, 114, 0, 8, 69, 109, 112, 108, 111, 121, 101, 101, 39, -6, 14, -66, 71, 46, -45, -112, 2, 0, 3, 73, 0, 2, 105, 100, 76, 0, 7, 97, 100, 100, 114, 101, 115, 115, 116, 0, 18, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 76, 0, 4, 110, 97, 109, 101, 113, 0, 126, 0, 1, 120, 112, 0, 0, 0, 1, 116, 0, 5, 71, 97, 108, 108, 101, 116, 0, 5, 75, 97, 115, 117, 110};

        ByteArrayInputStream bais = new ByteArrayInputStream(employeeObjectBytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(bais);

        Object o = objectInputStream.readObject();
        System.out.println(o);
    }
}
