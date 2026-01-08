import java.util.Arrays;
import java.util.Scanner;

public class NumberCheckerPalindromeAndDuck {
    public static int countDigits(int number) {
        int temp = Math.abs(number);
        if (temp == 0)
            return 1;
        int count = 0;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

    public static int[] getDigits(int number) {
        int temp = Math.abs(number);
        int count = countDigits(number);
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }

    public static int[] reverseDigits(int[] digits) {
        int[] reversed = Arrays.copyOf(digits, digits.length);
        for (int i = 0, j = reversed.length - 1; i < j; i++, j--) {
            int t = reversed[i];
            reversed[i] = reversed[j];
            reversed[j] = t;
        }
        return reversed;
    }

    public static boolean arraysEqual(int[] a, int[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i])
                return false;
        return true;
    }

    public static boolean isPalindrome(int[] digits) {
        return arraysEqual(digits, reverseDigits(digits));
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits)
            if (d == 0)
                return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int[] digits = getDigits(number);
        int[] reversed = reverseDigits(digits);

        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Reversed: " + Arrays.toString(reversed));
        System.out.println("Arrays equal: " + arraysEqual(digits, reversed));
        System.out.println("Is Palindrome: " + isPalindrome(digits));
        System.out.println("Is Duck: " + isDuckNumber(digits));
        input.close();
    }
}
