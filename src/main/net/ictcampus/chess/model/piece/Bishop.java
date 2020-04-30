package net.ictcampus.chess.model.piece;

import net.ictcampus.chess.constant.Color;
import net.ictcampus.chess.model.Board;
import net.ictcampus.chess.model.Position;

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
        return this.bishopMovement(board, start, end);
    }


    @Override
    public String getImagePath() {
        return imagePath;
    }
}
