package org.jtodd.poker.ranks;

import org.jtodd.poker.Card;
import org.jtodd.poker.Hand;

import java.util.List;

public class Flush extends Ranking {

    public Flush(Hand hand) {
        super(hand);
    }

    @Override
    public int getValue() {
        return 3;
    }

    @Override
    public void setTiebreaker(Ranking o) {
        if (this.getValue() == o.getValue()) {
            List<Card> meSortedByValue = this.getHand().sortByValue();
            List<Card> otherSortedByValue = o.getHand().sortByValue();
            Hand.findFirstDifference(meSortedByValue, otherSortedByValue)
                    .ifPresent(integer -> super.tieBreaker = meSortedByValue.get(integer));
        }
    }

    @Override
    public String toString() {
        return String.format("Flush: %s", this.getHand().theCards().iterator().next().suitString());
    }
}
