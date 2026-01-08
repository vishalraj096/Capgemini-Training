import java.util.Scanner;

public class EuclideanDistanceAndLine {
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static double[] computeLineEquation(double x1, double y1, double x2, double y2) {
        if (x2 == x1) {
            return new double[] { Double.POSITIVE_INFINITY, x1 };
        }
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        return new double[] { m, b };
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        double distance = calculateDistance(x1, y1, x2, y2);
        double[] line = computeLineEquation(x1, y1, x2, y2);

        System.out.println("Distance: " + String.format("%.4f", distance));
        if (Double.isInfinite(line[0])) {
            System.out.println("Line: x = " + line[1]);
        } else {
            System.out.println(
                    "Line: y = " + String.format("%.4f", line[0]) + " * x + " + String.format("%.4f", line[1]));
        }
        input.close();
    }
}
