package org.jtodd.poker;

import org.jtodd.poker.ranks.Ranking;

import java.util.*;
import java.util.stream.Collectors;

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
        return new Game(players);
    }

    @Override
    public String toString() {
        Optional<Player> winner = getWinner();
        if (winner.isPresent()) {
            return winner.get().toString();
        } else {
            return "Tie.";
        }
    }

    private Optional<Player> getWinner() {
        List<Player> firstPlace = players
                .stream()
                .collect(Collectors.groupingBy(p -> p.ranking.getValue()))
                .entrySet().stream()
                .min(Map.Entry.comparingByKey())
                .get()
                .getValue();
        if (firstPlace.size() == 1) {
            return Optional.of(firstPlace.get(0));
        } else {
            firstPlace.sort((f1, f2) -> f1.ranking.tieBreaker(f2.ranking));
            if (firstPlace.get(0).ranking.tieBreaker(firstPlace.get(1).ranking) == 0) {
                return Optional.empty();
            } else {
                firstPlace.get(0).ranking.setTiebreaker(firstPlace.get(1).ranking);
                return Optional.of(firstPlace.get(0));
            }
        }
    }
}
