import java.util.Scanner;

public class TwoDToOneD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter columns: ");
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];
        int[] array = new int[rows * columns];
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
                array[index++] = matrix[i][j];
            }
        }

        System.out.println("1D Array:");
        for (int value : array) {
            System.out.print(value + " ");
        }

        scanner.close();
    }
}
