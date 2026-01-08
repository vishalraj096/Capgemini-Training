import java.util.Arrays;

public class RandomFourDigitStats {
    public int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * 9000) + 1000;
        }
        return numbers;
    }

    public double[] findAverageMinMax(int[] numbers) {
        double sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        for (int n : numbers) {
            sum += n;
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        double average = sum / numbers.length;
        return new double[] { average, min, max };
    }

    public static void main(String[] args) {
        RandomFourDigitStats stats = new RandomFourDigitStats();
        int[] numbers = stats.generate4DigitRandomArray(5);
        double[] result = stats.findAverageMinMax(numbers);

        System.out.println("Numbers: " + Arrays.toString(numbers));
        System.out.println("Average: " + String.format("%.2f", result[0]));
        System.out.println("Min: " + (int) result[1]);
        System.out.println("Max: " + (int) result[2]);
    }
}
