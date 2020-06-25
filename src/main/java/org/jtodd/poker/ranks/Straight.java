package org.jtodd.poker.ranks;

import org.jtodd.poker.Card;
import org.jtodd.poker.Hand;

import java.util.List;

public class Straight extends Ranking {

    protected final Card high;
    protected final Card low;

    public Straight(Hand hand) {
        super(hand);
        List<Card> sorted = hand.sortByValue();
        if (sorted.get(0).value == 'A' && sorted.get(1).value == '5') {
            high = sorted.get(1);
            low = sorted.get(0);
        } else {
            high = sorted.get(0);
            low = sorted.get(sorted.size() - 1);
        }
    }

    @Override
    public int getValue() {
        return 4;
    }

    @Override
    public void setTiebreaker(Ranking o) {
        super.tieBreaker = this.high;
    }

    @Override
    public String toString() {
        return String.format("Straight: %s to %s", high.toString(), low.toString());
    }
}
