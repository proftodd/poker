package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class Pair implements Ranking {
    public Pair(Hand hand) {
    }

    @Override
    public int getValue() {
        return 7;
    }
}
