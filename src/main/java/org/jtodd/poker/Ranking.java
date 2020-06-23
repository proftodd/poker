package org.jtodd.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public enum Ranking {
    STRAIGHT_FLUSH,
    HIGH_CARD;

    public static Ranking rank(Hand hand) {
        if (isStraightFlush(hand)) {
            return STRAIGHT_FLUSH;
        }
        return HIGH_CARD;
    }

    private static boolean isStraightFlush(Hand hand) {
        Set<Card> theCards = hand.theCards();
        List<Card> theSortedCards = new ArrayList<>(theCards);
        Collections.sort(theSortedCards);
        char theFirstCardsSuit = theSortedCards.get(0).suit;
        boolean allCardsSameSuit = theCards.stream().allMatch(c -> c.suit == theFirstCardsSuit);
        boolean inSequence = true;
        for (int i = 1; i < 5; ++i) {
            System.out.printf("Comparing cards %d and %d\n", i - 1, i);
            inSequence = inSequence && (theSortedCards.get(i - 1).numericValue + 1 == theSortedCards.get(i).numericValue);
        }
        return allCardsSameSuit && inSequence;
    }
}
