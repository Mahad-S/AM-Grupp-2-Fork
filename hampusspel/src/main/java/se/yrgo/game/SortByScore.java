package se.yrgo.game;

import java.util.Comparator;

public class SortByScore implements Comparator {
    public int compare(Object obj1, Object obj2) {
        Player a = (Player) obj1;
        Player b = (Player) obj2;
        if (a.score > b.score){
            return -1;
        }
        else if (a.score < b.score){
            return 1;
        }
        else {
            return 0;
        }
    }
}
