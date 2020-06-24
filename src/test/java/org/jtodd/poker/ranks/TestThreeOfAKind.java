package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;
import org.junit.Assert;
import org.junit.Test;

public class TestThreeOfAKind {

    @Test
    public void itBreakTiesInThreeOfAKind() {
        ThreeOfAKind r1 = new ThreeOfAKind(Hand.parseHand("QC QS 9H QH 2S").get());
        ThreeOfAKind r2 = new ThreeOfAKind(Hand.parseHand("AC AD AH 2S KC").get());
        Assert.assertTrue(r1.compareTo(r2) > 0);
    }
}
