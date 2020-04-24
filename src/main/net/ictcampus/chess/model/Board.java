package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int SIZE = 8;
    private Position[][] tiles;

    public Board() {
        this.tiles = initBoard();
    }

    public Position[][] initBoard(){
        Position[][] tiles = new Position[SIZE][SIZE];
        for (int i = 0; i<SIZE; i++){
            tiles[1][i]= new Position(1,i,new Pawn( Color.BLACK));
            tiles[6][i]= new Position(6,i,new Pawn( Color.WHITE));
        }
        tiles[7][0] = new Position(7,0, new Rook(Color.WHITE));
        tiles[7][1] = new Position(7,1, new Knight(Color.WHITE));
        tiles[7][2] = new Position(7,2, new Bishop(Color.WHITE));
        tiles[7][3] = new Position(7,3, new Queen(Color.WHITE));
        tiles[7][4] = new Position(7,4, new King(Color.WHITE));
        tiles[7][5] = new Position(7,5, new Bishop(Color.WHITE));
        tiles[7][6] = new Position(7,6, new Knight(Color.WHITE));
        tiles[7][7] = new Position(7,7, new Rook(Color.WHITE));

        tiles[0][0] = new Position(0,0, new Rook(Color.BLACK));
        tiles[0][1] = new Position(0,1, new Knight(Color.BLACK));
        tiles[0][2] = new Position(0,2, new Bishop(Color.BLACK));
        tiles[0][3] = new Position(0,3, new Queen(Color.BLACK));
        tiles[0][4] = new Position(0,4, new King(Color.BLACK));
        tiles[0][5] = new Position(0,5, new Bishop(Color.BLACK));
        tiles[0][6] = new Position(0,6, new Knight(Color.BLACK));
        tiles[0][7] = new Position(0,7, new Rook(Color.BLACK));

        for (int row = 2; row < 6; row++) {
            for (int col = 0; col < 8; col++) {
                tiles[row][col] = new Position(row, col, null);
            }
        }
        return tiles;
    }

    public Position getTile(int row, int col) throws Exception {
        if (row<0 || row>=SIZE || col<0 || col>=SIZE){
            throw new Exception("Index out of Bound");
        }
        return tiles[row][col];
    }

    public Position[][] getTiles() {
        return tiles;
    }

    public boolean isEmpty(int row, int col){
        return tiles[row][col].getPiece() == null;
    }
    public boolean isPiece(int row, int col){
        return tiles[row][col].getPiece() != null;
    }

    public Piece getPiece(int row, int col) throws Exception {
        if (row<0 || row>=SIZE || col<0 || col>=SIZE){
            throw new Exception("Index out of Bound");
        }
        return tiles[row][col].getPiece();
    }

    public boolean isWhitePiece(int row, int col){
        return tiles[row][col].getPiece().getColor() == Color.WHITE;
    }

    public boolean isOnBoard(int row, int col){
        return 0<=row && row <8 && 0<=col && col<8;
    }

    public void updatePossibleMoves(Position pos){
        List<Position> possibleMoves = new ArrayList<>();
        for (int row=0; row<SIZE; row++){
            for(int col=0; col<SIZE; col++){
                if(pos.getPiece().isMovable(this, pos, this.tiles[row][col])){
                    possibleMoves.add(this.tiles[row][col]);
                }
            }
        }
        pos.getPiece().setPossibleMoves(possibleMoves);
    }
}
