import java.util.Scanner;

public class SmallestAndLargest {
    public static int[] findSmallestAndLargest(int a, int b, int c) {
        int smallest = Math.min(a, Math.min(b, c));
        int largest = Math.max(a, Math.max(b, c));
        return new int[] { smallest, largest };
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        int[] result = findSmallestAndLargest(a, b, c);
        System.out.println("Smallest: " + result[0] + ", Largest: " + result[1]);

        input.close();
    }
}
