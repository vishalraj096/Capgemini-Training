import java.util.Scanner;

public class CollinearityChecker {
    private static final double EPSILON = 1e-9;

    public static boolean areCollinearBySlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        double lhs = (y2 - y1) * (x3 - x1);
        double rhs = (y3 - y1) * (x2 - x1);
        return Math.abs(lhs - rhs) < EPSILON;
    }

    public static double triangleArea(double x1, double y1,
            double x2, double y2,
            double x3, double y3) {
        double area = 0.5 * Math.abs(
                x1 * (y2 - y3) +
                        x2 * (y3 - y1) +
                        x3 * (y1 - y2));
        return area;
    }

    public static boolean areCollinearByArea(double x1, double y1,
            double x2, double y2,
            double x3, double y3) {
        return triangleArea(x1, y1, x2, y2, x3, y3) < EPSILON;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();

        boolean collinearBySlope = areCollinearBySlope(x1, y1, x2, y2, x3, y3);
        double area = triangleArea(x1, y1, x2, y2, x3, y3);
        boolean collinearByArea = area < EPSILON;

        System.out.println("Collinear by slope method: " + collinearBySlope);
        System.out.println("Triangle area: " + String.format("%.6f", area));
        System.out.println("Collinear by area method: " + collinearByArea);

        input.close();
    }
}
