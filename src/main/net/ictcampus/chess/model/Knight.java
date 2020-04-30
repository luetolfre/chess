package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;

import java.util.List;

public class Knight extends Piece {

    private static final String IMG = "knight.png";
    private final String imagePath;
    private List<Position> possibleMoves;


    public Knight(Color color) {
        super(color);
        this.imagePath = (color == Color.BLACK) ? "res/img/b/"+IMG : "res/img/w/" + IMG;
    }

    @Override
    public boolean isMovable(Board board, Position start, Position end) {
        if(end.isSameColor(this.getColor())) return false;
        int col = Math.abs(start.getCol() - end.getCol());
        int row = Math.abs(start.getRow() - end.getRow());
        return row*col == 2;
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }
}
