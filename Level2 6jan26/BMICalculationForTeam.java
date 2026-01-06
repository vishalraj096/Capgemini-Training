import java.util.Scanner;

public class BMICalculationForTeam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPersons = scanner.nextInt();

        double[] heightCm = new double[numberOfPersons];
        double[] weightKg = new double[numberOfPersons];
        double[] bmiValues = new double[numberOfPersons];
        String[] bmiStatus = new String[numberOfPersons];

        for (int i = 0; i < numberOfPersons; i++) {
            weightKg[i] = scanner.nextDouble();
            heightCm[i] = scanner.nextDouble();
        }

        for (int i = 0; i < numberOfPersons; i++) {
            double heightMeter = heightCm[i] / 100;
            bmiValues[i] = weightKg[i] / (heightMeter * heightMeter);

            if (bmiValues[i] <= 18.4) {
                bmiStatus[i] = "Underweight";
            } else if (bmiValues[i] >= 18.5 && bmiValues[i] <= 24.9) {
                bmiStatus[i] = "Normal";
            } else if (bmiValues[i] >= 25.0 && bmiValues[i] <= 39.9) {
                bmiStatus[i] = "Overweight";
            } else {
                bmiStatus[i] = "Obese";
            }
        }

        for (int i = 0; i < numberOfPersons; i++) {
            System.out.println(
                    "Person " + (i + 1) +
                    " | Height(cm): " + heightCm[i] +
                    " | Weight(kg): " + weightKg[i] +
                    " | BMI: " + bmiValues[i] +
                    " | Status: " + bmiStatus[i]);
        }

        scanner.close();
    }
}
