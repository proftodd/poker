package org.jtodd.poker.ranks;

import org.jtodd.poker.Card;
import org.jtodd.poker.Hand;

public class StraightFlush extends Ranking {

    public StraightFlush(Hand hand) {
        super(hand);
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public int compareTo(Ranking o) {
        if (o.getValue() == 0) {
            Card myHighCard = this.getHand().theCards().stream().max(Card::compareTo).get();
            Card otherHighCard = o.getHand().theCards().stream().max(Card::compareTo).get();
            return myHighCard.compareTo(otherHighCard);
        } else {
            return -1;
        }
    }
}
