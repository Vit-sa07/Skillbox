
public class Loader
{
    public static void main(String[] args)
    {
        Cat Petya = new Cat();
        Cat Fill = new Cat();
        Cat Grisha = new Cat();
        Cat Misha = new Cat();
        Cat Olya = new Cat();
        Cat Serg = new Cat();
        Cat Kolya = new Cat();
        Cat Oleg = new Cat(3000.987);
        Cat Alesha = getKitten();
        Cat Vova = getKitten();
        Cat Kiril = getKitten();


        System.out.println(Cat.getCount());

        System.out.println("Петя весит: " + Petya.getWeight());
        while (Petya.getStatus() != "Dead"){
            Petya.meow();
        }
        System.out.println("Чем же занимается Петя? " + Petya.getStatus());

        System.out.println("Фил весит: " + Fill.getWeight());
        while (Fill.getStatus() != "Exploded"){
            Fill.feed(9.0);
        }
        System.out.println("Фил поел и весит "  + Fill.getWeight());
        System.out.println("Как чувствуешь себя Фил? " + Fill.getStatus());

        System.out.println("Гриша весит " + Grisha.getWeight());
        Grisha.feed(10.0);
        System.out.println("Гриша поел и весит " +  Grisha.getWeight());
        System.out.println("Котик съел " + Grisha.getEatenFood());

        System.out.println("Миша весит " + Misha.getWeight());
        Misha.pee(10.0);
        System.out.println("Миша сходил в туалет и теперь весит " + Misha.getWeight());

        System.out.println(Olya.getWeight());
        Olya.feed(150.0);
        System.out.println(Olya.getWeight());
        Olya.pee(10.0);
        Olya.pee(10.0);
        Olya.pee(10.0);
        System.out.println(Olya.getWeight());
        System.out.println(Olya.getEatenFood());
        System.out.println(Cat.getCount());

        System.out.println("Фил весит: " + Serg.getWeight());
        while (Serg.getStatus() != "Exploded"){
            Serg.feed(9.0);
        }
        System.out.println("Фил поел и весит "  + Serg.getWeight());
        System.out.println("Как чувствуешь себя Фил? " + Serg.getStatus());
        System.out.println(Cat.getCount());
        System.out.println(Oleg.getWeight());
        System.out.println(Alesha.getWeight());

        Kolya.catCopy(Serg);
        System.out.println(Kolya.getWeight());
        System.out.println(Serg.getWeight());



    }

    private static Cat getKitten(){
        return new Cat(1100.00);
    }

}