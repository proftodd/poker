package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;
import org.junit.Assert;
import org.junit.Test;

public class TestFlush {

    @Test
    public void itBreaksTiesInFlush() {
        Flush r1 = new Flush(Hand.parseHand("AH 4H 7H 9H 3H").get());
        Flush r2 = new Flush(Hand.parseHand("AC 4C 7C 9C 2C").get());
        Assert.assertTrue(r1.compareTo(r2) < 0);
    }
}
