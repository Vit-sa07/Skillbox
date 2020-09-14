public class CardAccount extends BankAccount {
    public final double RATE = 0.001;



    public CardAccount(String ownerName) {
        super(ownerName);
    }

    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount + (amount * RATE));
    }
}
