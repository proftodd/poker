package org.jtodd.poker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
import java.util.Set;

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

    @Test
    public void itParsesAHandIntoTheCorrectCards() {
        String handString = "2H 3D 5S 9C KD";
        Hand theHand = Hand.parseHand(handString).get();
        Set<Card> theCards = theHand.theCards();
        Assert.assertTrue(theCards.contains(new Card('2', 'H')));
        Assert.assertTrue(theCards.contains(new Card('3', 'D')));
        Assert.assertTrue(theCards.contains(new Card('5', 'S')));
        Assert.assertTrue(theCards.contains(new Card('9', 'C')));
        Assert.assertTrue(theCards.contains(new Card('K', 'D')));
    }
}
