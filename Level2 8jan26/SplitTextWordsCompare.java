import java.util.Arrays;
import java.util.Scanner;

public class SplitTextWordsCompare {
    public static int manualLength(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException ex) {
                break;
            }
        }
        return count;
    }

    public static String[] splitByCharAt(String text) {
        int n = manualLength(text);
        String[] temp = new String[n];
        int words = 0;
        StringBuilder current = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                if (current.length() > 0) {
                    temp[words++] = current.toString();
                    current.setLength(0);
                }
            } else {
                current.append(ch);
            }
        }
        if (current.length() > 0)
            temp[words++] = current.toString();
        return Arrays.copyOf(temp, words);
    }

    public static boolean arraysEqual(String[] a, String[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] manual = splitByCharAt(text);
        String[] builtin = text.trim().isEmpty() ? new String[0] : text.trim().split("\\s+");
        System.out.println("Manual words: " + Arrays.toString(manual));
        System.out.println("Built-in words: " + Arrays.toString(builtin));
        System.out.println("Match: " + arraysEqual(manual, builtin));
        sc.close();
    }
}
