package net.ictcampus.chess.model.piece;

import net.ictcampus.chess.constant.Color;
import net.ictcampus.chess.model.Board;
import net.ictcampus.chess.model.Position;

/**
 * <h3> Rook Class </h3>
 * represents a rook piece
 *
 * @author luetolfre
 * @version 1.0
 * @since 2020-05-01
 */
public class Rook extends Piece {

    private static final String IMG = "rook.png";

    /**
     * Initializes a new Rook object
     * @param color BLACK or WHITE
     */
    public Rook(Color color) {
        super(color);
        setImagePath((color == Color.BLACK) ? "res/img/b/"+IMG : "res/img/w/" + IMG);
    }

    @Override
    public boolean isMovable(Board board, Position start, Position end) {
        if(start.isOwnColor(end)) return false;
        return this.rookMovement(board, start, end);
    }
}
