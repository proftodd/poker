package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class Pair extends Ranking {

    public Pair(Hand hand) {
        super(hand);
    }

    @Override
    public int getValue() {
        return 7;
    }
}
