import java.io.Serializable;

public class Customer implements Serializable {
    private int id;
    private transient String name;
    private transient String contact = "011-1234567";

    private static final long serialVersionUID = 8539876276509304229L;

    static {
        System.out.println("Customer class object is being initialized");
    }

    {
        System.out.println("Customer instance is being initialized");
    }

    public Customer(int id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        System.out.println("Customer instance has been just initialized");
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
