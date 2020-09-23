import java.util.*;

public class Company {
    public static int companyGoal;

    List<Employee> workers = new ArrayList<>();

    public Company(int TotalIncome) {
        companyGoal = TotalIncome;
    }

    public boolean hire(Employee employee) {
        if (employee != null)
            return this.workers.add(employee);
        return false;
    }

    public boolean hireAll(List<Employee> candidates) {
        return this.workers.addAll(candidates);
    }

    public void setIncome(int income) {
        this.companyGoal = income;
    }

    public int getIncome() {
        return companyGoal;
    }

    public boolean fireAll(Employee badEmployee) {
        if (badEmployee != null)
            return workers.remove(badEmployee);
        return false;
    }

    public void getTopEmployees(int count) {
        workers.sort((o1, o2) -> compare1(o2, o1));
        System.out.println("\nСписок " + count + " самых ВЫСОКИХ зарплат в компании по УБЫВАНИЮ:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + workers.get(i).getMonthSalary());
        }
    }

    public void getLowestEmployees(int count) {
        workers.sort((o1, o2) -> compare2(o2, o1));
        System.out.println("\nСписок " + count + " самых НИЗКИХ зарплат в компании :");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + workers.get(i).getMonthSalary());
        }
    }

    public void getCompanySize() {
        System.out.println("Сотрудников в компании: " + workers.size() + " человек");
    }

    public int compare1(Employee o1, Employee o2) {
        return Double.compare(o1.getMonthSalary(), o2.getMonthSalary());
    }

    public int compare2(Employee o1, Employee o2) {
        if (o1.getMonthSalary() > o2.getMonthSalary()) {
            return -1;
        }
        if (o1.getMonthSalary() < o2.getMonthSalary()) {
            return 1;
        }
        return 0;
    }
}

