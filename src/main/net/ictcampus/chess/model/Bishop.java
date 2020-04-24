package net.ictcampus.chess.model;

import javafx.geometry.Pos;
import net.ictcampus.chess.constant.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3> Bishop Class </h3>
 * represents a Bishop Piece in a chess game
 *
 * @author luetolfre
 * @version 1.0
 * @since 2020-04-24
 */
public class Bishop extends Piece {

    private static final String IMG = "bishop.png";
    private final String imagePath;
    private List<Position> possibleMoves;

    /**
     * Initializes a new Bishop object.
     * @param color which color it has
     */
    public Bishop(Color color) {
        super( color);
        this.imagePath = (color == Color.BLACK) ? "res/img/b/"+IMG : "res/img/w/" + IMG;
    }

    @Override
    public boolean isMovable(Board board, Position start, Position end) {
        if (end.isSameColor(this.getColor())) return false;
        if(!(Math.abs(start.getRow()-end.getRow())==Math.abs(start.getCol()-end.getCol()))) return false;

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
    }


    @Override
    public String getImagePath() {
        return imagePath;
    }
}
