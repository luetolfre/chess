package net.ictcampus.chess.model.piece;

import net.ictcampus.chess.constant.Color;
import net.ictcampus.chess.model.Board;
import net.ictcampus.chess.model.Position;

/**
 * <h3> King Class </h3>
 * represents a king piece
 *
 * @author luetolfre
 * @version 1.0
 * @since 2020-05-01
 */
public class King extends Piece {

    private static final String IMG = "king.png";
    private boolean hasCastled;

    /**
     * Initializes a new King object.
     * @param color BLACK or WHITE
     */
    public King(Color color) {
        super(color);
        this.hasCastled = false;
        setImagePath((color == Color.BLACK) ? "res/img/b/"+IMG : "res/img/w/" + IMG);
    }


    @Override
    public boolean isMovable(Board board, Position start, Position end) {
        if(     start.isOwnColor(end) ||
                this.isAttacked(board, end)) return false;

        int col = Math.abs(start.getCol() - end.getCol());
        int row = Math.abs(start.getRow() - end.getRow());

        if (row+col == 1 || row==1 && col==1) return true;

        return this.isValidCastling(board, start, end);
    }


    /**
     * Checks if the king is being attacked on the position
     * @param board which it is checked on
     * @param position where the king will be moved to
     * @return bool
     */
    private boolean isAttacked(Board board, Position position) {
        for (Position[] row: board.getTiles()) {
            for(Position  pos: row){
                if(pos.isEnemy(position)){
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

    /**
     * Checks if a Move is a Castling Move
     * @param board on which it is checked
     * @param start Position of this Piece
     * @param end Position of this Piece
     * @return bool
     */
    public boolean isCastlingMove(Board board, Position start, Position end){
        if(this.hasCastled) return false;
        if(hasMoved()) return false;
        if (!(end.getCol()==2|| end.getCol()==6)) return false;
        if (this.getColor() == Color.WHITE && end.getRow()!=7) return false;
        if (this.getColor()== Color.BLACK && end.getRow()!=0) return false;
        //if (end.getCol()==2 && board.getTile(start.getRow(), 0).)
        return this.isValidCastling(board, start, end);
    }


    /**
     * Checks the Validity of a Castling Move
     * @param board on which it is checked
     * @param start Position of this Piece
     * @param end Position of this Piece
     * @return bool
     */
    private boolean isValidCastling(Board board, Position start, Position end){
        // TODO check for valid castling
        return false;
    }
}
