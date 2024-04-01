import java.util.Map;

public class OSEnv {

    /*  In Java, you can only read OS Env Variables
    *   You can't create, edit or delete them.
    * */

    /* What is an OS Environment Variable? */
    /* What can we do with OS Environment Variables?
    *   To Access/Change System/App's Settings
    *   To Change Localization/Internalization Settings
    *   To Store Security Tokens, API Endpoints, etc.
    *   To Communicate/(Share Data) Between Applications
    *   To Externalize App's Configurations
    *   To Configure OS Path Variable
    * */

    public static void main(String[] args) {
        String username = System.getenv("USERNAME");
        System.out.println(username);

        String home = System.getenv("HOME");
        System.out.println(home);

        System.out.println("========================");

        // KEY="VALUE"
        Map<String, String> osEnv = System.getenv();
        System.out.println(osEnv.get("HOME"));

        for (String key : osEnv.keySet()) {
            System.out.printf("%s=%s \n", key, osEnv.get(key));
        }
    }
}
