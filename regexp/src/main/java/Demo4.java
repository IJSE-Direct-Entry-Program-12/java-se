import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo4 {

    public static void main(String[] args) {
        String dateTime = "2024-04-29 18:36";
        String pattern = "(?<date>(\\d{4})-(\\d{2})-(\\d{2}))\s(?<time>(\\d{2}):(\\d{2}))";
        System.out.println(dateTime.matches(pattern));

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(dateTime);
        matcher.find();
        System.out.println("Text: " + matcher.group(0));
        System.out.println("Date: " + matcher.group(1));
        System.out.println("Date: " + matcher.group("date"));
        System.out.println("Time: " + matcher.group(5));
        System.out.println("Time: " + matcher.group("time"));
    }
}
