package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class StraightFlush implements Ranking {
    public StraightFlush(Hand hand) {
    }

    @Override
    public int compareTo(Ranking o) {
        if (o instanceof StraightFlush) {
            return 0;
        } else {
            return -1;
        }
    }
}
