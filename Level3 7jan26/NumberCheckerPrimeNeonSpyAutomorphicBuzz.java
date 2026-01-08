import java.util.Scanner;

public class NumberCheckerPrimeNeonSpyAutomorphicBuzz {
    public static boolean isPrime(int number) {
        if (number <= 1)
            return false;
        if (number == 2)
            return true;
        if (number % 2 == 0)
            return false;
        for (int i = 3; i * i <= number; i += 2)
            if (number % i == 0)
                return false;
        return true;
    }

    public static boolean isNeonNumber(int number) {
        long square = (long) number * number;
        int sum = 0;
        long temp = square;
        while (temp > 0) {
            sum += (int) (temp % 10);
            temp /= 10;
        }
        return sum == number;
    }

    public static boolean isSpyNumber(int number) {
        int sum = 0;
        int product = 1;
        int temp = Math.abs(number);
        if (temp == 0)
            return false;
        while (temp > 0) {
            int d = temp % 10;
            sum += d;
            product *= d;
            temp /= 10;
        }
        return sum == product;
    }

    public static boolean isAutomorphic(int number) {
        long square = (long) number * number;
        int temp = Math.abs(number);
        int pow = 1;
        while (pow <= temp)
            pow *= 10;
        return square % pow == temp;
    }

    public static boolean isBuzz(int number) {
        return number % 7 == 0 || Math.abs(number) % 10 == 7;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        System.out.println("Is Prime: " + isPrime(number));
        System.out.println("Is Neon: " + isNeonNumber(number));
        System.out.println("Is Spy: " + isSpyNumber(number));
        System.out.println("Is Automorphic: " + isAutomorphic(number));
        System.out.println("Is Buzz: " + isBuzz(number));
        input.close();
    }
}
