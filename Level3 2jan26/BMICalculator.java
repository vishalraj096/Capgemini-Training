import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double weightKg = input.nextDouble();
        double heightCm = input.nextDouble();

        double heightMeter = heightCm / 100;
        double bmi = weightKg / (heightMeter * heightMeter);

        System.out.println("BMI: " + bmi);

        if (bmi <= 18.4) {
            System.out.println("Status: Underweight");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("Status: Normal");
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            System.out.println("Status: Overweight");
        } else {
            System.out.println("Status: Obese");
        }

        input.close();
    }
}
