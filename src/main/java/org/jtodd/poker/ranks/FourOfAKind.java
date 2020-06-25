package org.jtodd.poker.ranks;

import org.jtodd.poker.Card;
import org.jtodd.poker.Hand;

public class FourOfAKind extends Ranking {

    private final Card theQuad;

    public FourOfAKind(Hand hand) {
        super(hand);
        theQuad = hand
                .partitionByValue()
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() == 4)
                .findFirst()
                .get()
                .getValue()
                .get(0);
    }

    @Override
    public int getValue() {
        return 1;
    }

    @Override
    public int tieBreaker(Ranking o) {
        if (this.getValue() == o.getValue()) {
            FourOfAKind ofk = (FourOfAKind) o;
            return Integer.compare(ofk.theQuad.numericValue, this.theQuad.numericValue);
        } else {
            return this.compareTo(o);
        }
    }

    @Override
    public void setTiebreaker(Ranking o) {
        super.tieBreaker = theQuad;
    }

    @Override
    public String toString() {
        return String.format("Four of a Kind: %s", theQuad.toString());
    }
}
