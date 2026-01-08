import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class BMIReport {
    public static String bmiStatus(double bmi) {
        if (bmi <= 18.4)
            return "Underweight";
        if (bmi < 25.0)
            return "Normal";
        if (bmi < 40.0)
            return "Overweight";
        return "Obese";
    }

    public static double computeBmi(double weightKg, double heightCm) {
        double hM = heightCm / 100.0;
        if (hM <= 0)
            throw new IllegalArgumentException("Height must be positive");
        return weightKg / (hM * hM);
    }

    public static String[][] buildBmiTable(double[][] hw) {
        String[][] table = new String[hw.length][4];
        for (int i = 0; i < hw.length; i++) {
            double w = hw[i][0];
            double h = hw[i][1];
            double bmi = computeBmi(w, h);
            table[i][0] = String.format(Locale.US, "%.1f", h);
            table[i][1] = String.format(Locale.US, "%.1f", w);
            table[i][2] = String.format(Locale.US, "%.1f", bmi);
            table[i][3] = bmiStatus(bmi);
        }
        return table;
    }

    public static void displayTable(String[][] table) {
        System.out.printf("%-6s %-10s %-10s %-8s %-12s%n", "#", "Height(cm)", "Weight(kg)", "BMI", "Status");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < table.length; i++) {
            System.out.printf("%-6d %-10s %-10s %-8s %-12s%n", i + 1, table[i][0], table[i][1], table[i][2],
                    table[i][3]);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        final int N = 10;
        double[][] hw = new double[N][2];
        System.out.println("Enter weight(kg) and height(cm) for 10 persons:");
        for (int i = 0; i < N; i++) {
            while (true) {
                try {
                    System.out.print("Person " + (i + 1) + " - weight kg: ");
                    hw[i][0] = sc.nextDouble();
                    System.out.print("Person " + (i + 1) + " - height cm: ");
                    hw[i][1] = sc.nextDouble();
                    if (hw[i][0] <= 0 || hw[i][1] <= 0) {
                        System.out.println("Values must be positive. Try again.");
                        continue;
                    }
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid number. Please re-enter.");
                    sc.nextLine();
                }
            }
        }
        String[][] table = buildBmiTable(hw);
        displayTable(table);
        sc.close();
    }
}
