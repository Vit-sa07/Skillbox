public class Manager implements Employee {
    String position;
    int id;

    double sales = 115000 + (Math.random() * 140000);
    double fixPartSalary = 40000 + (Math.random() * 20000);

    public Manager(String position, int id) {
        this.id = id;
        this.position = position;
    }

    public Manager() {
    }

    @Override
    public long getIncome() {
        return 0;
    }

    @Override
    public double getMonthSalary() {
        double managerSalary = fixPartSalary + (0.05 * sales);
        managerSalary = managerSalary * 100;
        int i = (int) Math.round(managerSalary);
        managerSalary = (double) i / 100;
        return managerSalary;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getPosition() {
        return position;
    }
}