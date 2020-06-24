package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class Flush implements Ranking {
    private final Hand hand;

    public Flush(Hand hand) {
        this.hand = hand;
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public int getValue() {
        return 3;
    }
}
