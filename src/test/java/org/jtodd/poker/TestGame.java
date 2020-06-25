package org.jtodd.poker;

import org.junit.Assert;
import org.junit.Test;

public class TestGame {

    @Test
    public void itGeneratesCorrectResult01() {
        String gameString = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH";
        Game theGame = Game.fromString(gameString);
        Assert.assertEquals("White wins. - with High Card: Ace", theGame.toString());
    }

    @Test
    public void itGeneratesCorrectResult02() {
        String gameString = "Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S";
        Game theGame = Game.fromString(gameString);
        Assert.assertEquals("Black wins. - with Full House: 4 over 2", theGame.toString());
    }

    @Test
    public void itGeneratesCorrectResult03() {
        String gameString = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C KH";
        Game theGame = Game.fromString(gameString);
        Assert.assertEquals("Black wins. - with High Card: 9", theGame.toString());
    }

    @Test
    public void itGeneratesCorrectResult04() {
        String gameString = "Black: 2H 3D 5S 9C KD  White: 2D 3H 5C 9S KH";
        Game theGame = Game.fromString(gameString);
        Assert.assertEquals("Tie.", theGame.toString());
    }
}
