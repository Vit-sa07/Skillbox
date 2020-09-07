import java.util.*;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern PHONE_PATTERN = Pattern.compile("\\+\\d{4,}");
    private static final Pattern NAME_PATTERN = Pattern.compile("[А-Я][а-я]*( [А-Я][а-я]*)?");

    public static boolean isPhone(String string) {
        return PHONE_PATTERN.matcher(string).matches();
    }

    public static boolean isName(String string) {
        return NAME_PATTERN.matcher(string).matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phonebook = new HashMap<>();

        for (; ; ) {
            System.out.println("Введите команду:");
            String command = scanner.nextLine();
            command = command.trim();

            if (command.equals("LIST")) {
                Collection<String> sorted = sortByValueAsString(phonebook);
                for ( String entry : sorted) {
                        System.out.println(entry);
                }
            } else if (isPhone(command)) {
                if (phonebook.containsKey(command)) {
                    System.out.println("Номер телефона " + phonebook.get(command));
                } else {
                    System.out.println("Введите имя для номера телефона " + command);
                    String name = scanner.nextLine();
                    if (isName(name)) {
                        System.out.println("Спасибо");
                        phonebook.put(command, name);
                    } else {
                        System.out.println("Некорректное имя. Попробуйте еще раз!");
                    }
                }
            } else if (isName(command)) {
                boolean found = false;
                for (Map.Entry<String, String> entry : phonebook.entrySet()) {
                    if (entry.getValue().equals(command)) {
                        System.out.println(command + " телефон " + entry.getKey());
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Ничего не введено");
                    System.out.println("Введите номера телефона " + command);
                    String number = scanner.nextLine();
                    if (!isPhone(number)) {
                        System.out.println("Некорректное номер. Попробуйте еще раз!");
                    } else if (phonebook.containsKey(number)) {
                        System.out.println("Номер занят!");
                    } else {
                        System.out.println("Спасибо");
                        phonebook.put(number, command);
                    }
                }
            } else {
                System.out.println("Не правильная команда");
            }
        }
    }

    public static Collection<String> sortByValueAsString(Map<String, String> map){
        TreeSet<String> result = new TreeSet<>();
        for (Map.Entry<String, String> entry : map.entrySet()){
            result.add(entry.getValue() + " номер " + entry.getKey());
        }
        return result;
    }
}

