import java.time.LocalDate;
import java.time.LocalTime;


public class DepositAccount extends BankAccount {
    LocalDate today = LocalDate.now();

    public DepositAccount(String ownerName) {
        super(ownerName);
    }

    @Override
    public boolean deposit(double amount) {
        today.atTime(LocalTime.now());
        return this.updateBalance(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        if (today.isAfter(today.plusMonths(1))) {
            System.out.println("Вывод средств невозможен! После срока пополнения прошло менее 30 дней");
        } else {
            System.out.println("Деньги успешно сняты!");
        }
        return super.withdraw(amount);
    }
}

