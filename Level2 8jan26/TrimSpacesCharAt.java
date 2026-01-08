import java.util.Scanner;

public class TrimSpacesCharAt {
    public static int[] trimIndices(String text) {
        int start = 0, end = text.length();
        while (start < end && text.charAt(start) == ' ')
            start++;
        while (end > start && text.charAt(end - 1) == ' ')
            end--;
        return new int[] { start, end };
    }

    public static String substringByCharAt(String text, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++)
            sb.append(text.charAt(i));
        return sb.toString();
    }

    public static boolean compareByCharAt(String a, String b) {
        if (a.length() != b.length())
            return false;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) != b.charAt(i))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int[] idx = trimIndices(text);
        String manual = substringByCharAt(text, idx[0], idx[1]);
        String builtin = text.trim();
        System.out.println("Manual trim: '" + manual + "'");
        System.out.println("Built-in trim: '" + builtin + "'");
        System.out.println("Match: " + compareByCharAt(manual, builtin));
        sc.close();
    }
}
