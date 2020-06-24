package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class TwoPairs extends Ranking {

    public TwoPairs(Hand hand) {
        super(hand);
    }

    @Override
    public int getValue() {
        return 6;
    }
}
