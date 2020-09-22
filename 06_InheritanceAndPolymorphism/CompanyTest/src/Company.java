import java.util.*;

public class Company implements Comparator<Employee> {
    public static int COMPANY_GOAL;

    List<Employee> workers = new ArrayList<>();

    public Company(int TotalIncome) {
        COMPANY_GOAL = TotalIncome;
    }

    public int hire(Employee employee, String position, int id) {
        if (employee instanceof Manager) {
            workers.add(new Manager(position, id));
        } else if (employee instanceof TopManager) {
            workers.add(new TopManager(position, id));
        } else if (employee instanceof Operator) {
            workers.add(new Operator(position, id));
        }
        return workers.size();
    }

    public int hireAll(Employee employee, String position, int countWorkers) {
        System.out.println("В компанию нанято " + countWorkers + " сотрудников на должность " + position);
        for (int i = 1; i < countWorkers + 1; i++) {
            hire(employee, position, i);
        }
        return workers.size();
    }

    public void setIncome(int income) {
        this.COMPANY_GOAL = income;
    }

    public int getIncome() {
        return COMPANY_GOAL;
    }

    public void fire(String position, int id) {
        System.out.println("Уволили " + position + "-а" + ", ID которого " + id);
        Iterator<Employee> employeeIterator = workers.iterator();
        while (employeeIterator.hasNext()) {
            Employee nextEmployees = employeeIterator.next();
            if (nextEmployees.getId() == id && nextEmployees.getPosition().equalsIgnoreCase(position)) {
                employeeIterator.remove();
            }
        }
    }

    public void fireAll(String postion, int beginId, int endId) {
        Iterator<Employee> employeeIterator = workers.iterator();
        while (employeeIterator.hasNext()) {
            Employee nextEmployees = employeeIterator.next();
            for (int i = beginId; i <= endId; i++) {
                if (nextEmployees.getId() == i && nextEmployees.getPosition().equalsIgnoreCase(postion)) {
                    employeeIterator.remove();
                }
            }
        }
        System.out.println("Сотрудников в компании после увольнения: " + workers.size() + " человек");
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

    @Override

    public int compare(Employee o1, Employee o2) {
        return 0;
    }

    public int compare1(Employee o1, Employee o2) {
        if (o1.getMonthSalary() > o2.getMonthSalary()) {
            return 1;
        }
        if (o1.getMonthSalary() < o2.getMonthSalary()) {
            return -1;
        }
        return 0;
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

