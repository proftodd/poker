package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;
import org.junit.Assert;
import org.junit.Test;

public class TestTwoPairs {

    @Test
    public void itBreaksTiesInTwoPairBasedOnHigherPair() {
        TwoPairs r1 = new TwoPairs(Hand.parseHand("KC KS 9H 2S 9D").get());
        TwoPairs r2 = new TwoPairs(Hand.parseHand("QC QS 9H 2S 9D").get());
        Assert.assertTrue(r1.tieBreaker(r2) < 0);
    }

    @Test
    public void itBreaksTiesInTwoPairBasedOnLowerPair() {
        TwoPairs r1 = new TwoPairs(Hand.parseHand("KC KS TH 2S TD").get());
        TwoPairs r2 = new TwoPairs(Hand.parseHand("KC KS 9H 2S 9D").get());
        Assert.assertTrue(r1.tieBreaker(r2) < 0);
    }

    @Test
    public void itBreaksTiesInTwoPairBasedOnSingleton() {
        TwoPairs r1 = new TwoPairs(Hand.parseHand("KC KS 9H 3S 9D").get());
        TwoPairs r2 = new TwoPairs(Hand.parseHand("KC KS 9H 2S 9D").get());
        Assert.assertTrue(r1.tieBreaker(r2) < 0);
    }

    @Test
    public void itGeneratesCorrectString() {
        Ranking r = new TwoPairs(Hand.parseHand("KC KS 9H 2S 9D").get());
        Assert.assertEquals("Two Pairs: Kings and 9s", r.toString());
    }
}
