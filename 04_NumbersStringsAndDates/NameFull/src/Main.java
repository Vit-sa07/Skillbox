import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ФИО: ");
        String string = scanner.nextLine();
        String[] fio = string.split(" ");
        boolean result = string.matches("(^([А-ЯЁ][а-яё]*-?([А-ЯЁ]?[а-яё]+)) ([А-ЯЁ][а-яё]*-?([А-ЯЁ]?[а-яё]+)) ([А-ЯЁ][а-яё]+[\\s|-]?([А-ЯЁ]?[а-яё]+))$)");
        if (result) {
            System.out.println("Фамилия - " + fio[0]);
            System.out.println("Имя - " + fio[1]);
            System.out.println("Отчество - " + fio[2]);
        } else {
            System.out.println("Фамилия Имя Отчество введены некорректно!");
        }

//        String surname = sc.next();
//        String name = sc.next();
//        String secondName = sc.next();
//
//        System.out.println("Фамилия - " + surname);
//        System.out.println("Имя - " + name);
//        System.out.println("Отчество - " + secondName);

    }
}
