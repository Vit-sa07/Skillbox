public class IndividualEntrepreneurClient extends Client {
    private final double RATE1 = 0.0005;
    private final double RATE2 = 0.001;


    IndividualEntrepreneurClient(String ownerName) {
        super(ownerName);
    }

    @Override

    public String toString() {
        System.out.println("Пополнение баланса осуществляется с комиссией 1%, если сумма меньше 1000 рублей." + "\n" + "Если сумма больше либо равна 1000 рублей с комиссией 0,5%. Снятие происходит без комиссии.");
        return "На счету  " + getOwnerName() + " баланс: " + getBalance();
    }

    @Override
    boolean deposit(double amount) {
        if (amount >= 1000) {
            return super.deposit(amount - (amount * RATE1));
        } else if (amount < 1000) {
            return super.deposit(amount - (amount * RATE2));
        }
        return true;
    }
}
