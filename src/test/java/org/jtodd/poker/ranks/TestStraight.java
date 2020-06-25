package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;
import org.junit.Assert;
import org.junit.Test;

public class TestStraight {

    @Test
    public void itBreaksTiesInStraight() {
        Straight r1 = new Straight(Hand.parseHand("9H TH JC QH KH").get());
        Straight r2 = new Straight(Hand.parseHand("2S 3S 4D 5S 6S").get());
        Assert.assertTrue(r1.tieBreaker(r2) < 0);
    }
}
