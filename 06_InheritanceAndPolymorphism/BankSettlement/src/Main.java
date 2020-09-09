public class Main {
    public static void main(String[] args) {
        CardAccount myAccount = new CardAccount("Иван Иванов");
        myAccount.deposit(100.00);
        myAccount.deposit(250.00);
        myAccount.withdraw(50.00);
        System.out.println(myAccount);

        DepositAccount yourAccount = new DepositAccount("Рига Рижская");
        yourAccount.deposit(75.50);
        yourAccount.withdraw(20.00);
        System.out.println(yourAccount);

        yourAccount.withdraw(1000000.00);
        System.out.println(yourAccount);

        myAccount.transferTo(yourAccount, 60.00);

        System.out.println(myAccount);
        System.out.println(yourAccount);

    }
}
