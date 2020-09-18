public class TopManager extends Company {

    @Override
    public long getMonthSalary() {
        return 100000 + Math.round(Math.random() * 50000);
    }
}