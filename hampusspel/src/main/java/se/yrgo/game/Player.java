package se.yrgo.game;

public class Player {
    public String name;
    public int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}