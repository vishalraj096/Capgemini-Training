import java.util.Scanner;

public class BMICalculationUsing2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPersons = scanner.nextInt();

        double[][] personData = new double[numberOfPersons][3];
        String[] weightStatus = new String[numberOfPersons];

        for (int i = 0; i < numberOfPersons; i++) {
            double weight;
            do {
                weight = scanner.nextDouble();
            } while (weight <= 0);

            double height;
            do {
                height = scanner.nextDouble();
            } while (height <= 0);

            personData[i][0] = weight;
            personData[i][1] = height;
        }

        for (int i = 0; i < numberOfPersons; i++) {
            double heightInMeter = personData[i][1] / 100;
            double bmi = personData[i][0] / (heightInMeter * heightInMeter);
            personData[i][2] = bmi;

            if (bmi <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi >= 25.0 && bmi <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        for (int i = 0; i < numberOfPersons; i++) {
            System.out.println(
                    "Person " + (i + 1) +
                    " | Weight(kg): " + personData[i][0] +
                    " | Height(cm): " + personData[i][1] +
                    " | BMI: " + personData[i][2] +
                    " | Status: " + weightStatus[i]);
        }

        scanner.close();
    }
}
