package org.jtodd.poker;

public class Card implements Comparable<Card> {
    final char suit;
    final char value;
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

    @Override
    public String toString() {
        return String.format("%c%c", value, suit);
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

    @Override
    public int compareTo(Card o) {
        if (this.suit == o.suit) {
            return Integer.compare(this.numericValue, o.numericValue);
        } else {
            return Character.compare(this.suit, o.suit);
        }
    }
}
