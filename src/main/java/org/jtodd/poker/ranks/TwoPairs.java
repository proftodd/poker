package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class TwoPairs implements Ranking {
    public TwoPairs(Hand hand) {
    }

    @Override
    public int compareTo(Ranking o) {
        if (o instanceof HighCard || o instanceof Pair) {
            return -1;
        } else if (o instanceof TwoPairs) {
            return 0;
        } else {
            return 1;
        }
    }
}
