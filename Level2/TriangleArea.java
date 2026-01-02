import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double baseCm = input.nextDouble();
        double heightCm = input.nextDouble();

        double areaSqCm = 0.5 * baseCm * heightCm;

        double baseInch = baseCm / 2.54;
        double heightInch = heightCm / 2.54;
        double areaSqInch = 0.5 * baseInch * heightInch;

        System.out.println(
                "The Area of the triangle in sq in is " + areaSqInch +
                        " and sq cm is " + areaSqCm);
    }
}
