package org.jtodd.poker.ranks;

import org.jtodd.poker.Card;
import org.jtodd.poker.Hand;

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
            Card myHighCard = this.getHand().sortByValue().get(this.getHand().theCards().size() - 1);
            Card otherHighCard = o.getHand().sortByValue().get(o.getHand().theCards().size() - 1);
            return Integer.compare(otherHighCard.numericValue, myHighCard.numericValue);
        } else {
            return 1;
        }
    }
}
