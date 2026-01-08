import java.util.Scanner;

public class NumberCheckerExtremes {
    public static int countDigits(int number) {
        int count = 0;
        int temp = Math.abs(number);
        if (temp == 0)
            return 1;
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

    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits)
            if (d == 0)
                return true;
        return false;
    }

    public static boolean isArmstrong(int number, int[] digits) {
        int count = digits.length;
        long sum = 0;
        for (int d : digits)
            sum += (long) Math.pow(d, count);
        return sum == Math.abs(number);
    }

    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int d : digits) {
            if (d > largest) {
                second = largest;
                largest = d;
            } else if (d > second && d != largest) {
                second = d;
            }
        }
        return new int[] { largest, second };
    }

    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int d : digits) {
            if (d < smallest) {
                second = smallest;
                smallest = d;
            } else if (d < second && d != smallest) {
                second = d;
            }
        }
        return new int[] { smallest, second };
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int[] digits = getDigits(number);

        boolean duck = isDuckNumber(digits);
        boolean armstrong = isArmstrong(number, digits);
        int[] maxes = findLargestAndSecondLargest(digits);
        int[] mins = findSmallestAndSecondSmallest(digits);

        System.out.println("Digits count: " + digits.length);
        System.out.print("Digits: ");
        for (int d : digits)
            System.out.print(d + " ");
        System.out.println();
        System.out.println("Is Duck: " + duck);
        System.out.println("Is Armstrong: " + armstrong);
        System.out.println(
                "Largest: " + maxes[0] + ", Second Largest: " + (maxes[1] == Integer.MIN_VALUE ? "N/A" : maxes[1]));
        System.out.println(
                "Smallest: " + mins[0] + ", Second Smallest: " + (mins[1] == Integer.MAX_VALUE ? "N/A" : mins[1]));
        input.close();
    }
}
