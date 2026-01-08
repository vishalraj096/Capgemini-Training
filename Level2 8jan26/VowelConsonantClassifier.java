import java.util.Scanner;

public class VowelConsonantClassifier {
    public static String classifyChar(char ch) {
        if (ch >= 'A' && ch <= 'Z')
            ch = (char) (ch + 32);
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }

    public static String[][] classifyString(String text) {
        String[][] table = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            table[i][0] = String.valueOf(ch);
            table[i][1] = classifyChar(ch);
        }
        return table;
    }

    public static void displayTable(String[][] table) {
        System.out.println("Char\tType");
        for (String[] row : table) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[][] table = classifyString(text);
        displayTable(table);
        sc.close();
    }
}
