package org.jtodd.poker.ranks;

import org.jtodd.poker.Card;
import org.jtodd.poker.Hand;

public class StraightFlush extends Ranking {

    public StraightFlush(Hand hand) {
        super(hand);
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public int tieBreaker(Ranking o) {
        if (this.getValue() == o.getValue()) {
            Card myHighCard = this.getHand().sortByValue().get(0);
            Card otherHighCard = o.getHand().sortByValue().get(0);
            return Integer.compare(otherHighCard.numericValue, myHighCard.numericValue);
        } else {
            return this.compareTo(o);
        }
    }

    @Override
    public void setTiebreaker(Ranking o) {
        super.tieBreaker = this.getHand().sortByValue().get(0);
    }

    @Override
    public String toString() {
        return "Straight Flush";
    }
}
