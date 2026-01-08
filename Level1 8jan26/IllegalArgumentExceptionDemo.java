import java.util.Scanner;

public class IllegalArgumentExceptionDemo {
    public static String safeSubstring(String text, int start, int end) {
        if (start > end)
            throw new IllegalArgumentException("start index greater than end index");
        return text.substring(start, end);
    }

    public static void generateException(String text) {
        System.out.println(text.substring(3, 1));
    }

    public static void handleException(String text) {
        try {
            System.out.println(safeSubstring(text, 3, 1));
        } catch (IllegalArgumentException ex) {
            System.out.println("Handled IllegalArgumentException: " + ex.getMessage());
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
