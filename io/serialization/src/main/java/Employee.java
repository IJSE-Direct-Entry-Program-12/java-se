import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;
    private String address;

    private static final long serialVersionUID = 2880631122057679760L;

    static{
        System.out.println("Hello");
    }

    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
