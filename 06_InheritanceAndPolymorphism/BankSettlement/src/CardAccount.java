public class CardAccount extends BankAccount {


    public CardAccount(String ownerName) {
        super(ownerName);
    }

    @Override
    public boolean withdraw(double amount) {
        double sum = this.balance + amount;
        if (sum < 0) {
            System.out.println("У вас недостаточно средств!");
            return false;
        } else {
            double i = amount * RATE;
            this.balance = this.balance - amount - i;
            return true;
        }
    }
}
