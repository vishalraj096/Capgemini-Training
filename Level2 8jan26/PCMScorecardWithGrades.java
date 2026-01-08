import java.util.Random;

public class PCMScorecardWithGrades {
    static class Student {
        int id;
        int physics;
        int chemistry;
        int maths;
        int total;
        double average;
        double percentage;
        char grade;
    }

    public static char gradeFromPercent(double p) {
        if (p >= 80) return 'A';
        if (p >= 70) return 'B';
        if (p >= 60) return 'C';
        if (p >= 50) return 'D';
        if (p >= 40) return 'E';
        return 'R';
    }

    public static Student[] generate(int n) {
        Random r = new Random();
        Student[] arr = new Student[n];
        for (int i = 0; i < n; i++) {
            Student s = new Student();
            s.id = i + 1;
            s.physics = 10 + r.nextInt(90); // 10..99
            s.chemistry = 10 + r.nextInt(90);
            s.maths = 10 + r.nextInt(90);
            s.total = s.physics + s.chemistry + s.maths;
            s.average = s.total / 3.0;
            s.percentage = s.total * 100.0 / 300.0;
            s.grade = gradeFromPercent(s.percentage);
            arr[i] = s;
        }
        return arr;
    }

    public static void display(Student[] arr) {
        System.out.printf("%-5s %-8s %-10s %-8s %-7s %-10s %-8s %-6s\n",
                "ID", "Physics", "Chemistry", "Maths", "Total", "Average", "Percent", "Grade");
        System.out.println("----------------------------------------------------------------------------");
        for (Student s : arr) {
            System.out.printf("%-5d %-8d %-10d %-8d %-7d %-10.2f %-8.2f %-6c\n",
                    s.id, s.physics, s.chemistry, s.maths, s.total, s.average, s.percentage, s.grade);
        }
    }

    public static void main(String[] args) {
        Student[] students = generate(10);
        display(students);
    }
}
