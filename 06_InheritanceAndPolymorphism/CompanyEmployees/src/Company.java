import java.util.ArrayList;
import java.util.List;

public  class Company implements Employee {
    private final List<Long> SALARY;

    public ArrayList<Employee> getTopSalaryStaff (int count){
        return null;
    }

    public ArrayList<Employee> getLowestSalaryStaff (int count){
        return null;
    }


    public Company() {
        this.SALARY = new ArrayList<>();
    }

    public Integer getIncome(){
        Integer sal = (int) ( Math.random() * 10000000 );
        return sal;
    }

    public Company hireAll(Integer num) {
        long salary = getMonthSalary();
        for (int i = 0; i < num; i++) this.SALARY.add(salary);
        return this;
    }

    public Company hire() {
        return this.hireAll(1);
    }

    public long getTopSalary() {
        return SALARY.stream().mapToLong(v -> v).max().orElse(0);
    }

    @Override
    public long getMonthSalary() {
        return 0;
    }

    @Override
    public List<Long> getSalaries() {
        return SALARY;
    }
}





