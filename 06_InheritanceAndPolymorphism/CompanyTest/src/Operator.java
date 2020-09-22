public class Operator implements Employee {
    String position;
    int id;

    double fixPartSalary = 20000 + (Math.random() * 25000);

    public Operator (String position, int id) {
        this.id = id;
        this.position = position;
    }

    public Operator() {
    }

    @Override
    public long getIncome() {
        return 0;
    }

    @Override
    public double getMonthSalary() {
        double operatorSalary = fixPartSalary;
        operatorSalary = operatorSalary * 100;
        int i = (int) Math.round(operatorSalary);
        operatorSalary = (double) i / 100;
        return operatorSalary;
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