import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    private final static double BYTE = 1024;
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь до папки:");
        File path = new File(scanner.nextLine());
        long size = getFolderSize(path);
        System.out.println("Размер папки " + getFileSizeToString(size));

    }

//    ========================================================================

    // С помощью библиотеки Files

    public static long getFolderSize(File path) throws IOException {
        Path folder = Paths.get(String.valueOf(path));
        return Files.walk(folder)
                .map(Path::toFile)
                .filter(File::isFile)
                .mapToLong(File::length)
                .sum();
    }

//    ========================================================================

// С помощью цикла

    //    private static long getFolderSize(File folder) {

//    }

//    ========================================================================

    //    С помощью рекурсии
//    public static long getFolderSize(File directory) {
//        long length = 0;
//        for (File file : directory.listFiles()) {
//            if (file.isFile())
//                length += file.length();
//            else
//                length += getFolderSize(file);
//        }
//        return length;
//    }


    private static String getFileSizeToString(Long length) {
        if (length < Math.pow(BYTE, 2)) {
            return new DecimalFormat("#0.00").format((double) length / BYTE) + " Кб.";
        }
        if (length < Math.pow(BYTE, 3)) {
            return new DecimalFormat("#0.00").format((double) length / Math.pow(BYTE, 2)) + " Мб.";
        }
        if (length >= Math.pow(BYTE, 3)) {
            return new DecimalFormat("#0.00").format((double) length / Math.pow(BYTE, 3)) + " Гб.";
        }
        return length + " байт.";
    }
}
