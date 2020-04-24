package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;

public class Queen extends Piece {

    private static final String IMG = "queen.png";
    private String imagePath;
    public Queen(Color color) {
        super(color);
        this.imagePath = (color == Color.BLACK) ? "res/img/b/"+IMG : "res/img/w/" + IMG;

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

    @Override
    public String getImagePath() {
        return imagePath;
    }
}
