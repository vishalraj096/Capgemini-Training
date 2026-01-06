import java.util.Scanner;

public class MultiplicationSixToNine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int[] results = new int[4];
        int index = 0;

        for (int i = 6; i <= 9; i++) {
            results[index++] = number * i;
        }

        index = 0;
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + results[index++]);
        }

        scanner.close();
    }
}
