package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;
import net.ictcampus.chess.model.piece.Piece;

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
        String notation = String.valueOf((char)letter+row)+Integer.toString(size-col);
        return notation;
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
    public boolean isEmpty(){ return this.piece == null;}
    public boolean isSameColor(Color color){
        if(this.isEmpty()) return false;
        return this.piece.getColor() == color;
    }
    public boolean isEnemy(Position position){
        if(this.isPiece()&& position.isPiece()){
            return !this.isSameColor(position.getPiece().getColor());
        }
        return false;
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
