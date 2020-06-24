package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class FullHouse implements Ranking {
    public FullHouse(Hand hand) {
    }

    @Override
    public int getValue() {
        return 2;
    }
}
