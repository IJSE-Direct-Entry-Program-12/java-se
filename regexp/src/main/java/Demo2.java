import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo2 {

    public static void main(String[] args) {
        String text = """
                055-123456781234566666
                Hi, my contact is 011-1234567 and my friend contact is 
                077-1234567. His sister's contact number is 078-1234567.
                If you want to contact his sister, call this number: 022-1234567
                """;

        Pattern compiledPattern = Pattern.compile("\\b0[1-9]{2}-\\d{7}\\b");
        Matcher matcher = compiledPattern.matcher(text);

        matcher.find(52);
        do {
            //System.out.println(matcher.start());
            //System.out.println(matcher.end());
            String contact = text.substring(matcher.start(), matcher.end());
            System.out.println(contact);
        } while (matcher.find());
    }
}
