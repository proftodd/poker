package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class ThreeOfAKind implements Ranking {
    public ThreeOfAKind(Hand hand) {
    }

    @Override
    public int getValue() {
        return 5;
    }
}
