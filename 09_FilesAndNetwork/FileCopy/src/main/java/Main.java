import org.apache.commons.io.FileUtils;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Пожалуйста, введите путь директории, которую хотите скопировать");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String origin = reader.readLine();
        System.out.println("Пожалуйста, введите путь директории, в которую хотите скопировать");
        String target = reader.readLine();
        File sourcepath = new File(origin);
         File destinationepath = new File(target);

        try {
            FileUtils.copyDirectory(sourcepath, destinationepath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}