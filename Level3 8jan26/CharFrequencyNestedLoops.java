import java.util.Scanner;

public class CharFrequencyNestedLoops {
    public static String[] frequencyByNestedLoops(String text) {
        char[] chars = text.toCharArray();
        int n = chars.length;
        int[] freq = new int[n];
        for (int i = 0; i < n; i++) {
            if (chars[i] == '0')
                continue;
            freq[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++)
            if (chars[i] != '0')
                count++;
        String[] result = new String[count];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] != '0') {
                result[k++] = chars[i] + " : " + freq[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] table = frequencyByNestedLoops(text);
        System.out.println("Character : Frequency");
        for (String row : table)
            System.out.println(row);
        sc.close();
    }
}
