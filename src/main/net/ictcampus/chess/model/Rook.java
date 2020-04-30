package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;

import java.util.List;

public class Rook extends Piece {

    private static final String IMG = "rook.png";
    private final String imagePath;
    private List<Position> possibleMoves;
    private boolean hasMoved;


    public Rook(Color color) {
        super(color);
        this.imagePath = (color == Color.BLACK) ? "res/img/b/"+IMG : "res/img/w/" + IMG;
        this.hasMoved = false;
    }

    @Override
    public boolean isMovable(Board board, Position start, Position end) {
        if (end.isSameColor(this.getColor())) return false;
        return this.rookMovement(board, start, end);
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }
}
