import java.util.Scanner;

public class PalindromeCheckerMultiLogic {
    public static boolean isPalindromeIterative(String text) {
        int i = 0, j = text.length() - 1;
        while (i < j) {
            if (text.charAt(i) != text.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    public static char[] reverseByCharAt(String text) {
        int n = text.length();
        char[] rev = new char[n];
        for (int i = 0; i < n; i++) rev[i] = text.charAt(n - 1 - i);
        return rev;
    }

    public static boolean isPalindromeByArrays(String text) {
        char[] orig = text.toCharArray();
        char[] rev = reverseByCharAt(text);
        if (orig.length != rev.length) return false;
        for (int i = 0; i < orig.length; i++) if (orig[i] != rev[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        boolean a = isPalindromeIterative(text);
        boolean b = isPalindromeRecursive(text, 0, text.length() - 1);
        boolean c = isPalindromeByArrays(text);
        System.out.println("Iterative: " + a);
        System.out.println("Recursive: " + b);
        System.out.println("Arrays: " + c);
        sc.close();
    }
}
