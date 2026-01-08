import java.util.Scanner;

public class UniqueCharactersFinder {
    public static int manualLength(String text) {
        int len = 0;
        try {
            while (true) {
                text.charAt(len);
                len++;
            }
        } catch (IndexOutOfBoundsException ex) {

        }
        return len;
    }

    public static char[] uniqueCharacters(String text) {
        int n = manualLength(text);
        char[] result = new char[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            boolean seen = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == c) {
                    seen = true;
                    break;
                }
            }
            if (!seen) {
                result[count++] = c;
            }
        }
        char[] trimmed = new char[count];
        for (int i = 0; i < count; i++)
            trimmed[i] = result[i];
        return trimmed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        char[] uniques = uniqueCharacters(text);
        System.out.print("Unique characters: ");
        for (char c : uniques)
            System.out.print(c + " ");
        System.out.println();
        sc.close();
    }
}
