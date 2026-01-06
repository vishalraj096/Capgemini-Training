import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int[] frequency = new int[10];

        while (number != 0) {
            int digit = number % 10;
            frequency[digit]++;
            number /= 10;
        }

        for (int i = 0; i < frequency.length; i++) {
            System.out.println("Digit " + i + " = " + frequency[i]);
        }

        scanner.close();
    }
}
