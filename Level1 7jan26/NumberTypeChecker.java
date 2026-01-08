import java.util.Scanner;

public class NumberTypeChecker {
    public static int checkNumber(int number) {
        if (number > 0)
            return 1;
        if (number < 0)
            return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = input.nextInt();
        int result = checkNumber(number);

        System.out.println(result);
        input.close();
    }
}
