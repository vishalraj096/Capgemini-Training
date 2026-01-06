import java.util.Scanner;

public class StoreAndSumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] values = new double[10];
        double total = 0.0;
        int index = 0;

        while (true) {
            System.out.print("Enter a number: ");
            double input = scanner.nextDouble();

            if (input <= 0 || index == values.length) {
                break;
            }

            values[index++] = input;
        }

        for (int i = 0; i < index; i++) {
            total += values[i];
            System.out.println(values[i]);
        }

        System.out.println("Total Sum = " + total);

        scanner.close();
    }
}
