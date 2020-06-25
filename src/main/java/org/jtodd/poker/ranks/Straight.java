package org.jtodd.poker.ranks;

import org.jtodd.poker.Card;
import org.jtodd.poker.Hand;

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
        return "Straight";
    }
}
