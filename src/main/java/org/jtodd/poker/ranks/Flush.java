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
    public int tieBreaker(Ranking o) {
        if (this.getValue() == o.getValue()) {
            List<Card> meSortedByValue = this.getHand().sortByValue();
            List<Card> otherSortedByValue = o.getHand().sortByValue();
            for (int i = 0; i < meSortedByValue.size() && i < otherSortedByValue.size(); ++i) {
                Card myCard = meSortedByValue.get(i);
                Card otherCard = otherSortedByValue.get(i);
                if (myCard.numericValue != otherCard.numericValue) {
                    return Integer.compare(otherCard.numericValue, myCard.numericValue);
                }
            }
            return 0;
        } else {
            return this.compareTo(o);
        }
    }

    @Override
    public void setTiebreaker(Ranking o) {
        if (this.getValue() == o.getValue()) {
            List<Card> meSortedByValue = this.getHand().sortByValue();
            List<Card> otherSortedByValue = o.getHand().sortByValue();
            for (int i = 0; i < meSortedByValue.size() && i < otherSortedByValue.size(); ++i) {
                Card myCard = meSortedByValue.get(i);
                Card otherCard = otherSortedByValue.get(i);
                if (myCard.numericValue != otherCard.numericValue) {
                    super.tieBreaker = myCard;
                }
            }
        } else {
            super.tieBreaker = this.getHand().sortByValue().get(0);
        }
    }

    @Override
    public String toString() {
        return "Flush";
    }
}
