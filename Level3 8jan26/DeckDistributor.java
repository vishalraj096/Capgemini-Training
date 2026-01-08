import java.util.Random;
import java.util.Scanner;

public class DeckDistributor {
    public static String[] initDeck() {
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        int n = suits.length * ranks.length;
        String[] deck = new String[n];
        int k = 0;
        for (String r : ranks) {
            for (String s : suits) {
                deck[k++] = r + " of " + s;
            }
        }
        return deck;
    }

    public static void shuffle(String[] deck) {
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int j = i + rand.nextInt(deck.length - i);
            String tmp = deck[i];
            deck[i] = deck[j];
            deck[j] = tmp;
        }
    }

    public static String[][] distribute(String[] deck, int nCards, int players) {
        if (nCards < 1 || players < 1)
            throw new IllegalArgumentException("nCards and players must be >= 1");
        if (nCards > deck.length)
            throw new IllegalArgumentException("Not enough cards in deck");
        if (nCards % players != 0)
            throw new IllegalArgumentException("nCards must be divisible by players");
        int per = nCards / players;
        String[][] res = new String[players][per];
        int idx = 0;
        for (int p = 0; p < players; p++) {
            for (int c = 0; c < per; c++) {
                res[p][c] = deck[idx++];
            }
        }
        return res;
    }

    public static void printPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            for (int j = 0; j < players[i].length; j++) {
                System.out.print(players[i][j]);
                if (j + 1 < players[i].length)
                    System.out.print(", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] deck = initDeck();
        shuffle(deck);
        int n = sc.nextInt();
        int x = sc.nextInt();
        String[][] players = distribute(deck, n, x);
        printPlayers(players);
        sc.close();
    }
}
