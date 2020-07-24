
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
    private String status;
    private String colorCat;

    public String getColorCat() {
        return colorCat;
    }

    public void setColorCat(String colorCat) {
        this.colorCat = colorCat;
    }

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;
        status = "New";
    }

    public Cat(double weight) {
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
        this.originWeight  = cat.originWeight;
        this.minWeight = cat.minWeight;
        this.maxWeight = cat.minWeight;
        this.eatenFood = cat.eatenFood;
        this.weight = cat.weight;
        return cat;
    }


    public String getStatus() {
        return status;
    }

    void updateStaus() {
        if (weight < minWeight) {
            status = "Dead";
            count--;
        } else if (weight > maxWeight) {
            status = "Exploded";
            count--;
        } else if (weight > originWeight) {
            status = "Sleeping";
        } else {
            status = "Playing";
        }
    }
}