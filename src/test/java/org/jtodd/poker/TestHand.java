package org.jtodd.poker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class TestHand {

    @Test
    public void itParsesAValidHand() {
        String handString = "2H 3H 4H 5H 6H";
        Optional<Hand> thePossibleHand = Hand.parseHand(handString);
        Assert.assertTrue(thePossibleHand.isPresent());
    }

    @Test
    public void itReturnsEmptyOptionalForInvalidHand() {
        String handString = "hoohah";
        Optional<Hand> thePossibleHand = Hand.parseHand(handString);
        Assert.assertTrue(thePossibleHand.isEmpty());
    }
}
