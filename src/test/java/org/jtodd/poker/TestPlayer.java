package org.jtodd.poker;

import org.jtodd.poker.ranks.Ranking;
import org.jtodd.poker.ranks.StraightFlush;
import org.junit.Assert;
import org.junit.Test;

public class TestPlayer {

    @Test
    public void itGeneratesCorrectWinnerString() {
        Ranking ranking = new StraightFlush(Hand.parseHand("9H TH JH QH KH").get());
        Player player = new Player("White", ranking);
        Assert.assertEquals("White wins. - with Straight Flush", player.toString());
    }
}
