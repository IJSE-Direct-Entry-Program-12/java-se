import java.io.*;

public class ClassC extends ClassB implements Serializable {
    static {
        System.out.println("ClassC: Static Initializer");
    }

    int c;

    {
        System.out.println("ClassC: Instance Initializer");
    }

    public ClassC() {
        System.out.println("ClassC: Constructor");
    }

    public ClassC(int a, int b, int c) {
        super(a, b);
        this.c = c;
        System.out.println("ClassC: Constructor");
    }

    @Override
    public String toString() {
        return "ClassC{" +
                "c=" + c +
                '}' + super.toString();
    }

//    @Override
//    public void writeExternal(ObjectOutput out) throws IOException {
//        out.write(c);
//        out.write(b);
//        out.write(a);
//    }
//
//    @Override
//    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//        c = in.read();
//        b = in.read();
//        a = in.read();
//    }

    private void writeObject(ObjectOutputStream oos) throws Exception{
        oos.defaultWriteObject();
    }

    private void readObject(ObjectInputStream ois) throws Exception {
        ois.defaultReadObject();
    }
}

// Serializable + [writeObject() + readObject()]
//=============================================
// We can customize the java default serialization/deserialization process
// If the super class is not serializable then it should have the no arg constructor,
// otherwise the default deserialization will fail even though it works fine with the default
// serialization process

// Externalizable
//=================
// We can completely override the default serialization/deserialization process
// In this case, the subclass should have the no arg constructor, otherwise again,
// the deserialization will fail