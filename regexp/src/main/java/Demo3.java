import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo3 {

    public static void main(String[] args) {
        String dateTime = "2024-04-29 18:36";
        String pattern = "(\\d{4})-(\\d{2})-(\\d{2})\s(\\d{2}):(\\d{2})";
        System.out.println(dateTime.matches(pattern));

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(dateTime);
        matcher.find();
        System.out.println("Year: " + matcher.group(1));
        System.out.println("Month: "+ matcher.group(2));
        System.out.println("Day: " + matcher.group(3));
        System.out.println("Hours: " + matcher.group(4));
        System.out.println("Minutes: " + matcher.group(5));
    }
}
