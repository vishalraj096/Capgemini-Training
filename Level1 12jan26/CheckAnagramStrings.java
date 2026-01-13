import java.util.Scanner;

public class CheckAnagramStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        if (isAnagram(a, b)) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not Anagram");
        }
        sc.close();
    }

    public static boolean isAnagram(String a, String b) {
        int[] cnt = new int[256];
        for (int i = 0; i < a.length(); ++i) {
            char ch = Character.toLowerCase(a.charAt(i));
            if (ch != ' ')
                cnt[ch]++;
        }
        for (int i = 0; i < b.length(); ++i) {
            char ch = Character.toLowerCase(b.charAt(i));
            if (ch != ' ')
                cnt[ch]--;
        }
        for (int i = 0; i < 256; ++i) {
            if (cnt[i] != 0)
                return false;
        }
        return true;
    }
}
