package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class FourOfAKind implements Ranking {
    public FourOfAKind(Hand hand) {
    }

    @Override
    public int getValue() {
        return 1;
    }
}
