import java.util.Arrays;
import java.util.Scanner;

public class CustomToCharArrayComparator {
    public static char[] toCharsManual(String text) {
        if (text == null) return null;
        char[] out = new char[text.length()];
        for (int i = 0; i < text.length(); i++) out[i] = text.charAt(i);
        return out;
    }

    public static boolean arraysEqual(char[] a, char[] b) {
        if (a == null || b == null) return a == b;
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) if (a[i] != b[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        char[] manual = toCharsManual(text);
        char[] builtin = text.toCharArray();
        boolean same = arraysEqual(manual, builtin);
        System.out.println("Manual: " + Arrays.toString(manual));
        System.out.println("Built-in: " + Arrays.toString(builtin));
        System.out.println("Match: " + same);
        sc.close();
    }
}
