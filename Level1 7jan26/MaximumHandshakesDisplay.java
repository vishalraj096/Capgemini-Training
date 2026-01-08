import java.util.Scanner;

public class MaximumHandshakesDisplay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numberOfStudents = input.nextInt();
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        System.out.println("Maximum number of handshakes is " + handshakes);
        input.close();
    }
}
