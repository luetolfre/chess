package net.ictcampus.chess.model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Chess {
    private List<Position> board;
    private List<Player> players;
    private List<Pair<Position, Position>> history;
    private boolean turnOfP1;

    public Chess(String Player1, String Player2) {
        createBoard();
        createPlayerList(Player1, Player2);
        this.history = new ArrayList<>();
        this.turnOfP1 = true;
    }

    public void update(){
        //TODO
    }

    public void play(){
        //TODO
    }

    private void createPlayerList(String player1, String player2) {
        //TODO
    }

    private void createBoard() {
        char letter = 'A';
        int size = 8;
        for (int y=0; y<size; y++){
            for (int x=0; x<size; x++){
                int number = (size-x);
                board.add(new Position(x,y, String.valueOf(letter)+Integer.toString(number)));
            }
            letter++;
        }
    }

    public boolean isEmpty(Position pos){
        // TODO
        return false;
    }



}
