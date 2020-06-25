package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class StraightFlush extends Straight {

    public StraightFlush(Hand hand) {
        super(hand);
    }

    @Override
    public int getValue() {
        return 0;
    }
    @Override
    public String toString() {
        return String.format("Straight Flush: %s to %s of %s", super.high.toString(), super.low.toString(), high.suitString());
    }
}
