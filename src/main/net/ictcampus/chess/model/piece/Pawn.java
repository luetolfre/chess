package net.ictcampus.chess.model.piece;

import net.ictcampus.chess.constant.Color;
import net.ictcampus.chess.model.Board;
import net.ictcampus.chess.model.Position;

/**
 * <h3> Pawn Class </h3>
 * represents a pawn piece
 *
 * @author luetolfre
 * @version 1.0
 * @since 2020-05-01
 */
public class Pawn extends Piece {

    private static final String IMG = "pawn.png";
    private boolean queen;

    /**
     * Initializes a new Pawn object.
     * @param color BLACK or WHITE
     */
    public Pawn(Color color) {
        super(color);
        setImagePath((color == Color.BLACK) ? "res/img/b/"+IMG : "res/img/w/" + IMG);
        this.queen = false;
    }

    @Override
    public boolean isMovable(Board board, Position start, Position end) {
        if (start.isOwnColor(end)) return false;
        if(!hasMoved()){
            if(     start.getCol()==end.getCol() &&
                    start.getRow()+2*this.getColor().getDir()==end.getRow()){
                return true;
            }
        }
        if(!queen){
            if(!(start.getRow()+this.getColor().getDir()==end.getRow())) return false;
            if  (start.getCol()==end.getCol() ||
                (start.getCol()+1 == end.getCol() && start.isEnemy(end)) ||
                (start.getCol()-1 == end.getCol() && start.isEnemy(end)) ){
                if(     (this.getColor() == Color.BLACK && end.getRow() == 7) ||
                        (this.getColor() == Color.WHITE && end.getRow() == 0) ){
                    this.queen = true;
                }
                return true;
            }
            return false;
        }else{
            return queenMovement(board, start, end);
        }
    }
}
