import java.util.Scanner;

public class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char ch = mostFrequentChar(s);
        System.out.println(ch);
        sc.close();
    }

    public static char mostFrequentChar(String s) {
        int[] cnt = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c != ' ')
                cnt[c]++;
        }
        int bestCount = -1;
        char bestChar = '\0';
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == ' ')
                continue;
            if (cnt[c] > bestCount) {
                bestCount = cnt[c];
                bestChar = c;
            }
        }
        return bestChar;
    }
}
