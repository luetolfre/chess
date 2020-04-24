package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;

public class Position {
    private int row;
    private int col;
    private String notation;
    private Piece piece;

    public Position(int row, int col, Piece piece) {
        this.piece = piece;
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

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isPiece(){
        return this.piece != null;
    }
    public boolean isSameColor(Color color){
        return this.piece.getColor() == color;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getNotation() {
        return notation;
    }

    public void setNotation(String notation) {
        this.notation = notation;
    }

    public Piece getPiece() {
        return piece;
    }
}
