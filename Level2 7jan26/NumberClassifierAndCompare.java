import java.util.Scanner;

public class NumberClassifierAndCompare {
    public static boolean isPositive(int number) {
        return number >= 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int a, int b) {
        if (a > b)
            return 1;
        if (a == b)
            return 0;
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }

        for (int number : numbers) {
            if (isPositive(number)) {
                System.out.println(number + " is Positive and " + (isEven(number) ? "Even" : "Odd"));
            } else {
                System.out.println(number + " is Negative");
            }
        }

        int result = compare(numbers[0], numbers[numbers.length - 1]);
        if (result == 0) {
            System.out.println("First and Last elements are Equal");
        } else if (result == 1) {
            System.out.println("First element is Greater than Last element");
        } else {
            System.out.println("First element is Less than Last element");
        }
        input.close();
    }
}
