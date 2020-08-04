import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String[] numbers = {
                "+7 909 123-45-67", "+7 (909) 1234567", "8-905-1234567", "9-453-1234567",
                "8-905-123", "905-1234567", "8-905-12345672342"};

        Pattern p = Pattern.compile("^(\\+7|7|8)?[\\s\\-]?\\(?[489][0-9]{2}\\)?[\\s\\-]?[0-9]{3}[\\s\\-]?[0-9]{2}[\\s\\-]?[0-9]{2}$");
        for (String str : numbers) {
            if (p.matcher(str).matches()) {
                System.out.printf(str + "- верный формат номера%n");
            } else {
                System.out.printf(str + "- неверный формат номера%n");
            }
        }
    }
}


