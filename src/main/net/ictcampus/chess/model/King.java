package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;

public class King extends Piece{

    private String imagePath;

    public King(int row, int col, Color color) {
        super(row, col, color);
        this.imagePath = (color == Color.BLACK) ? "res/img/king_b.png" : "res/img/king_w.png";

    }

    @Override
    public void move() {
        //TODO
    }

    @Override
    public void updatePossibleMoves() {
        //TODO
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }
}
