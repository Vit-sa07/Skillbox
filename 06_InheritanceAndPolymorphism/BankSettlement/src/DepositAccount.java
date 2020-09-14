import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    public LocalDate update;
    public LocalDate created;


    public DepositAccount(String ownerName) {
        super(ownerName);
    }

    @Override
    public boolean deposit(double amount) {
        created = LocalDate.now();
        return this.updateBalance(amount);
    }


    @Override
    public boolean withdraw(double amount) {
        update = LocalDate.now();
        if (created.isAfter(update.minusMonths(1))) {
            System.out.println("Вывод средств невозможен! После срока пополнения прошло менее 30 дней");
        } else {
            System.out.println("Деньги успешно сняты!");
        }
        return false;
    }
}

