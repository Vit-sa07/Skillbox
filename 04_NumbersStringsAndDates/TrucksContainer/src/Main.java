import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int box = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество коробок:");
        box = scanner.nextInt();
        Cargo cargo = new Cargo(box);
        cargo.result();
    }
}





