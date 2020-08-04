import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main( String[] args )
    {
        int day = 5;
        int month = 4;
        int year = 1994;
        Locale localeRu = new Locale("ru", "RU");
        DateFormat dateFormat = new SimpleDateFormat("- dd.MM.yyyy - EEE", localeRu);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
//        calendar.set(1994, Calendar.MAY, 5);
        Date date = new Date();
        Date birth = calendar.getTime();
        int i = 0;
        while (date.compareTo(birth) > 0)
        {
            System.out.println(i + dateFormat.format(birth));
            calendar.add(Calendar.YEAR, 1);
            birth = calendar.getTime();
            i++;

        }
    }
}
