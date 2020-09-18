public class Operator extends Company {

    @Override
    public long getMonthSalary() {
        return 30000 + Math.round(Math.random() * 10000);
    }
}
