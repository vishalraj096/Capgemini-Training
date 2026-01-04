import java.util.Scanner;

public class FactorsWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = input.nextInt();
        int counter = 1;

        if (number > 0) {
            while (counter < number) {
                if (number % counter == 0) {
                    System.out.println(counter);
                }
                counter++;
            }
        }

        input.close();
    }
}
