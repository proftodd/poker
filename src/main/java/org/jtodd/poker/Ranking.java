package org.jtodd.poker;

import java.util.*;
import java.util.stream.Collectors;

public enum Ranking {
    STRAIGHT_FLUSH,
    FOUR_OF_A_KIND,
    FULL_HOUSE,
    FLUSH,
    STRAIGHT,
    THREE_OF_A_KIND,
    TWO_PAIRS,
    PAIR,
    HIGH_CARD;

    public static Ranking rank(Hand hand) {
        if (isStraightFlush(hand)) {
            return STRAIGHT_FLUSH;
        } else if (isFourOfAKind(hand)) {
            return FOUR_OF_A_KIND;
        } else {
            return HIGH_CARD;
        }
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

    private static boolean isFourOfAKind(Hand hand) {
        Map<Object, List<Card>> partitioned = hand.theCards().stream().collect(Collectors.groupingBy(
            c -> c.value
        ));
        return partitioned.values().stream().anyMatch(l -> l.size() == 4);
    }
}
