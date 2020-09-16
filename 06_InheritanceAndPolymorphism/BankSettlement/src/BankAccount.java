public class BankAccount {
    private double balance;
    private String ownerName;
    private int accountNumber;
    private static int nextAccountNumber = 1;

    BankAccount(String ownerName) {
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

    void transferTo(BankAccount otherAccount, double amount) {
        if (withdraw(amount)) {
            otherAccount.deposit(amount);
            System.out.println("Деньги успешно переведены!");
        }
    }

    public String toString() {
        return "На счету " + this.ownerName + " баланс: " + this.balance;
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

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public static int getNextAccountNumber() {
        return nextAccountNumber;
    }

    public static void setNextAccountNumber(int nextAccountNumber) {
        BankAccount.nextAccountNumber = nextAccountNumber;
    }
}
