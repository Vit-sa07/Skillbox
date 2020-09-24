public class TopManager implements Employee {
    private Company company;
    private Double salary;

    private double fixPartSalary = 90000 + (Math.random() * 30000);

    public TopManager(Company company) {
        this.company = company;
        this.salary = getMonthSalary();
    }

    public long getIncome() {
        return Company.companyGoal;
    }

    @Override
    public double getMonthSalary() {
        double topManagerSalary;
        if (getIncome() > 10000000) {
            topManagerSalary = fixPartSalary + (1.5 * fixPartSalary);
        } else {
            topManagerSalary = fixPartSalary;
        }
        topManagerSalary = topManagerSalary * 100;
        int i = (int) Math.round(topManagerSalary);
        topManagerSalary = (double) i / 100;
        return topManagerSalary;
    }

}