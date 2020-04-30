package net.ictcampus.chess.model.piece;

import net.ictcampus.chess.constant.Color;
import net.ictcampus.chess.model.Board;
import net.ictcampus.chess.model.Position;

import java.util.List;

public class Queen extends Piece {

    private static final String IMG = "queen.png";
    private String imagePath;
    private List<Position> possibleMoves;

    public Queen(Color color) {
        super(color);
        this.imagePath = (color == Color.BLACK) ? "res/img/b/"+IMG : "res/img/w/" + IMG;

    }

    @Override
    public boolean isMovable(Board board, Position start, Position end) {
        if (end.isSameColor(this.getColor())) return false;
        return queenMovement(board, start, end);
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }
}
