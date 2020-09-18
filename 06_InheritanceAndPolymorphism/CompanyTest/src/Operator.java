public class Operator extends Employee {

    public Operator(String ID, int salary, Company company) {
        super(ID, salary, company);
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

}