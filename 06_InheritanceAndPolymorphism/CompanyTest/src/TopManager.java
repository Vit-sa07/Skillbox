public class TopManager implements Employee {
    String position;
    int id;

    double fixPartSalary = 90000 + (Math.random() * 30000);

    public TopManager(String position, int id) {
        super();
        this.id = id;
        this.position = position;
    }

    public TopManager() {
    }

    @Override
    public long getIncome() {
        return Company.COMPANY_GOAL;
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

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getPosition() {
        return position;
    }

}