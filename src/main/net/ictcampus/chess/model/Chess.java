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
     * u
     * pdates the whole Chess object
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
     * @return list of players
     */
    private List<Player> createPlayerList(String player1, String player2) {
        List<Player> players = new ArrayList<>();
        players.add(new Player(player1, Color.WHITE));
        players.add(new Player(player2, Color.BLACK));
        return players;
    }

    public boolean isOver(){
        return this.status != GameStatus.RUNNING;
    }
    public boolean move(Player player, Position start, Position end) throws Exception {
        Position startTile = this.board.getTile(start.getRow(), start.getCol());
        Position endTile = this.board.getTile(end.getRow(), end.getCol());
        Move move = new Move(player, startTile, endTile);
        return this.tryMove(move, player);
    }

    private boolean tryMove(Move move, Player player){
        Position start = move.getStart();
        Position end = move.getEnd();
        Piece movingPiece = move.getMovingPiece();
        if(movingPiece == null) return false;
        if(player != currPlayer) return false;
        if(movingPiece.getColor() != player.getColor()) return false;
        if(!movingPiece.isMovable(board, start, end)) return false;

        Piece killedPiece = end.getPiece();
        if(killedPiece != null){
            killedPiece.setAlive(false);
            move.setKilledPiece(killedPiece);
        }

        if(movingPiece instanceof King && ((King) movingPiece).isCastlingMove(start, end)){
            move.setCastling(true);
        }
        history.add(move);

        end.setPiece(movingPiece);
        start.setPiece(null);

        if (killedPiece != null && killedPiece instanceof King){
            if(player.getColor()==Color.WHITE){
                this.setStatus(GameStatus.WIN_WHITE);
            }else{
                this.setStatus(GameStatus.WIN_BLACK);
            }
        }
        changeCurrentPlayer();

        return true;
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }



    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    private void changeCurrentPlayer(){
        if (this.currPlayer == players.get(0)){
            this.currPlayer = players.get(1);
        }else{
            this.currPlayer= players.get(0);
        }
    }

}
