package net.ictcampus.chess.model.piece;

import net.ictcampus.chess.constant.Color;
import net.ictcampus.chess.model.Board;
import net.ictcampus.chess.model.Position;

/**
 * <h3> Knight Class </h3>
 * represents a knight piece
 *
 * @author luetolfre
 * @version 1.0
 * @since 2020-05-01
 */
public class Knight extends Piece {

    private static final String IMG = "knight.png";

    /**
     * Initializes a new Knight object
     * @param color BLACK or WHITE
     */
    public Knight(Color color) {
        super(color);
        setImagePath((color == Color.BLACK) ? "res/img/b/"+IMG : "res/img/w/" + IMG);
    }

    @Override
    public boolean isMovable(Board board, Position start, Position end) {
        if(start.isOwnColor(end)) return false;
        int col = Math.abs(start.getCol() - end.getCol());
        int row = Math.abs(start.getRow() - end.getRow());
        return row*col == 2;
    }
}
