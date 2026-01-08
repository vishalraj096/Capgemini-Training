public class NullPointerExceptionDemo {
    public static void generateNullPointer() {
        String text = null;
        // This will throw NullPointerException
        System.out.println(text.length());
    }

    public static void handleNullPointer() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException ex) {
            System.out.println("Handled NullPointerException: text is null");
        }
    }

    public static void main(String[] args) {
        try {
            generateNullPointer();
        } catch (RuntimeException ex) {
            System.out.println("Generated exception (as expected): " + ex.getClass().getSimpleName());
        }
        handleNullPointer();
    }
}
