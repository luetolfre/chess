package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;
import net.ictcampus.chess.model.piece.Piece;

/**
 * <h3> Player Class </h3>
 * represents a chess Move
 *
 * @author luetolfre
 * @version 1.0
 * @since 2020-05-01
 */
public class Position {
    private final int row;
    private final int col;
    private final String notation;
    private Piece piece;

    /**
     * Initializes a Position object
     * @param row where on the Board the Position is
     * @param col where on the Board the Position is
     * @param piece on the Position, if none it is null
     */
    public Position(int row, int col, Piece piece) {
        this.piece = piece;
        this.row = row;
        this.col = col;
        this.notation = notate(row, col);
    }


    /**
     * Checks if there is a Piece in this Position
     * @return bool
     */
    public boolean isPiece(){
        return this.piece != null;
    }

    /**
     * Checks if the Position is Empty
     * @return bool
     */
    public boolean isEmpty(){ return this.piece == null;}

    /**
     * Checks if a Piece in the Position is the color
     * @param color to be checked
     * @return bool, false if it is empty
     */
    private boolean isSameColor(Color color){
        if(this.isEmpty()) return false;
        return this.piece.getColor() == color;
    }

    /**
     * Check if the Piece of another Position is an Enemy, of the other color
     * @param position of the other one, that will be checked
     * @return bool
     */
    public boolean isEnemy(Position position){
        if(this.isPiece()&& position.isPiece()){
            return !this.isSameColor(position.getPiece().getColor());
        }
        return false;
    }

    /**
     * Check if the Piece of another Position of the same color
     * @param position of the other one that will be checked
     * @return bool
     */
    public boolean isOwnColor(Position position){
        if(this.isPiece()&& position.isPiece()){
            return this.isSameColor(position.getPiece().getColor());
        }
        return false;
    }

    /** Notates the Position on the Board
     * @param row which it is in the 2D Board Array
     * @param col which it is in the 2D Board Array
     * @return the correct Notation of the Board
     */
    private String notate(int row, int col){
        char letter = 'A';
        int size = 8;
        return (char) (letter + row) +Integer.toString(size-col);
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
