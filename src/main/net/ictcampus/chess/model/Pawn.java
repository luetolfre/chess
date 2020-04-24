package net.ictcampus.chess.model;

import com.sun.xml.internal.ws.policy.sourcemodel.PolicySourceModel;

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
        // possibilities: 1vor, 1livor, 1revor
        // TODO add possible moves???
        Position candidate = new Position(this.row+getColor().getDir(), this.col);
        List<Position> positions = new ArrayList<>();


        //TODO
    }

    @Override
    public List<Position> getCandidates() {
        List<Position> candidates = new ArrayList<>();
        if(queen){
            //TODO queenCandidates
        }
        else{
            candidates.add(new Position(this.row+getColor().getDir(), this.col));
            candidates.add(new Position(this.row+getColor().getDir(), this.col+1));
            candidates.add(new Position(this.row+getColor().getDir(), this.col-1));
        }
        return candidates;
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }
}
