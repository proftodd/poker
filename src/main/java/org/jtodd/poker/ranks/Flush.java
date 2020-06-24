package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class Flush implements Ranking {

    public Flush(Hand hand) {

    }

    @Override
    public int compareTo(Ranking o) {
        if (o instanceof StraightFlush || o instanceof FourOfAKind || o instanceof FullHouse) {
            return 1;
        } else if (o instanceof Flush) {
            return 0;
        } else {
            return -1;
        }
    }
}
