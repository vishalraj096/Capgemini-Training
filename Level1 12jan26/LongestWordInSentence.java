import java.util.Scanner;

public class LongestWordInSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(longestWord(s));
        sc.close();
    }

    public static String longestWord(String s) {
        String[] words = s.split(" ");
        String best = "";
        for (String w : words) {
            if (w.length() > best.length())
                best = w;
        }
        return best;
    }
}
