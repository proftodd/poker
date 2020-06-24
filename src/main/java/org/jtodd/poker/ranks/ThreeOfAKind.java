package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class ThreeOfAKind implements Ranking {
    private final Hand hand;

   public ThreeOfAKind(Hand hand) {
       this.hand = hand;
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public int getValue() {
        return 5;
    }
}
