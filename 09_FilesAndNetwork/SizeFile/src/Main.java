import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь до папки:");
        String path = scanner.nextLine();

        long size = getFolderSize(path);
        System.out.println("Размер папки " + getFileSizeToString(size));

    }

    public static long getFolderSize(String path) throws IOException {
        Path folder = Paths.get(path);
        return Files.walk(folder)
                .map(Path::toFile)
                .filter(File::isFile)
                .mapToLong(File::length)
                .sum();
    }

    private static String getFileSizeToString(Long length) {
        if (length < Math.pow(1024, 2)) {
            return new DecimalFormat("#0.00").format((double) length / 1024) + " Кб.";
        }
        if (length < Math.pow(1024, 3)) {
            return new DecimalFormat("#0.00").format((double) length / Math.pow(1024, 2)) + " Мб.";
        }
        if (length >= Math.pow(1024, 3)) {
            return new DecimalFormat("#0.00").format((double) length / Math.pow(1024, 3)) + " Гб.";
        }
        return length + " байт.";
    }
}
