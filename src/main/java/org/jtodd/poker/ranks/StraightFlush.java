package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class StraightFlush implements Ranking {
    public StraightFlush(Hand hand) {
    }

    @Override
    public int getValue() {
        return 0;
    }
}
