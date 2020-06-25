package org.jtodd.poker.ranks;

import org.jtodd.poker.Card;
import org.jtodd.poker.Hand;

import java.util.*;

public class Pair extends Ranking {
    Card thePair;
    List<Card> theRestSorted;

    public Pair(Hand hand) {
        super(hand);
        Map<Character, List<Card>> sorted = hand.partitionByValue();
        theRestSorted = new ArrayList<>();
        for (List<Card> bucket : sorted.values()) {
            if (bucket.size() == 2) {
                thePair = bucket.get(0);
            } else {
                theRestSorted.add(bucket.get(0));
            }
        }
        theRestSorted.sort((c1, c2) -> Integer.compare(c2.numericValue, c1.numericValue));
    }

    @Override
    public int getValue() {
        return 7;
    }

    @Override
    public int tieBreaker(Ranking o) {
        if (this.getValue() == o.getValue()) {
            Pair op = (Pair) o;
            if (this.thePair.numericValue != op.thePair.numericValue) {
                return Integer.compare(op.thePair.numericValue, this.thePair.numericValue);
            } else {
                return Hand.compareFirstDifference(this.theRestSorted, op.theRestSorted);
            }
        } else {
            return this.compareTo(o);
        }
    }

    @Override
    public void setTiebreaker(Ranking o) {
        if (this.getValue() == o.getValue()) {
            Pair p = (Pair) o;
            if (this.thePair.numericValue != p.thePair.numericValue) {
                super.tieBreaker = this.thePair;
            } else {
                Hand.findFirstDifference(this.theRestSorted, p.theRestSorted)
                        .ifPresent(integer -> super.tieBreaker = this.theRestSorted.get(integer));
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Pair: of %ss", thePair.toString());
    }
}
