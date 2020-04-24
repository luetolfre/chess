package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    private String imagePath;
    private int row;
    private int col;
    private boolean queen;
    private List<Position> possibleMoves;

    public Pawn(int row, int col, Color color) {
        super(row, col, color);
        this.imagePath = (color == Color.BLACK) ? "res/img/pawn_b.png" : "res/img/pawn_w.png";
        this.updatePossibleMoves();

    }


    @Override
    public void move() {
        //TODO
    }

    @Override
    public void updatePossibleMoves() {
        // possibilities: 1U, 1UL, 1UR
        // TODO add possible moves???
        Position candidate = new Position(this.row+getColor().getDir(), this.col);
        //new Position(this.row+getColor().getDir(), this.col);
        //.add(new Position(this.row+getColor().getDir(), this.col+1));
        //.add(new Position(this.row+getColor().getDir(), this.col-1));
        List<Position> positions = new ArrayList<>();


        //TODO
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }
}
