import java.util.Scanner;

public class FirstNonRepeatingChar {
    public static char firstNonRepeating(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 256)
                freq[c]++;
        }
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 256 && freq[c] == 1)
                return c;
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        char res = firstNonRepeating(text);
        if (res == '\0')
            System.out.println("No non-repeating character found.");
        else
            System.out.println("First non-repeating character: " + res);
        sc.close();
    }
}
