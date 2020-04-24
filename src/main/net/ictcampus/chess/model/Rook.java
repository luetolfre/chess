package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;

public class Rook extends Piece {

    private static final String IMG = "rook.png";
    private String imagePath;

    public Rook(Color color) {
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
