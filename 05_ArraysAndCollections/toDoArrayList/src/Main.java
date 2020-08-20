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


        while (true) {

            System.out.println("Введите команду:");
            System.out.println("Список команд:\nLIST открывает список, ADD добавляет дело в список, EDIT изменияет старое дело на новое, DELETE удаляет дело из списка");

            Scanner sc = new Scanner(System.in);
            String command = sc.nextLine();


            switch (command) {
                case "LIST":
                    for (int i = 0; i < toDoList.size(); i++) {
                        System.out.println(i + " - " + toDoList.get(i));
                    }
                    break;

                case "ADD":
                    System.out.println("Список дел перед добавлением новой задачи :" + toDoList);
                    System.out.println("Введите дело, которое нужно добавить в списиок");
                    String add = sc.nextLine();
                    toDoList.add(add);
                    System.out.println("Список дел после добавления новой задачи :" + toDoList);

                    break;

                case "ADD INDEX":

                    System.out.println("Список дел перед добавлением новой задачи :" + toDoList);
                    System.out.println("Введите индекс места куда вы хотите добавить дело");
                    int edIn = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Введите дело, которое нужно добавить в списиок");
                    String addIndex = sc.next();
                    toDoList.add(edIn, addIndex);
                    System.out.println("Список дел после добавления новой задачи :" + toDoList);
                    break;

                case "EDIT":
                    System.out.println("Список дел перед изменением задачи " + toDoList);
                    System.out.println("Введите индекс изменениемого дела");
                    int ed = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Введите дело, которое нужно добавить в списиок");
                    String ede = sc.next();
                    toDoList.set(ed, ede);
                    System.out.println("Список дел после изменения задачи " + toDoList);
                    break;

                case "DELETE":
                    System.out.println("Список дел перед удалением задачи " + toDoList);
                    System.out.println("Введите индекс удаляемого дела");
                    int del = sc.nextInt();
                    toDoList.remove(del);
                    System.out.println("Список дел после удаления задачи " + toDoList);
                    break;

                case "EXIT":
                    System.exit(0);

                default:
                    System.out.println("Вы ввели неправильную команду! Пожалуйста, попробуйте еще раз или введите EXIT для выхода");
            }
        }
    }
}