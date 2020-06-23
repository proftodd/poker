package org.jtodd.poker;

import org.junit.Assert;
import org.junit.Test;

public class TestCard {

    @Test
    public void itComparesNumericValuesCorrectly() {
        Card c1 = new Card('2', 'H');
        Card c2 = new Card('3', 'H');
        Assert.assertTrue(c1.compareTo(c2) < 1);
    }

    @Test
    public void itComparesNumericAndFaceValuesCorrectly() {
        Card c1 = new Card('2', 'H');
        Card c2 = new Card('Q', 'H');
        Assert.assertTrue(c1.compareTo(c2) < 1);
    }

    @Test
    public void itComparesFaceCardsCorrectly() {
        Card c1 = new Card('T', 'H');
        Card c2 = new Card('Q', 'H');
        Assert.assertTrue(c1.compareTo(c2) < 1);
    }

    // TODO: Aces can be high or low!
}
