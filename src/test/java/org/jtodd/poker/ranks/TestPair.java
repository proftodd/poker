package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;
import org.junit.Assert;
import org.junit.Test;

public class TestPair {

    @Test
    public void itBreaksTiesInPairBasedOnPair() {
        Pair p1 = new Pair(Hand.parseHand("KC KS 9H 2S 8D").get());
        Pair p2 = new Pair(Hand.parseHand("QC QS 9C 2D 8C").get());
        Assert.assertTrue(p1.compareTo(p2) < 0);
    }

    @Test
    public void itBreaksTiesInPairBasedOnRest() {
        Pair p1 = new Pair(Hand.parseHand("QC QS 9H 2S 8D").get());
        Pair p2 = new Pair(Hand.parseHand("QC QS 9C 2D 7C").get());
        Assert.assertTrue(p1.compareTo(p2) < 0);
    }
}
