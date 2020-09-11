public class BankAccount {
    public double balance;
    public String ownerName;
    public int accountNumber;
    public static int nextAccountNumber = 1;
    public final double RATE = 0.001;


    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0.0;
        this.assignNewAccountNumber();
    }

    public void assignNewAccountNumber() {
        this.accountNumber = this.nextAccountNumber;
        this.nextAccountNumber = this.nextAccountNumber + 1;
    }


    public double getBalance() {
        return this.balance;
    }

    public boolean deposit(double amount) {
        return this.updateBalance(amount);

    }

    public boolean withdraw(double amount) {
        return this.updateBalance(-amount);
    }

    public boolean updateBalance(double amount) {
        double sum = this.balance + amount;
        if (sum < 0) {
            System.out.println("У вас недостаточно средств!");
            return false;
        } else {
            this.balance = sum;
            return true;
        }
    }

    public void transferTo(BankAccount otherAccount, double amount) {
        if (withdraw(amount)) {
            otherAccount.deposit(amount);
            System.out.println("Деньги успешно переведены!");
        }
    }

    public String toString() {
        return "На счету " + this.ownerName + " баланс: " + this.balance;
    }
}
