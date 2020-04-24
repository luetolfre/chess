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

    private final String imagePath;
    private List<Position> possibleMoves;

    /**
     * Initializes a new Bishop object.
     * @param row which row it is on the Board
     * @param col which column it is on the Board
     * @param color which color it has
     */
    public Bishop(int row, int col, Color color) {
        super(row, col, color);
        this.imagePath = (color == Color.BLACK) ? "res/img/bishop_b.png" : "res/img/bishop_w.png";
        this.possibleMoves = updatePossibleMoves();
    }

    @Override
    public void move() {
        //TODO
    }

    @Override
    public List<Position> updatePossibleMoves() {
        List<Position> possibleMoves = new ArrayList<>();
        //TODO
        return possibleMoves;
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }
}
