import java.util.Scanner;

public class CountVowelsConsonants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int vowels = countVowels(s);
        int consonants = countConsonants(s);
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        sc.close();
    }

    private static boolean isLetter(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static int countVowels(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (isLetter(ch) && isVowel(ch))
                cnt++;
        }
        return cnt;
    }

    public static int countConsonants(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (isLetter(ch) && !isVowel(ch))
                cnt++;
        }
        return cnt;
    }
}
