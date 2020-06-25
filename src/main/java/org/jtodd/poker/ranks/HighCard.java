package org.jtodd.poker.ranks;

import org.jtodd.poker.Card;
import org.jtodd.poker.Hand;

import java.util.List;

public class HighCard extends Ranking {

    public HighCard(Hand hand) {
        super(hand);
    }

    @Override
    public int getValue() {
        return 8;
    }

    @Override
    public int compareTo(Ranking o) {
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
            return 1;
        }
    }

    @Override
    public String toString() {
        return "High Card";
    }
}
