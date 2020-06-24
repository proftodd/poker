package org.jtodd.poker.ranks;

import org.jtodd.poker.Card;
import org.jtodd.poker.Hand;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoPairs extends Ranking {
    private final Card theHighPair;
    private final Card theLowPair;
    private final Card theOtherOne;

    public TwoPairs(Hand hand) {
        super(hand);
        Map<Character, List<Card>> sorted = hand.partitionByValue();
        List<Card> thePairs = sorted
                .values()
                .stream()
                .filter(l -> l.size() == 2)
                .map(l -> l.get(0))
                .collect(Collectors.toList());
        if (thePairs.get(0).numericValue > thePairs.get(1).numericValue) {
            theHighPair = thePairs.get(0);
            theLowPair = thePairs.get(1);
        } else {
            theHighPair = thePairs.get(1);
            theLowPair = thePairs.get(0);
        }
        theOtherOne = sorted
                .values()
                .stream()
                .filter(l -> l.size() == 1)
                .map(l -> l.get(0))
                .findFirst()
                .get();
    }

    @Override
    public int getValue() {
        return 6;
    }

    @Override
    public int compareTo(Ranking o) {
        if (this.getValue() == o.getValue()) {
            TwoPairs otp = (TwoPairs) o;
            if (this.theHighPair.numericValue != otp.theHighPair.numericValue) {
                return Integer.compare(otp.theHighPair.numericValue, this.theHighPair.numericValue);
            } else if (this.theLowPair.numericValue != otp.theLowPair.numericValue) {
                return Integer.compare(otp.theLowPair.numericValue, this.theLowPair.numericValue);
            } else {
                return Integer.compare(otp.theOtherOne.numericValue, this.theOtherOne.numericValue);
            }
        } else {
            return Integer.compare(this.getValue(), o.getValue());
        }
    }
}
