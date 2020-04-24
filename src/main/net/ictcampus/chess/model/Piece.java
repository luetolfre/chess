package net.ictcampus.chess.model;

import java.util.List;

public abstract class Piece {
    private int row;
    private int col;
    private Color color;
    private String imagePath;
    private List<Position> possibleMoves;
    private boolean alive;

    public Piece(int col, int row, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public abstract void move();
    public abstract void updatePossibleMoves();
    public abstract List<Position> getCandidates();


    public Color getColor() {
        return color;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
