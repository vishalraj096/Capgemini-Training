import java.util.Locale;
import java.util.Scanner;

public class StudentScoreCard {
    public static int[][] generatePcmScores(int studentCount) {
        int minScore = 10;
        int maxScore = 99;
        int[][] scores = new int[studentCount][3];
        for (int i = 0; i < studentCount; i++) {
            scores[i][0] = (int) (Math.random() * (maxScore - minScore + 1)) + minScore;
            scores[i][1] = (int) (Math.random() * (maxScore - minScore + 1)) + minScore;
            scores[i][2] = (int) (Math.random() * (maxScore - minScore + 1)) + minScore;
        }
        return scores;
    }

    public static double[][] computeTotalsAveragesPercentages(int[][] scores) {
        double[][] result = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100.0;
            result[i][0] = total;
            result[i][1] = round2(average);
            result[i][2] = round2(percentage);
        }
        return result;
    }

    public static void printScoreCard(int[][] scores, double[][] computed) {
        Locale.setDefault(Locale.US);
        System.out.println("ID\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t\t%d\t\t%d\t%d\t%.2f\t\t%.2f%%%n",
                    (i + 1), scores[i][0], scores[i][1], scores[i][2],
                    (int) computed[i][0], computed[i][1], computed[i][2]);
        }
    }

    private static double round2(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int studentCount = input.nextInt();
        int[][] scores = generatePcmScores(studentCount);
        double[][] computed = computeTotalsAveragesPercentages(scores);
        printScoreCard(scores, computed);
        input.close();
    }
}
