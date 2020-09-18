import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Company company = new Company(10000000);

        System.out.println("\n-----------------------------");
        for (int i = 0; i < 10; i++) {
            company.hire(new TopManager("TopManager " + i, 80000, company));
        }

        for (int i = 0; i < 80; i++) {
            company.hire(new Manager("Manager " + i, 53000, company));
        }

        for (int i = 0; i < 180; i++) {
            company.hire(new Operator("Operator " + i, 50000, company));
        }

        printCompany(company);

        System.out.println("\n-----------------------------");
        System.out.println("\nУволить 50% (135 сотрудников)");
        company.fireAll(company.getLowestSalaryStaff(135));
        printCompany(company);
    }

    private static void printCompany(Company company) {
        System.out.println("Количество сотрудников: " + company.getEmployees().size());
        System.out.println("\n-----------------------------");
        company.closeNextMonth();
        System.out.println("Доход: " + company.getIncome());
        printStaff(company, 15, 30);
    }

    private static void printStaff(Company company, int top, int low) {
        int amount = company.getEmployees().size();
        if (top + low > amount) {
            throw new IllegalArgumentException();
        }

        System.out.println("\nСписок самых высоких зарплат в компании: ");
        int i = 1;
        for (Employee e : company.getTopSalaryStaff(top)) {
            System.out.println(i + ".\t\t" + MonthSalary(e));
            i++;
        }

        System.out.println("\nCписок из самых низких зарплат в компании:");
        i = amount - low + 1;
        List<Employee> lowestSalaryStaff = company.getLowestSalaryStaff(low);
        Collections.reverse(lowestSalaryStaff);
        for (Employee e :
                lowestSalaryStaff) {
            System.out.println(i + ".\t\t" + MonthSalary(e));
            i++;
        }
    }

    private static String MonthSalary(Employee e) {
        if (e.getBonusValue() > 0) {
            return String.format("%-10s: %10d (зарплата: %d, бонус: %d)", e.getName(), e.getMonthSalary(), e.salary, e.bonusValue);
        } else {
            return String.format("%-10s: %10d", e.getName(), e.getMonthSalary());
        }
    }
}
