package org.jtodd.poker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class App {

    public static void main(String[] args) {
        try (
            FileReader fr = new FileReader(new File(args[0]));
            BufferedReader br = new BufferedReader(fr)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                Game game = Game.fromString(line);
                System.out.println(game);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
