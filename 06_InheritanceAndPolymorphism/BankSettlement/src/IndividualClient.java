public class IndividualClient extends Client {
    private final double RATE = 0.001;


    IndividualClient(String ownerName) {
        super(ownerName);
    }

    @Override

    public String toString() {
        System.out.println("Пополнение происходит без комиссии. Снятие осуществляется с коммисией в 1%.");
        return "На счету  " + getOwnerName() + " баланс: " + getBalance();
    }

    @Override
    boolean withdraw(double amount) {
        return super.withdraw(amount + (amount * RATE));
    }

}
