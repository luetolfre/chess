package net.ictcampus.chess.model;

public class Bishop extends Piece {
    private String imagePath;

    public Bishop(int row, int col, Color color) {
        super(row, col, color);
        this.imagePath = (color == Color.BLACK) ? "res/img/bishop_b.png" : "res/img/bishop_w.png";
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
