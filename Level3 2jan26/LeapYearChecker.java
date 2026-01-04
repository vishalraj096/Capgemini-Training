import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int year = input.nextInt();

        if (year < 1582) {
            System.out.println("Year must be 1582 or later");
        } else if (year % 400 == 0) {
            System.out.println("Leap Year");
        } else if (year % 100 == 0) {
            System.out.println("Not a Leap Year");
        } else if (year % 4 == 0) {
            System.out.println("Leap Year");
        } else {
            System.out.println("Not a Leap Year");
        }

        input.close();
    }
}
