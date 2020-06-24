package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class ThreeOfAKind extends Ranking {

   public ThreeOfAKind(Hand hand) {
       super(hand);
    }

    @Override
    public int getValue() {
        return 5;
    }
}
