import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        String[] chars = new String[]{"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х",};
        for (String letter_1 : chars) {
            for (int num = 0; num < 10; num++) {
                for (String letter_2 : chars) {
                    for (String letter_3 : chars) {
                        for (int m = 1; m <= 199; m++) {
                            String numberCar = String.format("%s%d%d%d%s%s(%d)", letter_1, num, num, num, letter_2, letter_3, m);
                            list.add(numberCar);
                        }
                    }
                }
            }
        }
        Collections.sort(list);
        HashSet<String> set = new HashSet<>(list);
        TreeSet<String> set1 = new TreeSet<>(list);
        while (true) {
            System.out.println("Введите номер автомобиля для поиска: ");
            Scanner scanner = new Scanner(System.in);
            String stateNumber = scanner.nextLine();
            long a = System.nanoTime();
            if (list.contains(stateNumber)) {
                System.out.println("Поиск перебором: номер найден, поиск занял: " + (System.nanoTime() - a) + "нс");
            } else {
                System.out.println("Поиск перебором: номер не найден, поиск занял: " + (System.nanoTime() - a) + "нс");
            }
            long b = System.nanoTime();
            if (Collections.binarySearch(list, stateNumber) == 0) {
                System.out.println("Бинарный поиск: номер найден, поиск занял: " + (System.nanoTime() - b) + "нс");
            } else {
                System.out.println("Бинарный поиск: номер не найден, поиск занял: " + (System.nanoTime() - b) + "нс");
            }
            long c = System.nanoTime();
            if (set.contains(stateNumber)) {
                System.out.println("Поиск в HashSet: номер найден, поиск занял: " + (System.nanoTime() - c) + "нс");
            } else {
                System.out.println("Поиск в HashSet: номер не найден, поиск занял: " + (System.nanoTime() - c) + "нс");
            }
            long d = System.nanoTime();
            if (set1.contains(stateNumber)) {
                System.out.println("Поиск в TreeSet: номер найден, поиск занял: " + (System.nanoTime() - d) + "нс");
            } else {
                System.out.println("Поиск в TreeSet: номер не найден, поиск занял: " + (System.nanoTime() - d) + "нс");
            }
        }
    }
}