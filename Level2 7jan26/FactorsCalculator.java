import java.util.Arrays;
import java.util.Scanner;

public class FactorsCalculator {
    public static int[] findFactors(int number) {
        int factorCount = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0)
                factorCount++;
        }
        int[] factors = new int[factorCount];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0)
                factors[index++] = i;
        }
        return factors;
    }

    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors)
            sum += f;
        return sum;
    }

    public static long productOfFactors(int[] factors) {
        long product = 1L;
        for (int f : factors)
            product *= f;
        return product;
    }

    public static long sumOfSquaresOfFactors(int[] factors) {
        long sumSquares = 0L;
        for (int f : factors)
            sumSquares += (long) Math.pow(f, 2);
        return sumSquares;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        int[] factors = findFactors(number);
        System.out.println("Factors: " + Arrays.toString(factors));

        int sum = sumOfFactors(factors);
        long product = productOfFactors(factors);
        long sumSquares = sumOfSquaresOfFactors(factors);

        System.out.println("Sum of factors: " + sum);
        System.out.println("Product of factors: " + product);
        System.out.println("Sum of squares of factors: " + sumSquares);
        input.close();
    }
}
