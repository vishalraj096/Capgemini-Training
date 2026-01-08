import java.util.Scanner;

public class VowelConsonantCount {
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

    public static int[] countVowelsConsonants(String text) {
        int vowels = 0, consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            String type = classifyChar(text.charAt(i));
            if ("Vowel".equals(type))
                vowels++;
            else if ("Consonant".equals(type))
                consonants++;
        }
        return new int[] { vowels, consonants };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int[] res = countVowelsConsonants(text);
        System.out.println("Vowels: " + res[0] + ", Consonants: " + res[1]);
        sc.close();
    }
}
