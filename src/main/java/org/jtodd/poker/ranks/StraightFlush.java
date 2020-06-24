package org.jtodd.poker.ranks;

import org.jtodd.poker.Card;
import org.jtodd.poker.Hand;

public class StraightFlush implements Ranking {
    private final Hand hand;

    public StraightFlush(Hand hand) {
        this.hand = hand;
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public int compareTo(Ranking o) {
        if (o.getValue() == 0) {
            Card myHighCard = hand.theCards().stream().max(Card::compareTo).get();
            Card otherHighCard = o.getHand().theCards().stream().max(Card::compareTo).get();
            return myHighCard.compareTo(otherHighCard);
        } else {
            return -1;
        }
    }
}
