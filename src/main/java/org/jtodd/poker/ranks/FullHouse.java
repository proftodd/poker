package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class FullHouse implements Ranking {
    private final Hand hand;

    public FullHouse(Hand hand) {
        this.hand = hand;
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public int getValue() {
        return 2;
    }
}
