import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    public static final String PATH_TO_SAVE = "data/";

    public static void main(String[] args) {

        System.out.println("\nСписок абсолютных путей \n");
        try {
            Document doc = Jsoup.connect("https://lenta.ru/")
                    .userAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 12_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) CriOS/69.0.3497.105 Mobile/15E148 Safari/605.1")
                    .maxBodySize(0)
                    .get();
            Elements img = doc.getElementsByTag("img");
            ArrayList<String> urls = new ArrayList<>();
            img.forEach(element -> urls.add(element.absUrl("src")));
            urls.forEach(url -> System.out.println(url));
            urls.forEach(url -> downloadImage(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadImage(String url) {
        try (InputStream in = new URL(url).openStream()) {
            String fileName = url.substring(url.lastIndexOf('/') + 1);
            Files.copy(in, Paths.get(PATH_TO_SAVE + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
