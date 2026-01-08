import java.util.Scanner;

public class BMICalculator {
    public static double calculateBmi(double weightKg, double heightCm) {
        double heightMeters = heightCm / 100.0;
        return weightKg / (heightMeters * heightMeters);
    }

    public static String determineBmiStatus(double bmi) {
        if (bmi <= 18.4)
            return "Underweight";
        if (bmi >= 18.5 && bmi <= 24.9)
            return "Normal";
        if (bmi >= 25.0 && bmi <= 39.9)
            return "Overweight";
        return "Obese";
    }

    public static String[] evaluateBmiStatuses(double[][] personData) {
        String[] statuses = new String[personData.length];
        for (int i = 0; i < personData.length; i++) {
            double bmi = personData[i][2];
            statuses[i] = determineBmiStatus(bmi);
        }
        return statuses;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] teamData = new double[10][3];

        for (int i = 0; i < teamData.length; i++) {
            double weightKg = input.nextDouble();
            double heightCm = input.nextDouble();
            teamData[i][0] = weightKg;
            teamData[i][1] = heightCm;
            teamData[i][2] = calculateBmi(weightKg, heightCm);
        }

        String[] statuses = evaluateBmiStatuses(teamData);

        for (int i = 0; i < teamData.length; i++) {
            System.out.println(
                    "Person " + (i + 1) +
                            ": Weight = " + teamData[i][0] + " kg, " +
                            "Height = " + teamData[i][1] + " cm, " +
                            "BMI = " + String.format("%.2f", teamData[i][2]) + ", " +
                            "Status = " + statuses[i]);
        }
        input.close();
    }
}
