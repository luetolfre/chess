package net.ictcampus.chess.model.piece;

import net.ictcampus.chess.constant.Color;
import net.ictcampus.chess.model.Board;
import net.ictcampus.chess.model.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private Color color;
    private String imagePath;
    private List<Position> possibleMoves;
    private boolean alive;

    public Piece(Color color) {
        this.color = color;
        this.possibleMoves = new ArrayList<>();
    }

    /**
     * Checks if this Piece is movable.
     * @param board the board the piece tries to move on
     * @param start the current position of the piece
     * @param end the position it wants to move to
     * @return true if the piece is movable there
     */
    public abstract boolean isMovable(Board board, Position start, Position end);


    public Color getColor() {
        return color;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setPossibleMoves(List<Position> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

    public List<Position> getPossibleMoves() {
        return possibleMoves;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean rookMovement(Board board, Position start, Position end){
        if(start.getCol()==end.getCol()){
            int maxRow = Math.max(start.getRow(), end.getRow());
            int minRow = Math.min(start.getRow(), end.getRow());
            for (int r = minRow+1; r<maxRow; r++) {
                if(board.getTiles()[r][start.getCol()].isPiece()) return false;
            }
            return true;
        }else if(start.getRow()==end.getRow()){
            int maxCol = Math.max(start.getCol(), end.getCol());
            int minCol = Math.min(start.getCol(), end.getCol());
            for (int c = minCol+1; c<maxCol; c++){
                if(board.getTiles()[start.getRow()][c].isPiece()) return false;
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean bishopMovement(Board board, Position start, Position end){
        if(!(Math.abs(start.getRow()-end.getRow())==Math.abs(start.getCol()-end.getCol()))) return false;

        int steps = Math.abs(start.getRow()-end.getRow());
        int startRow = start.getRow();
        int endRow = end.getRow();
        int startCol = start.getCol();
        int endCol = end.getCol();
        Position[][] tiles = board.getTiles();
        if(startRow>endRow && startCol>endCol){             //upLeft
            for (int i=1; i<steps; i++){
                if(tiles[startRow-i][startCol-i].isPiece()) return false;
            }
        }else if(startRow>endRow && startCol<endCol){        //upRight
            for (int i=1; i<steps; i++){
                if(tiles[startRow-i][startCol+i].isPiece()) return false;
            }
        }else if(startRow<endRow && startCol<endCol){       //downRight
            for (int i=1; i<steps; i++){
                if(tiles[startRow+i][startCol+i].isPiece()) return false;
            }
        }else if(startRow<endRow && startCol>endCol){       //downLeft
            for (int i=1; i<steps; i++){
                if(tiles[startRow+i][startCol-i].isPiece()) return false;
            }
        }
        return true;
    }

    public boolean queenMovement(Board board, Position start, Position end){
        return rookMovement(board, start, end) || bishopMovement(board, start, end);
    }


}
