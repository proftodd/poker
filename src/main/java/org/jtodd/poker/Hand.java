package org.jtodd.poker;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hand {
    private static final Pattern pattern = Pattern.compile("([2-9TJQKA])([CDHS])");
    private final Set<Card> cards;

    private Hand(Set<Card> cards) {
        this.cards = cards;
    }

    public static Optional<Hand> parseHand(String hand) {
        Matcher matcher = pattern.matcher(hand);
        Set<Card> theCards = new HashSet<>();
        while (matcher.find()) {
            theCards.add(new Card(matcher.group(1).charAt(0), matcher.group(2).charAt(0)));
        }
        if (theCards.size() > 0) {
            Hand theHand = new Hand(theCards);
            return Optional.of(theHand);
        } else {
            return Optional.empty();
        }
    }

    public Set<Card> theCards() {
        return Set.copyOf(cards);
    }

    public List<Card> sortBySuit() {
        List<Card> myCards = new ArrayList<>(this.theCards());
        myCards.sort(Comparator.comparingInt(c -> c.suit));
        return myCards;
    }

    public List<Card> sortByValue() {
        List<Card> myCards = new ArrayList<>(this.theCards());
        myCards.sort((c1, c2) -> Integer.compare(c2.numericValue, c1.numericValue));
        return myCards;
    }

    public Map<Character, List<Card>> partitionByValue() {
        return cards.stream().collect(Collectors.groupingBy(
            c -> c.value
        ));
    }

    public static Optional<Integer> findFirstDifference(List<Card> sortedHand1, List<Card> sortedHand2) {
        return IntStream.range(0, Math.min(sortedHand1.size(), sortedHand2.size()))
                .filter(i -> sortedHand1.get(i).numericValue != sortedHand2.get(i).numericValue)
                .boxed()
                .findFirst();
    }

    public static int compareFirstDifference(List<Card> sortedHand1, List<Card> sortedHand2) {
        return Hand.findFirstDifference(sortedHand1, sortedHand2).map(i -> {
            Card myCard = sortedHand1.get(i);
            Card otherCard = sortedHand2.get(i);
            return Integer.compare(otherCard.numericValue, myCard.numericValue);
        }).orElse(0);
    }
}
