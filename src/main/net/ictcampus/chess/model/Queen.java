package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;

public class Queen extends Piece {

    private String imagePath;
    public Queen(int row, int col, Color color) {
        super(row, col, color);
        this.imagePath = (color == Color.BLACK) ? "res/img/queen_b.png" : "res/img/queen_w.png";

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
