package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;

import java.util.List;

public class Player {
    private String username;
    private Color color;

    public Player(String username, Color color) {
        this.username = username;
        this.color = color;
    }

    public boolean isWhite(){
        return this.color == Color.WHITE;
    }

    public String getUsername() {
        return username;
    }

    public Color getColor() {
        return color;
    }
}
