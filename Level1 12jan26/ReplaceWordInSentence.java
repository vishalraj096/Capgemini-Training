import java.util.Scanner;

public class ReplaceWordInSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String oldWord = sc.nextLine();
        String newWord = sc.nextLine();
        System.out.println(replaceWord(sentence, oldWord, newWord));
        sc.close();
    }

    public static String replaceWord(String sentence, String oldWord, String newWord) {
        String[] parts = sentence.split(" ");
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < parts.length; ++i) {
            if (parts[i].equals(oldWord)) {
                out.append(newWord);
            } else {
                out.append(parts[i]);
            }
            if (i != parts.length - 1)
                out.append(" ");
        }
        return out.toString();
    }
}
