package net.ictcampus.chess.model;

import javafx.util.Pair;
import net.ictcampus.chess.constant.Color;
import net.ictcampus.chess.constant.GameStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3> Chess Class </h3>
 * represents a chess game
 *
 * @author luetolfre
 * @version 1.0
 * @since 2020-04-24
 */
public class Chess {
    private final int SIZE = 8;
    private List<Position> board;
    private List<Player> players;
    private List<Piece> pieces;
    private List<Pair<Position, Position>> history;
    private GameStatus status;
    private boolean turnOfP1;

    /**
     * Initializes a new Chess object
     * @param player1 name of player 1
     * @param player2 name of player 2
     */
    public Chess(String player1, String player2) {
        this.board = createBoard();
        this.pieces = createPieces();
        this.players = createPlayerList(player1, player2, this.pieces);
        this.history = new ArrayList<>();
        this.turnOfP1 = true;
        this.status = GameStatus.RUNNING;
    }

    /**
     * updates the whole Chess object
     */
    public void update(){
        //TODO
    }

    /**
     * Starts the Game
     */
    public void play(){
        //TODO
    }

    /**
     * Adds player to the list of players in the game
     * @param player1 name of player 1
     * @param player2 name of player 2
     * @param pieceList list of all pieces of the game
     * @return list of players
     */
    private List<Player> createPlayerList(String player1, String player2, List<Piece> pieceList) {
        List<Player> players = new ArrayList<>();
        players.add(new Player(player1, Color.WHITE, pieceList));
        players.add(new Player(player2, Color.BLACK, pieceList));
        return players;
    }


    private List<Position> createBoard() {
        List<Position> board = new ArrayList<>();
        for (int y=0; y<SIZE; y++){
            for (int x=0; x<SIZE; x++){
                board.add(new Position(x,y));
            }
        }
        return board;
    }

    private List<Piece> createPieces(){
        List<Piece> pieces = new ArrayList<>();
        for (int i = 0; i<SIZE; i++){
            pieces.add(new Pawn(1,i, Color.BLACK));
            pieces.add(new Pawn(6,i, Color.WHITE));
        }
        pieces.add(new Rook(0,0, Color.BLACK));
        pieces.add(new Rook(0,7, Color.BLACK));
        pieces.add(new Rook(7,0, Color.WHITE));
        pieces.add(new Rook(7,7, Color.WHITE));

        pieces.add(new Knight(0,1, Color.BLACK));
        pieces.add(new Knight(0,6, Color.BLACK));
        pieces.add(new Knight(7,1, Color.WHITE));
        pieces.add(new Knight(7,6, Color.WHITE));

        pieces.add(new Bishop(0,2, Color.BLACK));
        pieces.add(new Bishop(0,5, Color.BLACK));
        pieces.add(new Bishop(7,2, Color.WHITE));
        pieces.add(new Bishop(7,5, Color.WHITE));

        pieces.add(new Queen(0,3, Color.BLACK));
        pieces.add(new Queen(7,3, Color.WHITE));

        pieces.add(new King(0,4, Color.BLACK));
        pieces.add(new King(7,4, Color.WHITE));

        return pieces;
    }


    public List<Piece> getPieces() {
        return pieces;
    }

    public boolean isEmpty(int row, int col){
        return getPiece(row,col) == null;
    }
    public boolean isPiece(int row, int col){
        return getPiece(row, col) != null;
    }

    public Piece getPiece(int row, int col){
        for( Piece p: this.getPieces()){
            if(p.getRow()==row && p.getCol()==col) return p;
        }
        return null;
    }

    public boolean isYourPiece(int row, int col, Color color){
        if(isPiece(row, col)){
            return getPiece(row,col).getColor() == color;
        }
        return false;
    }

    public boolean isOtherPiece(int row, int col, Color color){
        if(isPiece(row, col)){
            return getPiece(row,col).getColor() != color;
        }
        return false;
    }

    public boolean isOnBoard(int row, int col){
        return 0<=row && row <8 && 0<=col && col<8;
    }
}
