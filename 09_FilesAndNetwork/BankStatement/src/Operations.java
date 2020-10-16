
public class Operations {
    String client;
    double income;
    double expense;

    public Operations(String client, double income, double expense) {
        this.client = client;
        this.income = income;
        this.expense = expense;
    }

    public String getClient() {
        return client;
    }

    public double getIncome() {
        return income;
    }

    public double getExpense() {
        return expense;
    }
}