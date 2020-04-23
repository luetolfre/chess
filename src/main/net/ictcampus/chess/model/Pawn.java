package net.ictcampus.chess.model;

public class Pawn extends Piece {

    private String imagePath;
    private boolean queen;

    public Pawn(int row, int col, Color color) {
        super(row, col, color);
        this.imagePath = (color == Color.BLACK) ? "res/img/pawn_b.png" : "res/img/pawn_w.png";

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
