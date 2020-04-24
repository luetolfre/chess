package net.ictcampus.chess.model;

public class Move {

    private Player player;
    private Position start;
    private Position end;
    private Piece movingPiece;
    private Piece killedPiece;
    private boolean castling = false;

    public Move(Player player, Position start, Position end) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.movingPiece = start.getPiece();
    }

    public Player getPlayer() {
        return player;
    }

    public Position getStart() {
        return start;
    }

    public Position getEnd() {
        return end;
    }

    public Piece getMovingPiece() {
        return movingPiece;
    }

    public Piece getKilledPiece() {
        return killedPiece;
    }
    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }

    public boolean isCastling() {
        return castling;
    }

    public void setCastling(boolean castling) {
        this.castling = castling;
    }
}
