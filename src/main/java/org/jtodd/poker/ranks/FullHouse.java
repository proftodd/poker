package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class FullHouse extends Ranking {

    public FullHouse(Hand hand) {
        super(hand);
    }

    @Override
    public int getValue() {
        return 2;
    }
}
