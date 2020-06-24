package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class Pair implements Ranking {
    private final Hand hand;

    public Pair(Hand hand) {
        this.hand = hand;
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public int getValue() {
        return 7;
    }
}
