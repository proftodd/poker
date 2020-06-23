package org.jtodd.poker;

import java.util.Optional;
import java.util.regex.Pattern;

public class Hand {
    private static final Pattern pattern = Pattern.compile("[2-9TJQKA][CDHS] [2-9TJQKA][CDHS] [2-9TJQKA][CDHS] [2-9TJQKA][CDHS] [2-9TJQKA][CDHS]");

    public static Optional<Hand> parseHand(String hand) {
        if (pattern.matcher(hand).matches()) {
            Hand theHand = new Hand();
            return Optional.of(theHand);
        } else {
            return Optional.empty();
        }
    }
}
