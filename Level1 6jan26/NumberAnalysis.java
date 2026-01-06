import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int index = 0; index < numbers.length; index++) {
            System.out.print("Enter number " + (index + 1) + ": ");
            numbers[index] = scanner.nextInt();
        }

        for (int number : numbers) {
            if (number > 0) {
                System.out.print(number + " is Positive and ");
                System.out.println(number % 2 == 0 ? "Even" : "Odd");
            } else if (number < 0) {
                System.out.println(number + " is Negative");
            } else {
                System.out.println("Number is Zero");
            }
        }

        if (numbers[0] == numbers[numbers.length - 1]) {
            System.out.println("First and Last elements are Equal");
        } else if (numbers[0] > numbers[numbers.length - 1]) {
            System.out.println("First element is Greater");
        } else {
            System.out.println("Last element is Greater");
        }

        scanner.close();
    }
}
