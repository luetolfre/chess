package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;
import net.ictcampus.chess.constant.GameStatus;
import net.ictcampus.chess.model.piece.King;
import net.ictcampus.chess.model.piece.Piece;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3> Chess Class </h3>
 * represents a chess game
 *
 * @author luetolfre
 * @version 1.0
 * @since 2020-05-01
 */
public class Chess {
    private Board board;
    private List<Player> players;
    private Player currPlayer;
    private GameStatus status;
    private List<Move> history;


    /**
     * Initializes a new Chess object
     * @param player1 name of player 1
     * @param player2 name of player 2
     */
    public Chess(String player1, String player2) {
        this.board = new Board();
        this.players = createPlayerList(player1, player2);
        this.currPlayer = players.get(0);
        this.status = GameStatus.RUNNING;
        this.history = new ArrayList<>();
    }


    /**
     * Adds player to the list of players in the game
     * @param player1 name of player 1
     * @param player2 name of player 2
     * @return list of players
     */
    private List<Player> createPlayerList(String player1, String player2) {
        List<Player> players = new ArrayList<>();
        players.add(new Player(player1, Color.WHITE));
        players.add(new Player(player2, Color.BLACK));
        return players;
    }

    /**
     * Checks if a Chess Game is already over.
     * @return true if it is over, false if it is still running
     */
    public boolean isOver(){
        return this.status != GameStatus.RUNNING;
    }

    /**
     * Creates a Move from a Player of the start Position to the end Position
     * @param player Player who tries to move
     * @param start initial Position of Piece
     * @param end Position where Piece should move to.
     * @return true if the move is a possible Move
     */
    public boolean move(Player player, Position start, Position end) {
        Position startTile = this.board.getTile(start.getRow(), start.getCol());
        Position endTile = this.board.getTile(end.getRow(), end.getCol());
        Move move = new Move(player, startTile, endTile);
        return this.tryMove(move, player);
    }


    /**
     * Tries to make a move. Moves Piece, kills Piece, adds Piece to history, changes Gamestatus and changes currentPlayer.
     * @param move Move that will be tried.
     * @param player Player that tries that move.
     * @return false if it is not a valid move. true if move was successful
     */
    private boolean tryMove(Move move, Player player) {
        Position start = move.getStart();
        Position end = move.getEnd();
        Piece movingPiece = move.getMovingPiece();
        if (    movingPiece == null ||
                player != currPlayer ||
                movingPiece.getColor() != player.getColor() ||
                !movingPiece.isMovable(board, start, end)) return false;

        Piece killedPiece = end.getPiece();
        if(killedPiece != null){
            killedPiece.setAlive(false);
            move.setKilledPiece(killedPiece);
        }

        if(movingPiece instanceof King && ((King) movingPiece).isCastlingMove(board, start, end)){
            move.setCastling(true);
        }
        history.add(move);
        movingPiece.setMoved(true);
        end.setPiece(movingPiece);
        start.setPiece(null);

        if (killedPiece instanceof King){
            if(player.getColor()==Color.WHITE){
                this.setStatus(GameStatus.WIN_WHITE);
            }else{
                this.setStatus(GameStatus.WIN_BLACK);
            }
        }
        changeCurrentPlayer();
        board.update();

        return true;
    }

    /**
     * Changes the Current Player to the next one
     */
    private void changeCurrentPlayer(){
        if (this.currPlayer == players.get(0)){
            this.currPlayer = players.get(1);
        }else{
            this.currPlayer= players.get(0);
        }
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Player getCurrPlayer() {
        return currPlayer;
    }

}
