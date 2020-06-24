package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class FullHouse implements Ranking {
    public FullHouse(Hand hand) {
    }

    @Override
    public int compareTo(Ranking o) {
        if (o instanceof StraightFlush || o instanceof FourOfAKind) {
            return 1;
        } else if (o instanceof FullHouse) {
            return 0;
        } else {
            return -1;
        }
    }
}
