import java.util.Scanner;

public class NaturalNumberSumComparison {
    public static boolean isNaturalNumber(int n) {
        return n > 0;
    }

    public static long recursiveSum(int n) {
        if (n == 1)
            return 1;
        return n + recursiveSum(n - 1);
    }

    public static long formulaSum(int n) {
        return (long) n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        if (!isNaturalNumber(n)) {
            System.out.println("Input is not a natural number.");
            input.close();
            return;
        }

        long recursiveResult = recursiveSum(n);
        long formulaResult = formulaSum(n);

        System.out.println("Recursive Sum: " + recursiveResult);
        System.out.println("Formula Sum: " + formulaResult);
        System.out.println(recursiveResult == formulaResult ? "Results match" : "Results do not match");
        input.close();
    }
}
