import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int physicsMarks = input.nextInt();
        int chemistryMarks = input.nextInt();
        int mathsMarks = input.nextInt();

        double averageMarks = (physicsMarks + chemistryMarks + mathsMarks) / 3.0;

        System.out.println("Average Marks: " + averageMarks);

        if (averageMarks >= 80) {
            System.out.println("Grade: A");
            System.out.println("Remarks: Level 4, above agency-normalized standards");
        } else if (averageMarks >= 70) {
            System.out.println("Grade: B");
            System.out.println("Remarks: Level 3, at agency-normalized standards");
        } else if (averageMarks >= 60) {
            System.out.println("Grade: C");
            System.out.println("Remarks: Level 2, below but approaching agency-normalized standards");
        } else if (averageMarks >= 50) {
            System.out.println("Grade: D");
            System.out.println("Remarks: Level 1, well below agency-normalized standards");
        } else if (averageMarks >= 40) {
            System.out.println("Grade: E");
            System.out.println("Remarks: Level 1-, too below agency-normalized standards");
        } else {
            System.out.println("Grade: R");
            System.out.println("Remarks: Remedial standards");
        }

        input.close();
    }
}
