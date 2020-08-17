import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        LocalDate birthday = LocalDate.of(1994, 5, 5);
        LocalDate today = LocalDate.now();
        int i = 0;
        for (LocalDate date = birthday; date.isBefore(today); date = date.plusYears(1)) {
            DateTimeFormatter printFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy E", new Locale("ru"));
            System.out.println(i + " - " + date.format(printFormat));
            i++;
        }
    }
}
