package org.jtodd.poker;

import org.jtodd.poker.ranks.Ranking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Game {

    private final List<Player> players;

    private Game(List<Player> players) {
        this.players = players;
    }

    public static Game fromString(String gameString) {
        List<Player> players = new ArrayList<>();
        String [] playerStrings = gameString.split("  ");
        for (String playerString : playerStrings) {
            String [] comps = playerString.split(": ");
            Hand hand = Hand.parseHand(comps[1]).get();
            Ranking ranking = Ranking.rank(hand);
            Player player = new Player(comps[0], ranking);
            players.add(player);
        }
        Collections.sort(players, Comparator.comparing(p -> p.ranking));
        return new Game(players);
    }

    @Override
    public String toString() {
        return players.get(0).toString();
    }
}
