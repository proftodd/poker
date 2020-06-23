package org.jtodd.poker;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hand {
    private static final Pattern pattern = Pattern.compile("^([2-9TJQKA])([CDHS]) ([2-9TJQKA])([CDHS]) ([2-9TJQKA])([CDHS]) ([2-9TJQKA])([CDHS]) ([2-9TJQKA])([CDHS])$");
    private final Card [] cards;

    private Hand(Card [] cards) {
        this.cards = cards;
    }

    public static Optional<Hand> parseHand(String hand) {
        Matcher matcher = pattern.matcher(hand);
        if (matcher.matches()) {
            Hand theHand = new Hand(new Card [] {
                new Card(matcher.group(1).charAt(0), matcher.group(2).charAt(0)),
                new Card(matcher.group(3).charAt(0), matcher.group(4).charAt(0)),
                new Card(matcher.group(5).charAt(0), matcher.group(6).charAt(0)),
                new Card(matcher.group(7).charAt(0), matcher.group(8).charAt(0)),
                new Card(matcher.group(9).charAt(0), matcher.group(10).charAt(0))
            });
            return Optional.of(theHand);
        } else {
            return Optional.empty();
        }
    }

    public Set<Card> theCards() {
        return Set.of(cards);
    }

    public List<Card> sortBySuit() {
        Card [] myCards = Arrays.copyOfRange(cards, 0, cards.length);
        Arrays.sort(myCards, Comparator.comparingInt(c -> c.suit));
        return List.of(myCards);
    }

    public List<Card> sortByValue() {
        Card [] myCards = Arrays.copyOfRange(cards, 0, cards.length);
        Arrays.sort(myCards, Comparator.comparingInt(c -> c.numericValue));
        return List.of(myCards);
    }
}
