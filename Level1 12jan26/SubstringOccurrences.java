import java.util.Scanner;

public class SubstringOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String sub = sc.nextLine();
        System.out.println(countOccurrences(s, sub));
        sc.close();
    }

    public static int countOccurrences(String s, String sub) {
        if (sub.length() == 0)
            return 0;
        int cnt = 0;
        for (int i = 0; i + sub.length() <= s.length(); ++i) {
            boolean match = true;
            for (int j = 0; j < sub.length(); ++j) {
                if (s.charAt(i + j) != sub.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match)
                cnt++;
        }
        return cnt;
    }
}
