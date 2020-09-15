import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private LocalDate created;


    DepositAccount(String ownerName) {
        super(ownerName);
    }

    @Override
    boolean deposit(double amount) {
        created = LocalDate.now();
        return this.updateBalance(amount);
    }


    @Override
    boolean withdraw(double amount) {
        LocalDate update;
        update = LocalDate.now();
        if (created.isAfter(update.minusMonths(1))) {
            System.out.println("Вывод средств невозможен! После срока пополнения прошло менее 30 дней");
        } else {
            System.out.println("Деньги успешно сняты!");
        }
        return false;
    }
}

