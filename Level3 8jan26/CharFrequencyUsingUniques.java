import java.util.Scanner;

public class CharFrequencyUsingUniques {
    public static int[] asciiFrequency(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 256) freq[c]++;
        }
        return freq;
    }

    public static char[] uniqueCharacters(String text) {
        int n = text.length();
        char[] temp = new char[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            boolean seen = false;
            for (int j = 0; j < i; j++) if (text.charAt(j) == c) { seen = true; break; }
            if (!seen) temp[count++] = c;
        }
        char[] res = new char[count];
        for (int i = 0; i < count; i++) res[i] = temp[i];
        return res;
    }

    public static String[][] uniqueFrequency(String text) {
        int[] freq = asciiFrequency(text);
        char[] uniq = uniqueCharacters(text);
        String[][] table = new String[uniq.length][2];
        for (int i = 0; i < uniq.length; i++) {
            char c = uniq[i];
            table[i][0] = Character.toString(c);
            table[i][1] = Integer.toString(c < 256 ? freq[c] : 0);
        }
        return table;
    }

    public static void display(String[][] table) {
        System.out.printf("%-8s %-8s%n", "Char", "Freq");
        System.out.println("----------------");
        for (String[] row : table) System.out.printf("%-8s %-8s%n", row[0], row[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[][] table = uniqueFrequency(text);
        display(table);
        sc.close();
    }
}
