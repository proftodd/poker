package org.jtodd.poker.ranks;

import org.jtodd.poker.Card;
import org.jtodd.poker.Hand;

import java.util.List;

public class StraightFlush extends Ranking {

    public StraightFlush(Hand hand) {
        super(hand);
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public void setTiebreaker(Ranking o) {
        super.tieBreaker = this.getHand().sortByValue().get(0);
    }

    @Override
    public String toString() {
        List<Card> sorted = this.getHand().sortByValue();
        Card high = sorted.get(0);
        Card low = sorted.get(sorted.size() - 1);
        return String.format("Straight Flush: %s to %s of %s", high.toString(), low.toString(), high.suitString());
    }
}
