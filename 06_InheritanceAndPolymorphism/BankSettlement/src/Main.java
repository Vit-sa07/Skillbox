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

        IndividualEntrepreneurClient por = new IndividualEntrepreneurClient("Петр Иванов");
        por.deposit(300.00);
        por.withdraw(436.00);
        System.out.println(por);

        LegalClient bss = new LegalClient("Ваня Иванов");
        bss.deposit(500.00);
        bss.withdraw(436.00);
        System.out.println(bss);

        IndividualClient jkj = new IndividualClient("Ваня Иванов");
        jkj.deposit(500.00);
        jkj.withdraw(436.00);
        System.out.println(jkj);

//        yourAccount.withdraw(1000000.00);
//        System.out.println(yourAccount);
//
//        myAccount.transferTo(yourAccount, 60.00);
//
//        System.out.println(myAccount);
//        System.out.println(yourAccount);

    }
}
