import java.util.Random;

public class RockPaperScissorsStats {
    enum Move {
        ROCK, PAPER, SCISSORS
    }

    public static Move randomMove(Random r) {
        int x = r.nextInt(3);
        return x == 0 ? Move.ROCK : (x == 1 ? Move.PAPER : Move.SCISSORS);
    }

    public static int result(Move a, Move b) {
        if (a == b)
            return 0;
        if ((a == Move.ROCK && b == Move.SCISSORS) ||
                (a == Move.PAPER && b == Move.ROCK) ||
                (a == Move.SCISSORS && b == Move.PAPER))
            return 1;
        return -1;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int games = 20; // play 20 rounds
        int wins = 0, losses = 0, draws = 0;
        System.out.printf("%-6s %-8s %-8s %-6s\n", "Game", "Player", "Computer", "Res");
        System.out.println("---------------------------------");
        for (int i = 1; i <= games; i++) {
            Move player = randomMove(r);
            Move computer = randomMove(r);
            int res = result(player, computer);
            if (res == 1)
                wins++;
            else if (res == -1)
                losses++;
            else
                draws++;
            String resStr = res == 1 ? "Win" : (res == -1 ? "Lose" : "Draw");
            System.out.printf("%-6d %-8s %-8s %-6s\n", i, player, computer, resStr);
        }
        System.out.println("---------------------------------");
        int total = wins + losses + draws;
        double winPct = total == 0 ? 0 : (wins * 100.0 / total);
        double lossPct = total == 0 ? 0 : (losses * 100.0 / total);
        double drawPct = total == 0 ? 0 : (draws * 100.0 / total);
        System.out.printf("Wins: %d (%.2f%%), Losses: %d (%.2f%%), Draws: %d (%.2f%%)\n",
                wins, winPct, losses, lossPct, draws, drawPct);
    }
}
