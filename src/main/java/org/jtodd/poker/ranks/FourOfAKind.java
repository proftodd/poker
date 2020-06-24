package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class FourOfAKind implements Ranking {
    public FourOfAKind(Hand hand) {
    }

    @Override
    public int compareTo(Ranking o) {
        if (o instanceof StraightFlush) {
            return 1;
        } else if (o instanceof FourOfAKind) {
            return 0;
        } else {
            return -1;
        }
    }
}
