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

    @Test
    public void itAssignsFullHouse() {
        String handString = "4D 4C 8H 8S 8C";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertEquals(Ranking.FULL_HOUSE, Ranking.rank(theHand));
    }

    @Test
    public void itAssignsFlush() {
        String handString = "AH 4H 7H 9H 3H";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertEquals(Ranking.FLUSH, Ranking.rank(theHand));
    }

    @Test
    public void itAssignsStraight() {
        String handString = "TH AH QC KH JH";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertEquals(Ranking.STRAIGHT, Ranking.rank(theHand));
    }

    @Test
    public void itAssignsThreeOfAKind() {
        String handString = "QC QS 9H QH 2S";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertEquals(Ranking.THREE_OF_A_KIND, Ranking.rank(theHand));
    }

    @Test
    public void itAssignsTwoPairs() {
        String handString = "QC QS 9H 2S 9D";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertEquals(Ranking.TWO_PAIRS, Ranking.rank(theHand));
    }

    @Test
    public void itAssignsPair() {
        String handString = "QC QS 9H 2S 8D";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertEquals(Ranking.PAIR, Ranking.rank(theHand));
    }

    @Test
    public void itAssignsHighCard() {
        String handString = "2C 3H 4S 8C AH";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertEquals(Ranking.HIGH_CARD, Ranking.rank(theHand));
    }
}
