public class Manager extends Company {

    @Override
    public long getMonthSalary() {
        return 60000 + Math.round(Math.random() * 20000);
    }
}