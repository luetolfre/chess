package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;

import java.util.List;

public class Pawn extends Piece {

    private static final String IMG = "pawn.png";
    private String imagePath;
    private int row;
    private int col;
    private boolean queen;
    private List<Position> possibleMoves;

    public Pawn(Color color) {
        super(color);
        this.imagePath = (color == Color.BLACK) ? "res/img/b/"+IMG : "res/img/w/" + IMG;

    }

    @Override
    public boolean isMovable(Board board, Position start, Position end) {
        return false;
    }


    @Override
    public String getImagePath() {
        return imagePath;
    }
}
