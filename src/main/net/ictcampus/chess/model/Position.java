package net.ictcampus.chess.model;

public class Position {
    private int row;
    private int col;
    private String notation;

    public Position(int row, int col, String notation) {
        this.row = row;
        this.col = col;
        this.notation = notation;
    }

    public void changePositionTo(int row, int col){
        this.row = row;
        this.col = col;
    }

    public boolean isSamePosition(Position pos1, Position pos2){
        // TODO
        return true;
    }
}
