package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class Flush implements Ranking {

    public Flush(Hand hand) {

    }

    @Override
    public int getValue() {
        return 3;
    }
}
