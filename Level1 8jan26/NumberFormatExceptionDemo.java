import java.util.Scanner;

public class NumberFormatExceptionDemo {
    public static void generateException(String text) {
        // Will fail if text is not a valid integer
        int value = Integer.parseInt(text);
        System.out.println("Parsed value: " + value);
    }

    public static void handleException(String text) {
        try {
            int value = Integer.parseInt(text);
            System.out.println("Parsed value: " + value);
        } catch (NumberFormatException ex) {
            System.out.println("Handled NumberFormatException: not a valid integer");
        } catch (RuntimeException ex) {
            System.out.println("Handled RuntimeException: " + ex.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        try {
            generateException(text);
        } catch (RuntimeException ex) {
            System.out.println("Generated exception (as expected): " + ex.getClass().getSimpleName());
        }
        handleException(text);
        sc.close();
    }
}
