package net.ictcampus.chess.model;

import net.ictcampus.chess.model.piece.Piece;

/**
 * <h3> Move Class </h3>
 * represents a chess Move
 *
 * @author luetolfre
 * @version 1.0
 * @since 2020-05-01
 */
public class Move {

    private Player player;
    private Position start;
    private Position end;
    private Piece movingPiece;
    private Piece killedPiece;
    private boolean castling = false;

    /**
     * Initializes a new Move object
     * @param player that makes the move
     * @param start Position of the Piece
     * @param end Position of the Movement
     */
    public Move(Player player, Position start, Position end) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.movingPiece = start.getPiece();
    }

    public Position getStart() {
        return this.start;
    }

    public Position getEnd() {
        return this.end;
    }

    public Piece getMovingPiece() {
        return this.movingPiece;
    }

    public Piece getKilledPiece() {
        return this.killedPiece;
    }

    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    public boolean isCastling() {
        return this.castling;
    }

    public void setCastling(boolean castling) {
        this.castling = castling;
    }
}
