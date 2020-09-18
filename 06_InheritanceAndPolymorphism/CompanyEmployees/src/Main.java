import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employies = new ArrayList<>();
        employies.add(new Operator().hireAll(180));
        employies.add(new Manager().hireAll(80));
        employies.add(new TopManager().hireAll(10));
        List<Long> allSalary = Employee.getAllSalary(employies);
        System.out.println(allSalary);
        Company gh = new Company();
        System.out.println(gh.getMonthSalary());
    }
}