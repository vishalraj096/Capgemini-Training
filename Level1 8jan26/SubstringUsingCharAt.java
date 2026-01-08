import java.util.Scanner;

public class SubstringUsingCharAt {
    public static String substringByCharAt(String text, int start, int end) {
        if (text == null) return null;
        if (start < 0 || end > text.length() || start > end) throw new StringIndexOutOfBoundsException();
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) sb.append(text.charAt(i));
        return sb.toString();
    }

    public static boolean compareByCharAt(String a, String b) {
        if (a == null || b == null) return a == b;
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) != b.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();
        String manual = substringByCharAt(text, start, end);
        String builtin = text.substring(start, end);
        boolean same = compareByCharAt(manual, builtin);
        System.out.println("Manual substring: " + manual);
        System.out.println("Built-in substring: " + builtin);
        System.out.println("Match: " + same);
        sc.close();
    }
}
