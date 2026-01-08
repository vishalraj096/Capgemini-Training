import java.util.Scanner;

public class AnagramChecker {
    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;
        int[] fa = new int[256];
        int[] fb = new int[256];
        for (int i = 0; i < a.length(); i++) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);
            if (ca < 256)
                fa[ca]++;
            if (cb < 256)
                fb[cb]++;
        }
        for (int i = 0; i < 256; i++)
            if (fa[i] != fb[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println("Anagram: " + isAnagram(a, b));
        sc.close();
    }
}
