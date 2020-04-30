package net.ictcampus.chess.model;

import javafx.geometry.Pos;
import net.ictcampus.chess.constant.Color;
import net.ictcampus.chess.model.piece.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3> Board Class </h3>
 * represents a chess board
 *
 * @author luetolfre
 * @version 1.0
 * @since 2020-04-30
 */
public class Board {
    private static final int SIZE = 8;
    private Position[][] tiles;


    /**
     * Initializes a new Board Object
     */
    public Board() {
        this.tiles = initBoard();
    }

    /**
     * Creates the Board with the Positions and the Pieces on them .
     * @return 2D List of Positions on Board
     */
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

    /**
     * updates the board, kills Pieces and updates possible Moves for them.
     */
    public void update(){
        for (Position[] row: tiles) {
            for(Position position: row){
                if(position.isPiece()) updatePossibleMoves(position);
            }
        }
    }

    /**
     * Get a Position of a Tile
     * @param row which row it is on the board
     * @param col which column it is on the board
     * @return Position of the Board
     */
    public Position getTile(int row, int col) {
        if (!isOnBoard(row, col)){
            return null;
        }
        return tiles[row][col];
    }

    /**
     * Checks if the coordinates is even on the Board.
     * @param row of the Board
     * @param col of the Board
     * @return true if it is on the Board, false if it is not
     */
    private boolean isOnBoard(int row, int col){
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    /**
     * Checks if there is a Piece on a specific Position
     * @param row of the Board
     * @param col of the Board
     * @return true if there is a Piece, false if there is none
     */
    public boolean isPiece(int row, int col) {
        return getPiece(row,col) != null;
    }

    /**
     * Returns a Piece in the specified Position.
     * @param row of the Board
     * @param col of the Board
     * @return Piece if there is a Piece, otherwise null
     */
    public Piece getPiece(int row, int col) {
        return getTile(row, col).getPiece();
    }

    /**
     * Checks if a Piece has the specified color
     * @param row of the Board
     * @param col of the Board
     * @param color to compare
     * @return true if it has that color, otherwise false
     */
    public boolean isColoredPiece(int row, int col, Color color){
        if(isPiece(row, col)) return getPiece(row, col).getColor() == color;
        else return false;
    }

    /**
     * Updates the possible Moves for the Piece if there is a Piece
     * @param position where the Piece is on
     */
    private void updatePossibleMoves(Position position){
        if (!isPiece(position.getRow(), position.getCol())) return;
        List<Position> possibleMoves = new ArrayList<>();
        for (int row=0; row<SIZE; row++){
            for(int col=0; col<SIZE; col++){
                if(position.getPiece().isMovable(this, position, this.tiles[row][col])){
                    possibleMoves.add(this.tiles[row][col]);
                }
            }
        }
        position.getPiece().setPossibleMoves(possibleMoves);
    }

    // TODO: REMOVE DEBUG METHOD
    public void printBoard() {
        for (Position[] row : tiles) {
            for (Position p : row) {
                if (p.getPiece() != null) System.out.print(p.getPiece().getImagePath()+ ", ");
                else System.out.print(p.getPiece() + ", ");

            }
            System.out.println();
        }
    }

    public Position[][] getTiles() {
        return this.tiles;
    }
}
