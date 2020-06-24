package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class Flush extends Ranking {

    public Flush(Hand hand) {
        super(hand);
    }

    @Override
    public int getValue() {
        return 3;
    }
}
