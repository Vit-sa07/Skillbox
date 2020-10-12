import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Пожалуйста, введите путь директории, которую хотите скопировать");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String origin = reader.readLine();
        System.out.println("Пожалуйста, введите путь директории, в которую хотите скопировать");
        String target = reader.readLine();

        Path sourcepath = Paths.get(target);
        Path destinationepath = Paths.get(origin);

        Files.walk(sourcepath)
                .forEach(source -> copy(source, destinationepath.resolve(sourcepath.relativize(source))));
    }

    static void copy(Path source, Path dest) {
        try {
            Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}