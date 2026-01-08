import java.util.Arrays;

public class FootballTeamHeightStats {
    public static int[] generateRandomHeights(int playerCount, int minHeightCm, int maxHeightCm) {
        int[] heights = new int[playerCount];
        for (int i = 0; i < playerCount; i++) {
            heights[i] = (int) (Math.random() * (maxHeightCm - minHeightCm + 1)) + minHeightCm;
        }
        return heights;
    }

    public static int calculateSum(int[] heights) {
        int sum = 0;
        for (int h : heights)
            sum += h;
        return sum;
    }

    public static double calculateMean(int[] heights) {
        int sum = calculateSum(heights);
        return (double) sum / heights.length;
    }

    public static int findShortest(int[] heights) {
        int shortest = heights[0];
        for (int h : heights)
            shortest = Math.min(shortest, h);
        return shortest;
    }

    public static int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int h : heights)
            tallest = Math.max(tallest, h);
        return tallest;
    }

    public static void main(String[] args) {
        int playerCount = 11;
        int minHeightCm = 150;
        int maxHeightCm = 250;

        int[] heights = generateRandomHeights(playerCount, minHeightCm, maxHeightCm);
        int sumHeights = calculateSum(heights);
        double meanHeight = calculateMean(heights);
        int shortestHeight = findShortest(heights);
        int tallestHeight = findTallest(heights);

        System.out.println("Heights (cm): " + Arrays.toString(heights));
        System.out.println("Sum of heights: " + sumHeights + " cm");
        System.out.println("Mean height: " + String.format("%.2f", meanHeight) + " cm");
        System.out.println("Shortest height: " + shortestHeight + " cm");
        System.out.println("Tallest height: " + tallestHeight + " cm");
    }
}
