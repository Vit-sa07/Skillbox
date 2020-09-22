public class Main {
    public static void main(String[] args) {
        Company topCompanyName = new Company(1100000);
        topCompanyName.setIncome(12000000);
        topCompanyName.hireAll(new Operator(), "OPERATOR", 180);
        topCompanyName.hireAll(new Manager(), "MANAGER", 80);
        topCompanyName.hireAll(new TopManager(), "TOPMANAGER", 10);
        topCompanyName.getCompanySize();
        topCompanyName.getTopEmployees(15);
        topCompanyName.getLowestEmployees(30);
        topCompanyName.fireAll("OPERATOR", 1, 135);
        topCompanyName.getCompanySize();
        topCompanyName.getTopEmployees(15);
        topCompanyName.getLowestEmployees(30);
    }
}