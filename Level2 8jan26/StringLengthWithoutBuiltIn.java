import java.util.Scanner;

public class StringLengthWithoutBuiltIn {
    public static int findLengthByCharAt(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException ex) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int manualLen = findLengthByCharAt(text);
        int builtInLen = text.length();
        System.out.println("Manual length: " + manualLen);
        System.out.println("Built-in length: " + builtInLen);
        sc.close();
    }
}
