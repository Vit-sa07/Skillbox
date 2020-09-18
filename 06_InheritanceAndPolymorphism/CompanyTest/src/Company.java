import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Company {
    private final int COMPANY_GOAL;

    private List<Employee> workers = new LinkedList<>();

    private TreeSet<Employee> numEmployees = new TreeSet<>(Comparator.comparingInt(Employee::getMonthSalary).reversed().thenComparing(Employee::getName));
    private int monthIncome = 0;

    public Company(int TotalIncome) {
        COMPANY_GOAL = TotalIncome;
    }

    public void hire(Employee employee) {
        this.workers.add(employee);
    }

    public void hireAll(Collection<Employee> employees) {
        this.workers.addAll(employees);
    }

    public void fire(Employee employee) {
        this.workers.remove(employee);
    }

    public void fireAll() {
        this.workers.clear();
    }

    public void fireAll(Collection<Employee> employees) {
        this.workers.removeAll(employees);
    }

    public void closeNextMonth() {

        AtomicInteger gainedMoney = new AtomicInteger(0);
        workers.forEach(e -> gainedMoney.addAndGet(e.gainMoney()));
        monthIncome = gainedMoney.get();

        workers.forEach(Employee::countBonus);

        numEmployees.clear();
        numEmployees.addAll(workers);
    }

    public Integer getIncome() {
        return monthIncome;
    }

    public boolean isCompanyGoalAchieved() {
        return monthIncome >= COMPANY_GOAL;
    }

    public Collection<Employee> getEmployees() {
        return workers;
    }

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        return getStaffBySalary(numEmployees.iterator(), count);
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        return getStaffBySalary(numEmployees.descendingIterator(), count);
    }

    private ArrayList<Employee> getStaffBySalary(Iterator<Employee> iterator, int count) {
        if (count > numEmployees.size()) {
            return new ArrayList<>(numEmployees);
        }

        ArrayList<Employee> result = new ArrayList<>(5);
        for (int i = 0; i < count && iterator.hasNext(); i++) {
            result.add(iterator.next());
        }

        return result;
    }
}
