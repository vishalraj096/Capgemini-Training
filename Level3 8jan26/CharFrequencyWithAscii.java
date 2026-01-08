import java.util.Scanner;

public class CharFrequencyWithAscii {
    public static String[][] frequencyTable(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 256) freq[c]++;
        }
        int count = 0;
        for (int f : freq) if (f > 0) count++;
        String[][] table = new String[count][2];
        int k = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                table[k][0] = Character.toString((char) i);
                table[k][1] = Integer.toString(freq[i]);
                k++;
            }
        }
        return table;
    }

    public static void display(String[][] table) {
        System.out.printf("%-8s %-8s%n", "Char", "Freq");
        System.out.println("----------------");
        for (String[] row : table) {
            System.out.printf("%-8s %-8s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[][] table = frequencyTable(text);
        display(table);
        sc.close();
    }
}
