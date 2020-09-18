public abstract class Client  {
    private double balance;
    private String ownerName;
    private int accountNumber;
    private static int nextAccountNumber = 1;

    Client(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0.0;
        this.assignNewAccountNumber();
    }

    void assignNewAccountNumber() {
        this.accountNumber = this.nextAccountNumber;
        this.nextAccountNumber = this.nextAccountNumber + 1;
    }

    boolean deposit(double amount) {
        return this.updateBalance(amount);
    }

    boolean withdraw(double amount) {
        return this.updateBalance(-amount);
    }

    boolean updateBalance(double amount) {
        double sum = this.balance + amount;
        if (sum < 0) {
            System.out.println("У вас недостаточно средств!");
            return false;
        } else {
            this.balance = sum;
            return true;
        }
    }

    public String toString() {
        return "На счету  " + getOwnerName() + " баланс: " + getBalance();
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    double getBalance() {
        return this.balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
