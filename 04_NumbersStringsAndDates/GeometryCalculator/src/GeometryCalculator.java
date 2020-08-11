public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        double area = Math.PI * (radius * radius);
        return area;
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        double volume = (4*Math.PI*Math.pow(radius, 3))/3;
        return volume;
    }

    public static boolean isTriangleRightAngled(double a, double b, double c) {
        return a < b + c && b < a + c && c < a + b;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTriangleRightAngled, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if (isTriangleRightAngled(a, b, c)) {
            double p = (a + b + c) / 2;
            double p1 = (p - a);
            double p2 = (p - b);
            double p3 = (p - c);
            double pp = p * p1 * p2 * p3;
            double s = Math.sqrt(pp);
            return s;
        }
        return -1.0;
    }
}
