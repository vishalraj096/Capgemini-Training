import java.util.Scanner;

public class ShortestAndLongestWord {
    public static int manualLength(String text) {
        int c = 0;
        while (true) {
            try {
                text.charAt(c);
                c++;
            } catch (StringIndexOutOfBoundsException ex) {
                break;
            }
        }
        return c;
    }

    public static String[] splitByCharAt(String text) {
        int n = manualLength(text);
        StringBuilder cur = new StringBuilder();
        String[] tmp = new String[n];
        int w = 0;
        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                if (cur.length() > 0) {
                    tmp[w++] = cur.toString();
                    cur.setLength(0);
                }
            } else
                cur.append(ch);
        }
        if (cur.length() > 0)
            tmp[w++] = cur.toString();
        String[] words = new String[w];
        System.arraycopy(tmp, 0, words, 0, w);
        return words;
    }

    public static int[] findShortestAndLongest(String[][] wordLenTable) {
        int minIdx = 0, maxIdx = 0;
        for (int i = 1; i < wordLenTable.length; i++) {
            int len = Integer.parseInt(wordLenTable[i][1]);
            int minLen = Integer.parseInt(wordLenTable[minIdx][1]);
            int maxLen = Integer.parseInt(wordLenTable[maxIdx][1]);
            if (len < minLen)
                minIdx = i;
            if (len > maxLen)
                maxIdx = i;
        }
        return new int[] { minIdx, maxIdx };
    }

    public static String[][] wordsWithLengths(String[] words) {
        String[][] table = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(words[i].length());
        }
        return table;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = splitByCharAt(text);
        String[][] table = wordsWithLengths(words);
        int[] res = findShortestAndLongest(table);
        System.out.println("Shortest: " + table[res[0]][0] + " (" + table[res[0]][1] + ")");
        System.out.println("Longest: " + table[res[1]][0] + " (" + table[res[1]][1] + ")");
        sc.close();
    }
}
