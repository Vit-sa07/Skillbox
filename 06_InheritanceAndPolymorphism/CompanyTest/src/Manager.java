public class Manager implements Employee {
    private Company company;
    private Double salary;

    double sales = 115000 + (Math.random() * 140000);
    double fixPartSalary = 40000 + (Math.random() * 20000);

    public Manager(Company company) {
        this.company = company;
        this.salary = getMonthSalary();
    }

    @Override
    public double getMonthSalary() {
        double managerSalary = fixPartSalary + (0.05 * sales);
        managerSalary = managerSalary * 100;
        int i = (int) Math.round(managerSalary);
        managerSalary = (double) i / 100;
        return managerSalary;
    }
}