import java.util.Scanner;

public class StringCompareCharAt {
    public static boolean compareByCharAt(String a, String b) {
        if (a == null || b == null) return a == b;
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String second = sc.next();
        boolean charAtEqual = compareByCharAt(first, second);
        boolean builtInEqual = first.equals(second);
        System.out.println("CharAt compare: " + charAtEqual);
        System.out.println("String.equals: " + builtInEqual);
        System.out.println("Match: " + (charAtEqual == builtInEqual));
        sc.close();
    }
}
