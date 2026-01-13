import java.util.Scanner;

public class CompareStringsLexicographically {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int cmp = compareLex(a, b);
        if (cmp < 0) {
            System.out.println(a + " comes before " + b + " in lexicographical order");
        } else if (cmp > 0) {
            System.out.println(b + " comes before " + a + " in lexicographical order");
        } else {
            System.out.println("Both strings are equal");
        }
        sc.close();
    }

    public static int compareLex(String a, String b) {
        int n = Math.min(a.length(), b.length());
        for (int i = 0; i < n; ++i) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);
            if (ca != cb)
                return ca - cb;
        }
        return a.length() - b.length();
    }
}
