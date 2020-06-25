package org.jtodd.poker.ranks;

import org.jtodd.poker.Card;
import org.jtodd.poker.Hand;

import java.util.List;
import java.util.Map;

public class FullHouse extends Ranking {
    Card theTrio;
    Card thePair;

    public FullHouse(Hand hand) {
        super(hand);
        Map<Character, List<Card>> grouped = hand.partitionByValue();
        theTrio = grouped
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() == 3)
                .findFirst()
                .get()
                .getValue()
                .get(0);
        thePair = grouped
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() == 2)
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
    public int tieBreaker(Ranking o) {
        if (this.getValue() == o.getValue()) {
            FullHouse ofh = (FullHouse) o;
            return Integer.compare(ofh.theTrio.numericValue, this.theTrio.numericValue);
        } else {
            return this.compareTo(o);
        }
    }

    @Override
    public void setTiebreaker(Ranking o) {
        super.tieBreaker = theTrio;
    }

    @Override
    public String toString() {
        return String.format("Full House: %s over %s", theTrio, thePair);
    }
}
