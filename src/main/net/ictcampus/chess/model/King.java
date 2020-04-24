package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;

public class King extends Piece{

    private static final String IMG = "king.png";
    private String imagePath;
    private boolean hasCastled;

    public King(Color color) {
        super(color);
        this.hasCastled = false;
        this.imagePath = (color == Color.BLACK) ? "res/img/b/"+IMG : "res/img/w/" + IMG;
    }


    @Override
    public boolean isMovable(Board board, Position start, Position end) {
        if (end.isSameColor(this.getColor())) return false;
        int col = Math.abs(start.getCol() - end.getCol());
        int row = Math.abs(start.getRow() - end.getRow());
        if (row+col == 1 && !this.isAttacked(end)) return true;
        return this.isValidCastling(board, start, end);
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }

    private boolean isAttacked(Position position) {
        // TODO check if king is attacked in position
        return false;
    }

    private boolean isValidCastling(Board board, Position start, Position end){
        if(this.hasCastled) return false;
        // TODO check for valid castling
        return true;
    }

    public boolean isCastlingMove(Position start, Position end){
        // TODO check correct castling move
        return false;
    }
}
