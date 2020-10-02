import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime plusTwoHours = LocalDateTime.now().plusHours(2);
        airport.getTerminals().stream()
                .flatMap(flight -> flight.getFlights().stream())
                .filter(f -> f.getDate().getTime() >= Date.from(today.atZone(ZoneId.systemDefault()).toInstant()).getTime()
                        && f.getDate().getTime() <= Date.from(plusTwoHours.atZone(ZoneId.systemDefault()).toInstant()).getTime()
                        && f.getType().equals(Flight.Type.ARRIVAL))
                .map(a -> {
                    a.getAircraft().getModel();
                    a.getDate();
                    return "Модель самолета: " + a.getAircraft().getModel() + ", Дата и время вылета : " +
                            new SimpleDateFormat("dd.MM.yyyy HH:mm").format(a.getDate());
                })
                .forEach(System.out::println);
    }
}

