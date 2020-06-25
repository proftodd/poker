package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;
import org.junit.Assert;
import org.junit.Test;

public class TestStraightFlush {

    @Test
    public void itBreaksTiesInStraightFlush() {
        StraightFlush r1 = new StraightFlush(Hand.parseHand("9H TH JH QH KH").get());
        StraightFlush r2 = new StraightFlush(Hand.parseHand("2S 3S 4S 5S 6S").get());
        Assert.assertTrue(r1.tieBreaker(r2) < 0);
    }

    @Test
    public void itGeneratesCorrectString() {
        Ranking r = new StraightFlush(Hand.parseHand("9H TH JH QH KH").get());
        Assert.assertEquals("Straight Flush: King to 9 of Hearts", r.toString());
    }

    @Test
    public void itGeneratesCorrectStringForLowAce() {
        Ranking r = new Straight(Hand.parseHand("AH 2H 5H 3H 4H").get());
        Assert.assertEquals("Straight: 5 to Ace", r.toString());
    }
}
