package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class ThreeOfAKind implements Ranking {
    public ThreeOfAKind(Hand hand) {
    }

    @Override
    public int compareTo(Ranking o) {
        if (o instanceof HighCard || o instanceof Pair || o instanceof TwoPairs) {
            return -1;
        } else if (o instanceof ThreeOfAKind) {
            return 0;
        } else {
            return 1;
        }
    }
}
