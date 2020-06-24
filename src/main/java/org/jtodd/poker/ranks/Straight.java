package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class Straight implements Ranking {
    public Straight(Hand hand) {
    }

    @Override
    public int getValue() {
        return 4;
    }
}
