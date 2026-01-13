import java.util.Scanner;

public class RemoveSpecificCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        char ch = t.length() > 0 ? t.charAt(0) : '\0';
        System.out.println(removeChar(s, ch));
        sc.close();
    }

    public static String removeChar(String s, char ch) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != ch)
                out.append(s.charAt(i));
        }
        return out.toString();
    }
}
