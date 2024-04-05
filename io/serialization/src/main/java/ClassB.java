import java.io.Serializable;

public class ClassB extends ClassA {
    int b;
    static{
        System.out.println("ClassB: Static Initializer");
    }
    {
        System.out.println("ClassB: Instance Initializer");
    }
    public ClassB() {
        super(50);
        System.out.println("ClassB: No Arg Constructor");
    }
    public ClassB(int a, int b) {
        super(a);
        this.b = b;
        System.out.println("ClassB: Constructor");
    }
    @Override
    public String toString() {
        return "ClassB{" +
                "b=" + b +
                '}' + super.toString();
    }
}
