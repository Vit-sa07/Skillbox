
public class Cat {
    public static final int EYES_NUMBER = 2;
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;
    private double eatenFood = 0;
    private double peeSum;
    private static int count = 0;
    private catsColor colorCat;


    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;
    }

    public Cat(double weight) {
        this();
        this.weight = weight;

    }

    public static int getCount() {
        return count;
    }

    public void meow() {

        weight = weight - 1;
        updateStaus();
        System.out.println("Meow");
    }

    public void feed(Double amount) {
        eatenFood = amount;
        weight = weight + amount;
        updateStaus();
    }


    public Double getEatenFood() {
        return eatenFood;
    }

    public void drink(Double amount) {
        weight = weight + amount;
        updateStaus();
    }


    public Double getWeight() {
        return weight;
    }

    public void pee(Double amount) {
        peeSum = amount;
        weight = weight - amount;
        updateStaus();
    }

    public Cat catCopy(Cat cat)
    {
        Cat clone = new Cat();
        clone.originWeight  = cat.originWeight;
        clone.minWeight = cat.minWeight;
        clone.maxWeight = cat.minWeight;
        clone.eatenFood = cat.eatenFood;
        clone.weight = cat.weight;
        return clone;
    }


    public catsColor getColorCat() {
        return colorCat;
    }

    public void setColorCat(catsColor colorCat) {
        this.colorCat = colorCat;
    }

    public String getStatus() {
        if (weight < minWeight) {
            return "Dead";
        } else if (weight > maxWeight) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }

    void updateStaus() {
        if (weight < minWeight || maxWeight < weight) {
            count--;
        }
    }
}