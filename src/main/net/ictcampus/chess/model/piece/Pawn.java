package net.ictcampus.chess.model.piece;

import net.ictcampus.chess.constant.Color;
import net.ictcampus.chess.model.Board;
import net.ictcampus.chess.model.Position;

import java.util.List;

public class Pawn extends Piece {

    private static final String IMG = "pawn.png";
    private String imagePath;
    private int row;
    private int col;
    private boolean queen;
    private List<Position> possibleMoves;
    private boolean notMoved;

    public Pawn(Color color) {
        super(color);
        this.imagePath = (color == Color.BLACK) ? "res/img/b/"+IMG : "res/img/w/" + IMG;
        this.queen = false;
        this.notMoved = true;
    }

    @Override
    public boolean isMovable(Board board, Position start, Position end) {
        if (end.isSameColor(this.getColor())) return false;
        if(notMoved){
            if(start.getCol()==end.getCol() && start.getRow()+2*this.getColor().getDir()==end.getRow()) return true;
        }
        if(!queen){
            if(!(start.getRow()+this.getColor().getDir()==end.getRow())) return false;
            if(start.getCol()==end.getCol()) return true;
            if(start.getCol()+1 == end.getCol() && start.isEnemy(end)) return true;
            if(start.getCol()-1 == end.getCol() && start.isEnemy(end)) return true;
            return false;
        }else{
            return queenMovement(board, start, end);
        }
    }


    @Override
    public String getImagePath() {
        return imagePath;
    }
}
