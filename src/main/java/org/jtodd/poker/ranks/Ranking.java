package org.jtodd.poker.ranks;

import org.jtodd.poker.Card;
import org.jtodd.poker.Hand;

import java.util.*;
import java.util.stream.IntStream;

public interface Ranking extends Comparable<Ranking> {

    int getValue();

    Hand getHand();

    default int compareTo(Ranking o) {
        return Integer.compare(this.getValue(), o.getValue());
    }

    static Ranking rank(Hand hand) {
        if (isStraightFlush(hand)) {
            return new StraightFlush(hand);
        } else if (isFourOfAKind(hand)) {
            return new FourOfAKind(hand);
        } else if (isFullHouse(hand)) {
            return new FullHouse(hand);
        } else if (isFlush(hand)) {
            return new Flush(hand);
        } else if (isStraight(hand)) {
            return new Straight(hand);
        } else if (isThreeOfAKind(hand)) {
            return new ThreeOfAKind(hand);
        } else if (isTwoPairs(hand)) {
            return new TwoPairs(hand);
        } else if (isPair(hand)) {
            return new Pair(hand);
        } else {
            return new HighCard(hand);
        }
    }

    private static boolean isStraightFlush(Hand hand) {
        return isFlush(hand) && isStraight(hand);
    }

    private static boolean isFourOfAKind(Hand hand) {
        return hand.partitionByValue().values().stream().anyMatch(l -> l.size() == 4);
    }

    private static boolean isFullHouse(Hand hand) {
        Map<Character, List<Card>> partitioned = hand.partitionByValue();
        return partitioned.values().stream().anyMatch(l -> l.size() == 3) &&
               partitioned.values().stream().anyMatch(l -> l.size() == 2);
    }

    private static boolean isFlush(Hand hand) {
        char oneSuit = hand.theCards().iterator().next().suit;
        return hand.theCards().stream().allMatch(c -> c.suit == oneSuit);
    }

    private static boolean isStraight(Hand hand) {
        List<Card> theSortedCards = hand.sortByValue();
        int lowestCardValue = theSortedCards.get(0).numericValue;
        return IntStream.range(0, theSortedCards.size()).allMatch(
            i -> theSortedCards.get(i).numericValue - lowestCardValue == i
        );
    }

    private static boolean isThreeOfAKind(Hand hand) {
        return hand.partitionByValue().values().stream().anyMatch(l -> l.size() == 3);
    }

    private static boolean isTwoPairs(Hand hand) {
        return hand.partitionByValue().values().stream().filter(l -> l.size() == 2).count() == 2;
    }

    private static boolean isPair(Hand hand) {
        return hand.partitionByValue().values().stream().anyMatch(l -> l.size() == 2);
    }
}
