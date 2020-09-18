import java.util.List;
import java.util.stream.Collectors;

public interface Employee {

    long getMonthSalary();

    List<Long> getSalaries();

    static List<Long> getAllSalary(List<? extends Employee> companies) {
        return companies.stream()
                .flatMap(c->c.getSalaries().stream())
                .collect(Collectors.toList());
    }
}

