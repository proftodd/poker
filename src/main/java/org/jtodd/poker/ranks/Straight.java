package org.jtodd.poker.ranks;

import org.jtodd.poker.Card;
import org.jtodd.poker.Hand;

import java.util.List;

public class Straight extends Ranking {

    public Straight(Hand hand) {
        super(hand);
    }

    @Override
    public int getValue() {
        return 4;
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
        return String.format("Straight: %s to %s", high.toString(), low.toString());
    }
}
