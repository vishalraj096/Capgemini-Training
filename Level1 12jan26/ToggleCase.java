import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(toggleCase(s));
        sc.close();
    }

    public static String toggleCase(String s) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                out.append((char) (ch - 'a' + 'A'));
            } else if (ch >= 'A' && ch <= 'Z') {
                out.append((char) (ch - 'A' + 'a'));
            } else {
                out.append(ch);
            }
        }
        return out.toString();
    }
}
