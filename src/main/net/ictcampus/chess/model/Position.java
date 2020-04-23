package net.ictcampus.chess.model;

public class Position {
    private int row;
    private int col;
    private String notation;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
        this.notation = notate(row, col);
    }

    public void changePositionTo(int row, int col){
        this.row = row;
        this.col = col;
    }

    public String notate(int row, int col){
        char letter = 'A';
        int size = 8;
        return String.valueOf((char)letter+row)+Integer.toString(size-col);
    }

    public boolean isSamePosition(Position pos1, Position pos2){
        // TODO
        return true;
    }
}
