import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] text = {"Каждый ", " охотник ", " желает ", " знать ", " где ", " сидит ", " фазан "};
        List arr = Arrays.asList(text);
        Collections.reverse(arr);
        System.out.println(arr);
        System.out.println(text[1]);
    }
}
