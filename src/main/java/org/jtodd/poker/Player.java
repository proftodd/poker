package org.jtodd.poker;

import org.jtodd.poker.ranks.Ranking;

public class Player {

    private final String name;
    private final Ranking ranking;

    public Player(String name, Ranking ranking) {
        this.name = name;
        this.ranking = ranking;
    }

    public Ranking getRanking() {
        return ranking;
    }

    @Override
    public String toString() {
        return String.format("%s wins. - with %s", this.name, this.ranking);
    }
}
