package org.jtodd.poker;

import org.jtodd.poker.ranks.Ranking;

public class Player {

    public final String name;
    public final Ranking ranking;

    public Player(String name, Ranking ranking) {
        this.name = name;
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return String.format("%s wins. - with %s", this.name, this.ranking);
    }
}
