package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestRanking {

    @Test
    public void itAssignsStraightFlush() {
        String handString = "9H TH JH QH KH";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof StraightFlush);
    }

    @Ignore("low aces not implemented yet")
    @Test
    public void acesCanBeLowForStraightFlush() {
         String handString = "AC 2C 3C 4C 5C";
         Hand theHand = Hand.parseHand(handString).get();
         Assert.assertTrue(Ranking.rank(theHand) instanceof StraightFlush);
    }

    @Test
    public void itAssignsFourOfAKind() {
        String handString = "2S 2D 2C 2H 5C";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof FourOfAKind);
    }

    @Test
    public void itAssignsFullHouse() {
        String handString = "4D 4C 8H 8S 8C";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof FullHouse);
    }

    @Test
    public void itAssignsFlush() {
        String handString = "AH 4H 7H 9H 3H";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof Flush);
    }

    @Test
    public void itAssignsStraight() {
        String handString = "TH AH QC KH JH";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof Straight);
    }

    @Ignore("low aces not implemented yet")
    @Test
    public void itAssignsStraightWithLowAce() {
        String handString = "AD 2C 3S 4H 5D";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof Straight);
    }

    @Test
    public void itAssignsThreeOfAKind() {
        String handString = "QC QS 9H QH 2S";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof ThreeOfAKind);
    }

    @Test
    public void itAssignsTwoPairs() {
        String handString = "QC QS 9H 2S 9D";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof TwoPairs);
    }

    @Test
    public void itAssignsPair() {
        String handString = "QC QS 9H 2S 8D";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof Pair);
    }

    @Test
    public void itAssignsHighCard() {
        String handString = "2C 3H 4S 8C AH";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof HighCard);
    }
}
