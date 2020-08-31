import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String regex = "^(.+)@(.+)$";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(regex);
        System.out.println("Список команд: LIST открывает список email, ADD добавляет email в список");
        TreeSet<String> emailAdress = new TreeSet<>();
        System.out.println("Введите команду:");
        System.out.println("Список команд:\nLIST открывает список, ADD добавляет дело в список, EDIT изменияет старое дело на новое, DELETE удаляет дело из списка");
        while (true) {
            System.out.println("Введите команду:");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            String[] words = str.split("\\s");
            if (words[0].equals("LIST")) {
                for (String i : emailAdress) {
                    System.out.println(i);
                }
            } else {
                String item = str.substring(str.indexOf(' ')).trim();
                if (words.length == 2) {
                    if (words[0].equalsIgnoreCase("ADD")) {
                        Matcher matcher = pattern.matcher(item);
                        if (matcher.matches()) {
                            emailAdress.add(item);
                            System.out.println("Адресс электронной почты " + item + " - введен верно.");
                        } else {
                            System.out.println("Адресс электронной почты " + item + " - введен неверно. Попробуйте еще раз!.");
                        }
                    }
                }
            }
        }
    }
}





