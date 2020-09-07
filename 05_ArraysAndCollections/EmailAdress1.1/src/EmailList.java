import java.util.TreeSet;

public class EmailList {
    private static final String regex = "^(.+)@(.+)$";
    private static TreeSet<String> emailAdress = new TreeSet<>();

    public static void printList() {
        for (String i : emailAdress) {
            System.out.println(i);
        }
    }

    public static void add(String email) {
        boolean emailValid = true;
        emailValid = email.matches(regex);
        if (emailValid == true) {
            emailAdress.add(email);
            System.out.println("Адрес электрной почты добавлен в список.");
        } else {
            System.out.println("Адрес электронной почты введен неверено! Попробуйте еще раз!");
        }
    }
}
