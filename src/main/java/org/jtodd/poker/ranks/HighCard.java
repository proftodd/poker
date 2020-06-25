package org.jtodd.poker.ranks;

import org.jtodd.poker.Card;
import org.jtodd.poker.Hand;

import java.util.List;

public class HighCard extends Ranking {
    private final List<Card> sortedByValue;

    public HighCard(Hand hand) {
        super(hand);
        sortedByValue = hand.sortByValue();
        super.tieBreaker = sortedByValue.get(0);
    }

    @Override
    public int getValue() {
        return 8;
    }

    @Override
    public void setTiebreaker(Ranking o) {
        if (this.getValue() == o.getValue()) {
            HighCard ohc = (HighCard) o;
            Hand.findFirstDifference(this.sortedByValue, ohc.sortedByValue)
                    .ifPresent(integer -> super.tieBreaker = this.sortedByValue.get(integer));
        }
    }

    @Override
    public String toString() {
        return "High Card: " + super.tieBreaker;
    }
}
