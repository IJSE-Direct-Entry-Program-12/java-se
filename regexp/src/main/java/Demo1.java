import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo1 {

    public static void main(String[] args) {
        String regExp = "\\b\\d{9}[Vv]\\b";

        Pattern compiledPattern = Pattern.compile(regExp);
        Matcher matcher = compiledPattern.matcher("This is my nic: 123456789v");

        System.out.println(matcher.matches());
        System.out.println(matcher.find());

        String inputText = "This is my nic 123456789V";
        boolean matches = inputText.matches("\\d{9}[Vv]");
        System.out.println(matches);
    }
}
