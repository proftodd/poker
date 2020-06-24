package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class TwoPairs implements Ranking {
    public TwoPairs(Hand hand) {
    }

    @Override
    public int getValue() {
        return 6;
    }
}
