package org.jtodd.poker;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
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

    @Test
    public void itSortsBySuit() {
        String handString = "AH AC AS AD 9S";
        Hand theHand = Hand.parseHand(handString).get();
        List<Card> sortedBySuit = theHand.sortBySuit();
        Assert.assertEquals(new Card('A', 'C'), sortedBySuit.get(0));
        Assert.assertEquals(new Card('A', 'D'), sortedBySuit.get(1));
        Assert.assertEquals(new Card('A', 'H'), sortedBySuit.get(2));
        List<Card> spades = sortedBySuit.subList(3, 5);
        Assert.assertTrue(spades.contains(new Card('9', 'S')));
        Assert.assertTrue(spades.contains(new Card('A', 'S')));
    }

    @Test
    public void itSortsByValue() {
        String handString = "AH 2C 4S 3H 4C";
        Hand theHand = Hand.parseHand(handString).get();
        List<Card> sortedByValue = theHand.sortByValue();
        Assert.assertEquals(new Card('2', 'C'), sortedByValue.get(0));
        Assert.assertEquals(new Card('3', 'H'), sortedByValue.get(1));
        List<Card> fours = sortedByValue.subList(2, 4);
        Assert.assertTrue(fours.contains(new Card('4', 'C')));
        Assert.assertTrue(fours.contains(new Card('4', 'S')));
        Assert.assertEquals(new Card('A', 'H'), sortedByValue.get(4));
    }
}
