import java.util.Date;

public class DepositAccount extends BankAccount {
    Date date1 = new Date();
    Date date2 = new Date();


    public DepositAccount(String ownerName) {
        super(ownerName);
    }

    @Override
    public boolean deposit(double amount) {
        date1.getTime();
        return this.updateBalance(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        date2.getTime();
        long milliseconds = date2.getTime() - date1.getTime();
        int days = (int) (milliseconds / (24 * 60 * 60 * 1000));
        if (days < 30) {
            System.out.println("Вывод средств невозможен! После срока пополнения прошло " + days + " дней");
        }
        return this.updateBalance(-amount);
    }
}

