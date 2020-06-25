package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;
import org.junit.Assert;
import org.junit.Test;

public class TestPair {

    @Test
    public void itBreaksTiesInPairBasedOnPair() {
        Pair r1 = new Pair(Hand.parseHand("KC KS 9H 2S 8D").get());
        Pair r2 = new Pair(Hand.parseHand("QC QS 9C 2D 8C").get());
        Assert.assertTrue(r1.tieBreaker(r2) < 0);
    }

    @Test
    public void itBreaksTiesInPairBasedOnRest() {
        Pair r1 = new Pair(Hand.parseHand("QC QS 9H 2S 8D").get());
        Pair r2 = new Pair(Hand.parseHand("QC QS 9C 2D 7C").get());
        Assert.assertTrue(r1.tieBreaker(r2) < 0);
    }
}
