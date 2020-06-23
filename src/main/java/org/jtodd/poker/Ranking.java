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
        } else if (isFullHouse(hand)) {
            return FULL_HOUSE;
        } else if (isFlush(hand)) {
            return FLUSH;
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

    private static boolean isFullHouse(Hand hand) {
        Map<Object, List<Card>> partitioned = hand.theCards().stream().collect(Collectors.groupingBy(
                c -> c.value
        ));
        return partitioned.values().stream().anyMatch(l -> l.size() == 3) &&
               partitioned.values().stream().anyMatch(l -> l.size() == 2);
    }

    private static boolean isFlush(Hand hand) {
        char oneSuit = hand.theCards().iterator().next().suit;
        return hand.theCards().stream().allMatch(c -> c.suit == oneSuit);
    }
}
