import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company topCompanyName = new Company(1100000);
        topCompanyName.setIncome(12000000);
        List<Employee> empList = new ArrayList<>();
        for (int i = 0; i < 180; i++)
        empList.add(new Operator(topCompanyName));
        for (int i = 0; i < 80; i++)
            empList.add(new Manager(topCompanyName));
        for (int i = 0; i < 10; i++)
            empList.add(new TopManager(topCompanyName));

        topCompanyName.hireAll(empList);
        topCompanyName.getCompanySize();
        topCompanyName.getTopEmployees(15);
        topCompanyName.getLowestEmployees(30);
        for (int i = 0; i < empList.size() / 2; i++)
            topCompanyName.fireAll(empList.get(i));
        topCompanyName.getCompanySize();
        topCompanyName.getTopEmployees(15);
        topCompanyName.getLowestEmployees(30);
    }
}