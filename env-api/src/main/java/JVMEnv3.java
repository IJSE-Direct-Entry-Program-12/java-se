import java.util.Properties;

public class JVMEnv3 {

    public static void main(String[] args) {
//        Properties myEnv = new Properties();
//        myEnv.put("ijse.dep", "Direct Entry Program");
//        myEnv.put("ijse.dep.batch", "12");
//        myEnv.put("ijse.location", "Panadura");
//        System.setProperties(myEnv);  /* This will replace the whole JVM env variable set */

        System.setProperty("ijse.dep", "Direct Entry Program");
        System.setProperty("ijse.dep.batch", "12");
        System.setProperty("ijse.dep.location", "Panadura");

        Properties properties = System.getProperties();
        for (Object key : properties.keySet()) {
            String property = properties.getProperty(key.toString());
            System.out.printf("%s=%s \n", key, property);
        }
    }
}
