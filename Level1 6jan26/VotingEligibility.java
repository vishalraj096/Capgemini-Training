import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] studentAges = new int[10];

        for (int index = 0; index < studentAges.length; index++) {
            System.out.print("Enter age of student " + (index + 1) + ": ");
            studentAges[index] = scanner.nextInt();
        }

        for (int age : studentAges) {
            if (age < 0) {
                System.out.println("Invalid age.");
            } else if (age >= 18) {
                System.out.println("Student with age " + age + " can vote.");
            } else {
                System.out.println("Student with age " + age + " cannot vote.");
            }
        }

        scanner.close();
    }
}
