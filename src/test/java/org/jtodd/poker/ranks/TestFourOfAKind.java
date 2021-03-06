package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;
import org.junit.Assert;
import org.junit.Test;

public class TestFourOfAKind {

    @Test
    public void itBreakTiesInFourOfAKind() {
        FourOfAKind r1 = new FourOfAKind(Hand.parseHand("2S 2D 2C 2H 5C").get());
        FourOfAKind r2 = new FourOfAKind(Hand.parseHand("AC AD AH AS KC").get());
        Assert.assertTrue(r1.tieBreaker(r2) > 0);
    }

    @Test
    public void itGeneratesCorrectString() {
        Ranking r = new FourOfAKind(Hand.parseHand("2S 2D 2C 2H 5C").get());
        Assert.assertEquals("Four of a Kind: 2", r.toString());
    }
}
