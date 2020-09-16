public class LegalClient extends Client {

    LegalClient(String ownerName) {
        super(ownerName);
    }

    @Override

    public String toString() {
        System.out.println("Пополнение и снятие происходит без комиссии");
        return "На счету  " + getOwnerName() + " баланс: " + getBalance();
    }
}
