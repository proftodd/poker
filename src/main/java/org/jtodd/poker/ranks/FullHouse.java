package org.jtodd.poker.ranks;

import org.jtodd.poker.Card;
import org.jtodd.poker.Hand;

public class FullHouse extends Ranking {
    Card theTrio;

    public FullHouse(Hand hand) {
        super(hand);
        theTrio = hand
                .partitionByValue()
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() == 3)
                .findFirst()
                .get()
                .getValue()
                .get(0);
    }

    @Override
    public int getValue() {
        return 2;
    }

    @Override
    public int compareTo(Ranking o) {
        if (this.getValue() == o.getValue()) {
            FullHouse ofh = (FullHouse) o;
            return Integer.compare(ofh.theTrio.numericValue, this.theTrio.numericValue);
        } else {
            return Integer.compare(this.getValue(), o.getValue());
        }
    }

    @Override
    public String toString() {
        return "Full House";
    }
}
