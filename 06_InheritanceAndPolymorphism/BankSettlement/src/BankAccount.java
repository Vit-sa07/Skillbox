public class BankAccount {
    public double balance;
    public String ownerName;
    public int accountNumber;
    public static int nextAccountNumber = 1;


    BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0.0;
        this.assignNewAccountNumber();
    }

    void assignNewAccountNumber() {
        this.accountNumber = this.nextAccountNumber;
        this.nextAccountNumber = this.nextAccountNumber + 1;
    }


    double getBalance() {
        return this.balance;
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
}
