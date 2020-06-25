package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;
import org.junit.Assert;
import org.junit.Test;

public class TestHighCard {

    @Test
    public void itBreaksTiesInHighCard() {
        HighCard r1 = new HighCard(Hand.parseHand("2C 3H 4S 9D AH").get());
        HighCard r2 = new HighCard(Hand.parseHand("2C 3H 4S 8C AS").get());
        Assert.assertTrue(r1.tieBreaker(r2) < 0);
    }
}
