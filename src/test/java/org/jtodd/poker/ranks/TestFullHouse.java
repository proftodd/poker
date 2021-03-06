package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;
import org.junit.Assert;
import org.junit.Test;

public class TestFullHouse {

    @Test
    public void itBreaksTiesInFullHouse() {
        FullHouse r1 = new FullHouse(Hand.parseHand("4D 4C 8H 8S 8C").get());
        FullHouse r2 = new FullHouse(Hand.parseHand("KC KH 6D 6H 6C").get());
        Assert.assertTrue(r1.tieBreaker(r2) < 0);
    }

    @Test
    public void itGeneratesCorrectString() {
        Ranking r = new FullHouse(Hand.parseHand("4D 4C 8H 8S 8C").get());
        Assert.assertEquals("Full House: 8 over 4", r.toString());
    }
}
