public class ClassA {
    int a;
    static{
        System.out.println("ClassA: Static Initializer");
    }
    {
        System.out.println("ClassA: Instance Initializer");
    }

    public ClassA() {
        System.out.println("ClassA: No Arg Constructor");
    }

    public ClassA(int a) {
        this.a = a;
        System.out.println("ClassA: Constructor");
    }
    @Override
    public String toString() {
        return "ClassA{" +
                "a=" + a +
                '}';
    }
}
