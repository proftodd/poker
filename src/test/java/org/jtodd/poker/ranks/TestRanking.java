package org.jtodd.poker.ranks;

import org.jtodd.poker.Hand;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestRanking {

    @Test
    public void itAssignsStraightFlush() {
        String handString = "9H TH JH QH KH";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof StraightFlush);
    }

    @Test
    public void acesCanBeLowForStraightFlush() {
         String handString = "AC 2C 3C 4C 5C";
         Hand theHand = Hand.parseHand(handString).get();
         Assert.assertTrue(Ranking.rank(theHand) instanceof StraightFlush);
    }

    @Test
    public void itAssignsFourOfAKind() {
        String handString = "2S 2D 2C 2H 5C";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof FourOfAKind);
    }

    @Test
    public void itAssignsFullHouse() {
        String handString = "4D 4C 8H 8S 8C";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof FullHouse);
    }

    @Test
    public void itAssignsFlush() {
        String handString = "AH 4H 7H 9H 3H";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof Flush);
    }

    @Test
    public void itAssignsStraight() {
        String handString = "TH AH QC KH JH";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof Straight);
    }

    @Test
    public void itAssignsStraightWithLowAce() {
        String handString = "AD 2C 3S 4H 5D";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof Straight);
    }

    @Test
    public void itAssignsThreeOfAKind() {
        String handString = "QC QS 9H QH 2S";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof ThreeOfAKind);
    }

    @Test
    public void itAssignsTwoPairs() {
        String handString = "QC QS 9H 2S 9D";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof TwoPairs);
    }

    @Test
    public void itAssignsPair() {
        String handString = "QC QS 9H 2S 8D";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof Pair);
    }

    @Test
    public void itAssignsHighCard() {
        String handString = "2C 3H 4S 8C AH";
        Hand theHand = Hand.parseHand(handString).get();
        Assert.assertTrue(Ranking.rank(theHand) instanceof HighCard);
    }

    @Test
    public void itRanksHandCorrectly() {
        List<Hand> hands = new ArrayList<>();
        hands.add(Hand.parseHand("2C 3H 4S 8C AH").get()); // high card
        hands.add(Hand.parseHand("QC QS 9H 2S 8D").get()); // pair
        hands.add(Hand.parseHand("QC QS 9H 2S 9D").get()); // two pairs
        hands.add(Hand.parseHand("QC QS 9H QH 2S").get()); // three of a kind
        hands.add(Hand.parseHand("TH AH QC KH JH").get()); // straight
        hands.add(Hand.parseHand("AH 4H 7H 9H 3H").get()); // flush
        hands.add(Hand.parseHand("4D 4C 8H 8S 8C").get()); // full house
        hands.add(Hand.parseHand("2S 2D 2C 2H 5C").get()); // four of a kind
        hands.add(Hand.parseHand("9H TH JH QH KH").get()); // straight flush
        Collections.shuffle(hands);

        List<Ranking> ranks = hands.stream().map(Ranking::rank).sorted().collect(Collectors.toList());

        Assert.assertTrue(ranks.get(0) instanceof StraightFlush);
        Assert.assertTrue(ranks.get(1) instanceof FourOfAKind);
        Assert.assertTrue(ranks.get(2) instanceof FullHouse);
        Assert.assertTrue(ranks.get(3) instanceof Flush);
        Assert.assertTrue(ranks.get(4) instanceof Straight);
        Assert.assertTrue(ranks.get(5) instanceof ThreeOfAKind);
        Assert.assertTrue(ranks.get(6) instanceof TwoPairs);
        Assert.assertTrue(ranks.get(7) instanceof Pair);
        Assert.assertTrue(ranks.get(8) instanceof HighCard);
    }
}
