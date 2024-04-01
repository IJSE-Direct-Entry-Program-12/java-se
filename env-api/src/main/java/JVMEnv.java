import java.util.Properties;

public class JVMEnv {

    public static void main(String[] args) {
        String homeDirPath = System.getProperty("user.home");
        System.out.println(homeDirPath);

        String tmpDirPath = System.getProperty("java.io.tmpdir");
        System.out.println(tmpDirPath);

        String javaVersion = System.getProperty("java.version");
        System.out.println(javaVersion);

        String osArch = System.getProperty("os.arch");
        System.out.println(osArch);

        System.out.println("==============================");

        Properties properties = System.getProperties();
        for (Object key : properties.keySet()) {
            String property = properties.getProperty(key.toString());
            System.out.printf("%s=%s \n", key, property);
        }
    }
}
