package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class Straight implements Ranking {
    public Straight(Hand hand) {
    }

    @Override
    public int compareTo(Ranking o) {
        if (o instanceof StraightFlush || o instanceof FourOfAKind || o instanceof FullHouse || o instanceof Flush) {
            return 1;
        } else if (o instanceof Straight) {
            return 0;
        } else {
            return -1;
        }
    }
}
