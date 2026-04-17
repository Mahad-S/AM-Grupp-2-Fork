package se.yrgo.game;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Highscore {

    public ArrayList<Player> loadScore(String fileName){
        ArrayList<Player> scores = new ArrayList<Player>();
        Path path = Path.of("src\\main\\resources\\" + fileName);
        try(BufferedReader br = Files.newBufferedReader(path)){
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("///");
                String name = data[0];
                int score = Integer.parseInt(data[1]);
                Player player = new Player(name, score);
                scores.add(player);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Kan inte hitta fil!");
        }
        catch(IOException e){
            System.out.println("Kan inte hitta fil!");
        }

        Comparator myComparator = new SortByScore();
        Collections.sort(scores, myComparator);
        return scores;

    }
    public void saveScore(ArrayList<Player> scores, String fileName){
        Path path = Path.of("src\\main\\resources\\" + fileName);
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            for(Player player : scores){
                writer.write(player.name + "///" + player.score);
                writer.newLine();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Kan inte hitta fil!");
        }
        catch(IOException e){
            System.out.println("Kan inte hitta fil!");
        }
    }
}
