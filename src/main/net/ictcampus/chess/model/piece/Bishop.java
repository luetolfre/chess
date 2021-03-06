package net.ictcampus.chess.model.piece;

import net.ictcampus.chess.constant.Color;
import net.ictcampus.chess.model.Board;
import net.ictcampus.chess.model.Position;

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

    /**
     * Initializes a new Bishop object.
     * @param color BLACK or WHITE
     */
    public Bishop(Color color) {
        super( color);
        setImagePath((color == Color.BLACK) ? "res/img/b/"+IMG : "res/img/w/" + IMG);
    }

    @Override
    public boolean isMovable(Board board, Position start, Position end) {
        if(start.isOwnColor(end)) return false;
        return this.bishopMovement(board, start, end);
    }
}
