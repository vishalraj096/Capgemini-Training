import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(removeDuplicates(s));
        sc.close();
    }

    public static String removeDuplicates(String s) {
        boolean[] seen = new boolean[256];
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (!seen[ch]) {
                seen[ch] = true;
                out.append(ch);
            }
        }
        return out.toString();
    }
}
