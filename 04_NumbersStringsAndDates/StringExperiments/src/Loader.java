
public class Loader {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

//        System.out.println((text));

    int v1 = text.indexOf("Вася заработал");
    int v2 = text.indexOf("руб");
    String str1 = text.substring(v1 + 14, v2).trim();

    int m1 = text.indexOf("Маша - ");
    int m2 = text.lastIndexOf("руб");
    String str2 = text.substring(m1 + 6, m2).trim();
    int symma = Integer.parseInt(str1)+Integer.parseInt(str2);
        System.out.println("Вася и Маша заработали " + symma + " руб.");
    }
}