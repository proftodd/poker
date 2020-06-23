package org.jtodd.poker;

import org.junit.Assert;
import org.junit.Test;

public class TestRanking {

    @Test
    public void itAssignsStraightFlush() {
        String handString = "9H TH JH QH KH";
        Hand theHand;

        theHand = Hand.parseHand(handString).get();
        Assert.assertEquals(Ranking.STRAIGHT_FLUSH, Ranking.rank(theHand));

        // TODO: Make sure aces can be high or low
        // String handString2 = "AC 2C 3C 4C 5C";
        // theHand = Hand.parseHand(handString2).get();
        // Assert.assertEquals(Ranking.STRAIGHT_FLUSH, Ranking.rank(theHand));
    }

    @Test
    public void itAssignsFourOfAKind() {
        String handString = "2S 2D 2C 2H 5C";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertEquals(Ranking.FOUR_OF_A_KIND, Ranking.rank(theHand));
    }
}
