package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class Straight implements Ranking {
    private final Hand hand;

    public Straight(Hand hand) {
        this.hand = hand;
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public int getValue() {
        return 4;
    }
}
