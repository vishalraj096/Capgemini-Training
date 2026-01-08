import java.util.Scanner;

public class StudentVoteChecker {
    public boolean canStudentVote(int age) {
        if (age < 0)
            return false;
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentVoteChecker checker = new StudentVoteChecker();

        int[] ages = new int[10];
        for (int i = 0; i < ages.length; i++) {
            ages[i] = input.nextInt();
        }

        for (int i = 0; i < ages.length; i++) {
            boolean canVote = checker.canStudentVote(ages[i]);
            System.out.println("Student " + (i + 1) + ": " + (canVote ? "Can vote" : "Cannot vote"));
        }
        input.close();
    }
}
