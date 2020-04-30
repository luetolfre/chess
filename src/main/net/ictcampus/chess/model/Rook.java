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

        if(start.getCol()==end.getCol()){
            int maxRow = Math.max(start.getRow(), end.getRow());
            int minRow = Math.min(start.getRow(), end.getRow());
            for (int r = minRow+1; r<maxRow; r++) {
                if(board.getTiles()[r][start.getCol()].isPiece()) return false;
            }
            return true;
        }else if(start.getRow()==end.getRow()){
            int maxCol = Math.max(start.getCol(), end.getCol());
            int minCol = Math.min(start.getCol(), end.getCol());
            for (int c = minCol+1; c<maxCol; c++){
                if(board.getTiles()[start.getRow()][c].isPiece()) return false;
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }
}
