package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class HighCard implements Ranking {
    public HighCard(Hand hand) {
    }

    @Override
    public int getValue() {
        return 8;
    }
}
