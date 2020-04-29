package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;

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
            }else if(Math.abs(start.getRow()-end.getRow())==Math.abs(start.getCol()-end.getCol())) {
                int steps = Math.abs(start.getRow()-end.getRow());
                int startrow = start.getRow();
                int endrow = end.getRow();
                int startcol = start.getCol();
                int endcol = end.getCol();
                Position[][] tiles = board.getTiles();
                if(startrow>endrow && startcol>endcol){             //upleft
                    for (int i=1; i<steps; i++){
                        if(tiles[startrow-i][startcol-i].isPiece()) return false;
                    }
                }else if(startrow>endrow && startcol<endcol){        //upright
                    for (int i=1; i<steps; i++){
                        if(tiles[startrow-i][startcol+i].isPiece()) return false;
                    }
                }else if(startrow<endrow && startcol<endcol){       //downright
                    for (int i=1; i<steps; i++){
                        if(tiles[startrow+i][startcol+i].isPiece()) return false;
                    }
                }else if(startrow<endrow && startcol>endcol){       //downleft
                    for (int i=1; i<steps; i++){
                        if(tiles[startrow+i][startcol-i].isPiece()) return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        }
    }


    @Override
    public String getImagePath() {
        return imagePath;
    }
}
