package net.ictcampus.chess.model;

import java.util.List;

public abstract class Piece {
    private int row;
    private int col;
    private Color color;
    private List<Position> possibleMoves;
    private boolean alive;

    public Piece(int row, int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public abstract void move();
    public abstract void updatePossibleMoves();


    public Color getColor() {
        return color;
    }
}
