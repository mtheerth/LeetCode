import java.util.*;

public class PokerCardsGame {

    static class Card {
        String suit;
        int figure;

        Card(String suit, int figure) {
            this.suit = suit;
            this.figure = figure;
        }

        @Override
        public String toString() {
            return "(" + suit + "," + figure + ")";
        }
    }

    public static int maxCards(Card[] cards) {
        if (cards == null || cards.length == 0) {
            return 0;
        }

        // Sort the cards by figure (ascending), then by suit
        Arrays.sort(cards, (a, b) -> {
            if (a.figure != b.figure) {
                return a.figure - b.figure;
            }
            return a.suit.compareTo(b.suit);
        });

        // DP array to store the length of the longest sequence ending at each card
        int[] dp = new int[cards.length];
        Arrays.fill(dp, 1); // Each card is a sequence of length 1 by itself

        int maxLength = 1;

        // Fill the DP array
        for (int i = 1; i < cards.length; i++) {
            for (int j = 0; j < i; j++) {
                // Check if the current card shares the same suit or figure with the previous card
                if (cards[i].suit.equals(cards[j].suit) || cards[i].figure == cards[j].figure) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Card[] cards = {
            new Card("H", 3),
            new Card("H", 4),
            new Card("S", 4),
            new Card("D", 5),
            new Card("D", 1)
        };

        System.out.println(maxCards(cards)); // Output: 3
    }
}
