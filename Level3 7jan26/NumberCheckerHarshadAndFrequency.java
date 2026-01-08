import java.util.Scanner;

public class NumberCheckerHarshadAndFrequency {
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

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits)
            sum += d;
        return sum;
    }

    public static long sumOfSquaresOfDigits(int[] digits) {
        long sumSq = 0;
        for (int d : digits)
            sumSq += (long) Math.pow(d, 2);
        return sumSq;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return sum != 0 && Math.abs(number) % sum == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits)
            freq[d]++;
        int[][] result = new int[10][2];
        for (int i = 0; i < 10; i++) {
            result[i][0] = i;
            result[i][1] = freq[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int[] digits = getDigits(number);

        int sum = sumOfDigits(digits);
        long sumSquares = sumOfSquaresOfDigits(digits);
        boolean harshad = isHarshadNumber(number, digits);
        int[][] freq = digitFrequency(digits);

        System.out.println("Sum of digits: " + sum);
        System.out.println("Sum of squares of digits: " + sumSquares);
        System.out.println("Is Harshad: " + harshad);
        System.out.println("Digit frequencies (digit:count):");
        for (int i = 0; i < freq.length; i++) {
            System.out.println(freq[i][0] + ": " + freq[i][1]);
        }
        input.close();
    }
}
