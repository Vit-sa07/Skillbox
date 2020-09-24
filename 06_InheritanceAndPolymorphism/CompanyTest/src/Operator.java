public class Operator implements Employee {
    private Company company;
    private Double salary;

    private double fixPartSalary = 20000 + (Math.random() * 25000);

    public Operator (Company company) {
        this.company = company;
        this.salary = getMonthSalary();
    }

    @Override
    public double getMonthSalary() {
        double operatorSalary = fixPartSalary;
        operatorSalary = operatorSalary * 100;
        int i = (int) Math.round(operatorSalary);
        operatorSalary = (double) i / 100;
        return operatorSalary;
    }
}