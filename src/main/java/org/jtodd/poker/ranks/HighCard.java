package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class HighCard implements Ranking {
    private final Hand hand;

    public HighCard(Hand hand) {
        this.hand = hand;
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public int getValue() {
        return 8;
    }
}
