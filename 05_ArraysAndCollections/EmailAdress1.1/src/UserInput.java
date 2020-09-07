import java.util.Scanner;

public class UserInput {
    public static String getLine() {
        System.out.println("Список команд: LIST открывает список email, ADD добавляет email в список");
        System.out.println("Введите команду:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }
}
