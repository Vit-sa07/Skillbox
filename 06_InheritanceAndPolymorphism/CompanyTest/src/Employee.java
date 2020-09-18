public abstract class Employee {

    private final String ID;
    protected int salary;
    protected int bonusValue = 0;
    protected Company company;

    public Employee(String ID, int salary, Company company) {
        this.ID = ID;
        this.salary = salary;
        this.company = company;
    }

    public abstract int getMonthSalary();

    public int gainMoney() {
        return 0;
    }

    public void countBonus() {}

    public String getName() {
        return this.ID;
    }

    public int getBonusValue() {
        return bonusValue;
    }
}

