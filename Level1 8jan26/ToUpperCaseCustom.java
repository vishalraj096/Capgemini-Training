import java.util.Scanner;

public class ToUpperCaseCustom {
    public static String toUpperManual(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') sb.append((char)(ch - 32));
            else sb.append(ch);
        }
        return sb.toString();
    }

    public static boolean compareByCharAt(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) != b.charAt(i)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String manual = toUpperManual(text);
        String builtin = text.toUpperCase();
        System.out.println("Manual Upper: " + manual);
        System.out.println("Built-in Upper: " + builtin);
        System.out.println("Match: " + compareByCharAt(manual, builtin));
        sc.close();
    }
}
