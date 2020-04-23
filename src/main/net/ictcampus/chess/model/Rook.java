package net.ictcampus.chess.model;

public class Rook extends Piece {

    private String imagePath;
    public Rook(int row, int col, Color color) {
        super(row, col, color);
        this.imagePath = (color == Color.BLACK) ? "res/img/rook_b.png" : "res/img/rook_w.png";

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
