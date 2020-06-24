package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class FourOfAKind implements Ranking {
    private final Hand hand;

    public FourOfAKind(Hand hand) {
        this.hand = hand;
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public int getValue() {
        return 1;
    }
}
