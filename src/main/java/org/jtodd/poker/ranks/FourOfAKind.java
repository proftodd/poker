package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class FourOfAKind extends Ranking {

    public FourOfAKind(Hand hand) {
        super(hand);
    }

    @Override
    public int getValue() {
        return 1;
    }
}
