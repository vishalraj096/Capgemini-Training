import java.util.Arrays;
import java.util.Scanner;

public class NumberCheckerFactorAnalysis {
    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++)
            if (number % i == 0)
                count++;
        int[] factors = new int[count];
        int idx = 0;
        for (int i = 1; i <= number; i++)
            if (number % i == 0)
                factors[idx++] = i;
        return factors;
    }

    public static int greatestProperFactor(int number, int[] factors) {
        int greatest = 1;
        for (int f : factors)
            if (f < number && f > greatest)
                greatest = f;
        return greatest;
    }

    public static long sumOfFactors(int[] factors) {
        long sum = 0;
        for (int f : factors)
            sum += f;
        return sum;
    }

    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int f : factors)
            product *= f;
        return product;
    }

    public static long productOfCubesOfFactors(int[] factors) {
        long product = 1;
        for (int f : factors)
            product *= (long) Math.pow(f, 3);
        return product;
    }

    public static boolean isPerfectNumber(int number) {
        int[] factors = findFactors(number);
        long sumProper = 0;
        for (int f : factors)
            if (f < number)
                sumProper += f;
        return sumProper == number;
    }

    public static boolean isAbundantNumber(int number) {
        int[] factors = findFactors(number);
        long sumProper = 0;
        for (int f : factors)
            if (f < number)
                sumProper += f;
        return sumProper > number;
    }

    public static boolean isDeficientNumber(int number) {
        int[] factors = findFactors(number);
        long sumProper = 0;
        for (int f : factors)
            if (f < number)
                sumProper += f;
        return sumProper < number;
    }

    public static boolean isStrongNumber(int number) {
        int temp = Math.abs(number);
        int sum = 0;
        if (temp == 0)
            return false;
        while (temp > 0) {
            int d = temp % 10;
            sum += factorial(d);
            temp /= 10;
        }
        return sum == Math.abs(number);
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++)
            result *= i;
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int[] factors = findFactors(number);

        int greatestFactor = greatestProperFactor(number, factors);
        long sum = sumOfFactors(factors);
        long product = productOfFactors(factors);
        long productCubes = productOfCubesOfFactors(factors);

        System.out.println("Factors: " + Arrays.toString(factors));
        System.out.println("Greatest proper factor: " + greatestFactor);
        System.out.println("Sum of factors: " + sum);
        System.out.println("Product of factors: " + product);
        System.out.println("Product of cubes of factors: " + productCubes);
        System.out.println("Is Perfect: " + isPerfectNumber(number));
        System.out.println("Is Abundant: " + isAbundantNumber(number));
        System.out.println("Is Deficient: " + isDeficientNumber(number));
        System.out.println("Is Strong: " + isStrongNumber(number));
        input.close();
    }
}
