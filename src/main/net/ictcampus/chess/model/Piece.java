package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;

import java.util.List;

public abstract class Piece {
    private Color color;
    private String imagePath;
    private List<Position> possibleMoves;
    private boolean alive;

    public Piece(Color color) {
        this.color = color;
    }

    /**
     * Checks if this Piece is movable.
     * @param board the board the piece tries to move on
     * @param start the current position of the piece
     * @param end the position it wants to move to
     * @return true if the piece is movable there
     */
    public abstract boolean isMovable(Board board, Position start, Position end);


    public Color getColor() {
        return color;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setPossibleMoves(List<Position> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

    public List<Position> getPossibleMoves() {
        return possibleMoves;
    }

    public boolean isAlive() {
        return alive;
    }


}
