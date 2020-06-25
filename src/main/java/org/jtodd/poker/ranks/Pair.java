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
        Collections.sort(theRestSorted, (c1, c2) -> Integer.compare(c2.numericValue, c1.numericValue));
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
                for (int i = this.theRestSorted.size() - 1; i >= 0; --i) {
                    Card myCard = this.theRestSorted.get(i);
                    Card otherCard = op.theRestSorted.get(i);
                    if (myCard.numericValue != otherCard.numericValue) {
                        return Integer.compare(otherCard.numericValue, myCard.numericValue);
                    }
                }
                return 0;
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
        return "Pair";
    }
}
