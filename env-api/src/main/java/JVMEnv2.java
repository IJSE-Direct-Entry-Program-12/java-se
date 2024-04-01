public class JVMEnv2 {

    public static void main(String[] args) {
        String osArch = System.getProperty("os.arch");
        System.out.println(osArch);

        String ijseDep = System.getProperty("ijse.dep");
        System.out.println(ijseDep);

        String ijseDepBatch = System.getProperty("ijse.dep.batch");
        System.out.println(ijseDepBatch);
    }
}
