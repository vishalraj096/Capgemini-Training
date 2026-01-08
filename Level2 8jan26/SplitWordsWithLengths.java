import java.util.Arrays;
import java.util.Scanner;

public class SplitWordsWithLengths {
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
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                if (cur.length() > 0) {
                    temp[words++] = cur.toString();
                    cur.setLength(0);
                }
            } else
                cur.append(ch);
        }
        if (cur.length() > 0)
            temp[words++] = cur.toString();
        return Arrays.copyOf(temp, words);
    }

    public static int findLengthByCharAt(String text) {
        return manualLength(text);
    }

    public static String[][] wordsWithLengths(String[] words) {
        String[][] table = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(findLengthByCharAt(words[i]));
        }
        return table;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = splitByCharAt(text);
        String[][] table = wordsWithLengths(words);
        System.out.println("Word\tLength");
        for (String[] row : table) {
            int len = Integer.parseInt(row[1]);
            System.out.println(row[0] + "\t" + len);
        }
        sc.close();
    }
}
