import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {
    public static void generateException(String text) {
        // Access beyond length to trigger StringIndexOutOfBoundsException
        System.out.println(text.charAt(text.length()));
    }

    public static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("Handled StringIndexOutOfBoundsException: index beyond length");
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
