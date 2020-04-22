package net.ictcampus.chess.model;

import java.util.List;

public abstract class Piece {
    private Position position;
    private Color color;
    private List<Position> possibleMoves;
    private boolean alive;

    public abstract void move();
    public abstract void updatePossibleMoves();
}
