package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class Straight extends Ranking {

    public Straight(Hand hand) {
        super(hand);
    }

    @Override
    public int getValue() {
        return 4;
    }
}
