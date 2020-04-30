package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;

import java.util.List;

public class King extends Piece{

    private static final String IMG = "king.png";
    private final String imagePath;
    private boolean hasCastled;
    private boolean hasMoved;
    private List<Position> possibleMoves;


    public King(Color color) {
        super(color);
        this.hasCastled = false;
        this.imagePath = (color == Color.BLACK) ? "res/img/b/"+IMG : "res/img/w/" + IMG;
        this.hasMoved = false;
    }


    @Override
    public boolean isMovable(Board board, Position start, Position end) {
        if (end.isSameColor(this.getColor())) return false;
        if (this.isAttacked(board, end)) return false;
        int col = Math.abs(start.getCol() - end.getCol());
        int row = Math.abs(start.getRow() - end.getRow());
        //if (row+col >2 || row+col<1) return false;
        if (row+col == 1) return true;
        //if (row+col == 2) return true;

        return this.isValidCastling(board, start, end);
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }


    private boolean isAttacked(Board board, Position position) {
        for (Position[] row: board.getTiles()) {
            for(Position  pos: row){
                if(pos.isPiece() && pos.isEnemy(position)){
                    for(Position p: pos.getPiece().getPossibleMoves()){
                        if(position == p){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean isValidCastling(Board board, Position start, Position end){
        // TODO check for valid castling
        return false;
    }

    public boolean isCastlingMove(Board board, Position start, Position end){
        if(this.hasCastled) return false;
        if(this.hasMoved) return false;
        if (!(end.getCol()==2|| end.getCol()==6)) return false;
        if (this.getColor() == Color.WHITE && end.getRow()!=7) return false;
        if (this.getColor()== Color.BLACK && end.getRow()!=0) return false;
        //if (end.getCol()==2 && board.getTile(start.getRow(), 0).)
        return this.isValidCastling(board, start, end);
    }
}
