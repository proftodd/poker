package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class TwoPairs implements Ranking {
    private final Hand hand;

    public TwoPairs(Hand hand) {
        this.hand = hand;
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public int getValue() {
        return 6;
    }
}
