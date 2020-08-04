import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = " The National Hurricane Center predicts it will hit between north-eastern South Carolina and southern North Carolina sometime on Monday night.\n" +
                "Isaias was downgraded to a tropical storm after hitting islands in the Caribbean, where it caused the death of two people.\n" +
                "But it has now gathered strength with wind speeds of 75mph (120km/h)." +
                "Isaias is the ninth named storm of the year. The NHC warned Isaias would cause heavy rainfall, resulting in \"widespread minor to moderate river flooding and flash floods in the eastern Carolinas and mid-Atlantic as it moves along the US East Coast.";
        Pattern p = Pattern.compile("\\s+[a-zA-Z]++");
        Matcher m = p.matcher(text);
        while (m.find())
        {
            String s = m.group().replaceAll("\\s++", "");
            System.out.println(s);
        }
    }
}
