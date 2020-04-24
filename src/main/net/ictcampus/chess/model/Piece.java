package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;

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

    /**
     * moves the piece to a new position and updates the Gamestatus
     */
    public abstract void move();

    /**
     * Calculates the possible Moves from this Piece.
     * @return List of possible Moves
     */
    public abstract List<Position> updatePossibleMoves();


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
