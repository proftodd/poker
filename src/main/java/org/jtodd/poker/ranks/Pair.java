package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class Pair implements Ranking {
    public Pair(Hand hand) {
    }

    @Override
    public int compareTo(Ranking o) {
        if (o instanceof HighCard) {
            return -1;
        } else if (o instanceof Pair) {
            return 0;
        } else {
            return 1;
        }
    }
}
