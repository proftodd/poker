package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;

public class HighCard implements Ranking {
    public HighCard(Hand hand) {
    }

    @Override
    public int compareTo(Ranking o) {
        if (o instanceof HighCard) {
            return 0;
        } else {
            return 1;
        }
    }
}
