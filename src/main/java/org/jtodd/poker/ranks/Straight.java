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
    public int tieBreaker(Ranking o) {
        if (this.getValue() == o.getValue()) {
            Card myHighCard = this.getHand().sortByValue().get(this.getHand().theCards().size() - 1);
            Card otherHighCard = o.getHand().sortByValue().get(o.getHand().theCards().size() - 1);
            return Integer.compare(otherHighCard.numericValue, myHighCard.numericValue);
        } else {
            return this.compareTo(o);
        }
    }

    @Override
    public String toString() {
        return "Straight";
    }
}
