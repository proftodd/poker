package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class HighCard extends Ranking {

    public HighCard(Hand hand) {
        super(hand);
    }

    @Override
    public int getValue() {
        return 8;
    }
}
