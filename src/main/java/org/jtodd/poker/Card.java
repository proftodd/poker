package org.jtodd.poker;

import java.util.Map;

public class Card {
    private static final Map<Character, String> charToString = Map.of(
        'C', "Clubs",
        'D', "Diamonds",
        'H', "Hearts",
        'S', "Spades"
    );

    public final char suit;
    public final char value;
    public final int numericValue;

    public Card(char value, char suit) {
        this.suit = suit;
        this.value = value;
        if (value == 'T') {
            numericValue = 10;
        } else if (value == 'J') {
            numericValue = 11;
        } else if (value == 'Q') {
            numericValue = 12;
        } else if (value == 'K') {
            numericValue = 13;
        } else if (value == 'A') {
            numericValue = 14;
        } else {
            numericValue = value - '0';
        }
    }

    public String suitString() {
        return charToString.get(this.suit);
    }

    @Override
    public String toString() {
        if (numericValue == 11) {
            return "Jack";
        } else if (numericValue == 12) {
            return "Queen";
        } else if (numericValue == 13) {
            return "King";
        } else if (numericValue == 14) {
            return "Ace";
        } else {
            return Integer.toString(numericValue);
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Card)) {
            return false;
        }
        Card theOther = (Card) other;
        return theOther.suit == this.suit && theOther.value == this.value;
    }

    @Override
    public int hashCode() {
        return suit * value;
    }
}
