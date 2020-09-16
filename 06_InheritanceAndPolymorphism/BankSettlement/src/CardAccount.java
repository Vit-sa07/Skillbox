public class CardAccount extends BankAccount {

    private final double RATE = 0.001;

    CardAccount(String ownerName) {
        super(ownerName);
    }

    @Override
    boolean withdraw(double amount) {
        return super.withdraw(amount + (amount * RATE));
    }

}
