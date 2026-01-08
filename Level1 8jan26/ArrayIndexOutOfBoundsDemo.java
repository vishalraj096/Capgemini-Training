import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {
    public static void generateException(String[] names) {
        System.out.println(names[names.length]);
    }

    public static void handleException(String[] names) {
        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Handled ArrayIndexOutOfBoundsException: index beyond array length");
        } catch (RuntimeException ex) {
            System.out.println("Handled RuntimeException: " + ex.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++)
            names[i] = sc.next();
        try {
            generateException(names);
        } catch (RuntimeException ex) {
            System.out.println("Generated exception (as expected): " + ex.getClass().getSimpleName());
        }
        handleException(names);
        sc.close();
    }
}
