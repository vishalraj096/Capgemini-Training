import java.util.Random;

public class StudentVotingEligibility {
    static class Student {
        int id;
        int age;
        boolean canVote;
    }

    public static Student[] generateStudents(int n) {
        Random r = new Random();
        Student[] arr = new Student[n];
        for (int i = 0; i < n; i++) {
            Student s = new Student();
            s.id = i + 1;
            s.age = 10 + r.nextInt(90);
            s.canVote = s.age >= 18;
            arr[i] = s;
        }
        return arr;
    }

    public static void displayTable(Student[] students) {
        System.out.printf("%-6s %-6s %-10s\n", "ID", "Age", "CanVote");
        System.out.println("--------------------------");
        int eligible = 0;
        for (Student s : students) {
            System.out.printf("%-6d %-6d %-10s\n", s.id, s.age, s.canVote ? "Yes" : "No");
            if (s.canVote)
                eligible++;
        }
        System.out.println("--------------------------");
        System.out.printf("Total: %d, Eligible: %d, Not Eligible: %d\n", students.length, eligible,
                students.length - eligible);
    }

    public static void main(String[] args) {
        Student[] students = generateStudents(10);
        displayTable(students);
    }
}
