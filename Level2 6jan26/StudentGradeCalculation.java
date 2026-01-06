import java.util.Scanner;

public class StudentGradeCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = scanner.nextInt();

        int[][] marks = new int[numberOfStudents][3];
        double[] percentages = new double[numberOfStudents];
        char[] grades = new char[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            for (int j = 0; j < 3; j++) {
                int mark = scanner.nextInt();
                if (mark < 0) {
                    j--;
                    continue;
                }
                marks[i][j] = mark;
            }
        }

        for (int i = 0; i < numberOfStudents; i++) {
            int totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = totalMarks / 3.0;

            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println(
                    "Student " + (i + 1) +
                            " | Physics: " + marks[i][0] +
                            " | Chemistry: " + marks[i][1] +
                            " | Maths: " + marks[i][2] +
                            " | Percentage: " + percentages[i] +
                            " | Grade: " + grades[i]);
        }

        scanner.close();
    }
}
