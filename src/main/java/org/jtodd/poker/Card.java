package org.jtodd.poker;

public class Card {
    final char suit;
    final char value;

    public Card(char value, char suit) {
        this.suit = suit;
        this.value = value;
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
}
