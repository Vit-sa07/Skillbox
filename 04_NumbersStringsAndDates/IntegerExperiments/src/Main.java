public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.count += 7843;
        System.out.println(container.count);
        System.out.println(sumDigits(12345));
        System.out.println(sumDigits(10));
        System.out.println(sumDigits(5059191));



    }


    public static Integer sumDigits(Integer number) {
        //@TODO: write code here
        String stringNum = Integer.toString(number);
        int sum = 0;
        for (int i = 0; i < stringNum.length(); i++){
            sum += Integer.parseInt(String.valueOf(stringNum.charAt(i)));
        }
        return sum;



//            int sum = 0;
//            while (number > 0) {
//                sum += number % 10;
//                number /= 10;
//            }
//            return sum;
        }
    }




