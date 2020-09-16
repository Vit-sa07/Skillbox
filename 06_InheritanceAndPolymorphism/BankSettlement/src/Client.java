public abstract class Client extends BankAccount {

    Client(String ownerName) {
        super(ownerName);
    }

    public String toString() {
        return "На счету  " + getOwnerName() + " баланс: " + getBalance();
    }
}
