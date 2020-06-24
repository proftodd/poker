package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;
import org.junit.Assert;
import org.junit.Test;

public class TestStraightFlush {

    @Test
    public void itBreaksTiesInStraightFlush() {
        StraightFlush r1 = new StraightFlush(Hand.parseHand("9H TH JH QH KH").get());
        StraightFlush r2 = new StraightFlush(Hand.parseHand("2S 3S 4S 5S 6S").get());
        Assert.assertTrue(r1.compareTo(r2) < 0);
    }
}
