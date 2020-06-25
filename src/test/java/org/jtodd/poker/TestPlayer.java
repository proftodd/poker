package org.jtodd.poker;

import org.jtodd.poker.ranks.HighCard;
import org.jtodd.poker.ranks.Ranking;
import org.jtodd.poker.ranks.StraightFlush;
import org.junit.Assert;
import org.junit.Test;

public class TestPlayer {

    @Test
    public void itGeneratesCorrectWinnerString() {
        Ranking ranking = new StraightFlush(Hand.parseHand("9H TH JH QH KH").get());
        Player player = new Player("White", ranking);
        Assert.assertEquals("White wins. - with Straight Flush: King to 9 of Hearts", player.toString());
    }

    @Test
    public void itGeneratesCorrectWinnerStringForHighCardWithFaceCard() {
        Ranking ranking = new HighCard(Hand.parseHand("2C 3H 4S 8C AH").get());
        Player player = new Player("Black", ranking);
        Assert.assertEquals("Black wins. - with High Card: Ace", player.toString());
    }

    @Test
    public void itGeneratesCorrectWinnerStringForHighCardWithNumberCard() {
        Ranking ranking = new HighCard(Hand.parseHand("2C 3H 4S 8C TH").get());
        Player player = new Player("Black", ranking);
        Assert.assertEquals("Black wins. - with High Card: 10", player.toString());
    }
}
