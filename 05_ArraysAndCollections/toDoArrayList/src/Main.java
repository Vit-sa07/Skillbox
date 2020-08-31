import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        ArrayList<String> toDoList = new ArrayList<>() {{
            add(0, "Почистить зубы");
            add(1, "Сделать зарядку");
            add(2, "Выпить стакан воды");
            add(3, "Приготовить завтрак");
            add(4, "Отправиться на работу");

        }};
        System.out.println("Введите команду:");
        System.out.println("Список команд:\nLIST открывает список, ADD добавляет дело в список, EDIT изменияет старое дело на новое, DELETE удаляет дело из списка");
        while (true) {
            System.out.println("Введите команду:");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            String[] words = str.split("\\s");
            if (words[0].equals("LIST")) {
                for (int i = 0; i < toDoList.size(); i++) {
                    System.out.println(i + " " + toDoList.get(i));
                }
            } else {
                String index = words[1].replaceAll("[^0-9]", "");
                String item = str.substring(str.indexOf(' ')).trim();
                if (words.length == 2) {
                    if (words[0].equalsIgnoreCase("DELETE")) {
                        int indexValue = Integer.parseInt(index);
                        if (indexValue >= toDoList.size()) {
                            System.out.println("Номер дела введён неверно!");
                        } else {
                            toDoList.remove(indexValue);
                            System.out.println("Дело удалено!");
                        }
                    } else if (words[0].equalsIgnoreCase("ADD")) {
                        toDoList.add(item);
                    }
                } else if (words.length > 2) {
                    String itemWOIndex = item.substring(item.indexOf(' ')).trim();
                    if (index.isEmpty()) {
                        toDoList.add(item);
                        System.out.println("Дело добавлено!");
                    } else {
                        int indexValue = Integer.parseInt(index);
                        if (words[0].equalsIgnoreCase("ADD")) {
                            if (indexValue >= toDoList.size()) {
                                toDoList.add(itemWOIndex);
                            } else {
                                toDoList.add(indexValue, itemWOIndex);
                                System.out.println("Дело добавлено!");
                            }
                        } else if (words[0].equalsIgnoreCase("EDIT")) {
                            if (indexValue > toDoList.size()) {
                                System.out.println("Номер дела введён неверно!");
                            } else {
                                toDoList.remove(indexValue);
                                toDoList.add(indexValue, itemWOIndex);
                                System.out.println("Дело изменено!");
                            }
                        }
                    }
                }
            }
        }
    }
}