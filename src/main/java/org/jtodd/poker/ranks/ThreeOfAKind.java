package org.jtodd.poker.ranks;

import org.jtodd.poker.Card;
import org.jtodd.poker.Hand;

public class ThreeOfAKind extends Ranking {
    Card theTrio;

   public ThreeOfAKind(Hand hand) {
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
        return 5;
    }

    @Override
    public int compareTo(Ranking o) {
        if (this.getValue() == o.getValue()) {
            ThreeOfAKind tfk = (ThreeOfAKind) o;
            return Integer.compare(tfk.theTrio.numericValue, this.theTrio.numericValue);
        } else {
            return Integer.compare(this.getValue(), o.getValue());
        }
    }

    @Override
    public String toString() {
        return "Three of a Kind";
    }
}
