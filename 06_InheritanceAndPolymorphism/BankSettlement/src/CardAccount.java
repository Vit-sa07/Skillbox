public class CardAccount extends BankAccount {


    public CardAccount(String ownerName) {
        super(ownerName);
    }

    @Override
    public boolean withdraw(double amount) {
        double i = amount * RATE;
        this.balance = this.balance - amount - i;
        return true;
    }

}
