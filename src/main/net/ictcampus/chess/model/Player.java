package net.ictcampus.chess.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String username;
    private Color color;
    private List<Piece> pieces;

    public Player(String username, Color color, List<Piece> piecesList) {
        this.username = username;
        this.color = color;
        this.pieces = createPieces(piecesList);
    }

    private List<Piece> createPieces(List<Piece> pieceList){
        List<Piece> myPieces = new ArrayList<>();
        for (Piece piece:pieceList){
            if (piece.getColor() == this.color){
                myPieces.add(piece);
            }
        }
        return myPieces;
    }

    public void addPiece(){
        //TODO
    }

    public void removePiece(){
        //TODO
    }
}
