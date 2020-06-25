package org.jtodd.poker.ranks;

import org.jtodd.poker.Card;
import org.jtodd.poker.Hand;

import java.util.List;

public class HighCard extends Ranking {
    private final List<Card> sortedByValue;

    public HighCard(Hand hand) {
        super(hand);
        sortedByValue = hand.sortByValue();
    }

    @Override
    public int getValue() {
        return 8;
    }

    @Override
    public int compareTo(Ranking o) {
        if (this.getValue() == o.getValue()) {
            HighCard ohc = (HighCard) o;
            for (int i = this.sortedByValue.size() - 1; i >= 0; --i) {
                Card myCard = this.sortedByValue.get(i);
                Card otherCard = ohc.sortedByValue.get(i);
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
        return "High Card: " + this.sortedByValue.get(this.sortedByValue.size() - 1);
    }
}
