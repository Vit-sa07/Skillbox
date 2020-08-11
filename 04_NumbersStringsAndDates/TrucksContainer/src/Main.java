import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int CONTAINERS_IN_TRUCK = 12;
        final int BOXES_IN_CONTAINER = 27;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество коробок:");
        int boxCount = scanner.nextInt();

        final int BOX_IN_TRUCK = BOXES_IN_CONTAINER * CONTAINERS_IN_TRUCK;

        for (int box = 0; box < boxCount; box++) {
            if (box % BOXES_IN_CONTAINER == 0) {
                if (box % BOX_IN_TRUCK == 0) {
                    System.out.println("Грузовик " + (box / BOX_IN_TRUCK + 1));
                }
                System.out.println("Контейнер " + (box / BOXES_IN_CONTAINER + 1));
            }
            System.out.println("Ящик " + (box + 1));
        }
    }
}






