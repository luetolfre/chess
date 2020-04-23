package net.ictcampus.chess;

import javafx.scene.Scene;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import net.ictcampus.chess.gui.ChessPane;
import net.ictcampus.chess.gui.EndPane;
import net.ictcampus.chess.gui.Style;
import net.ictcampus.chess.model.Chess;
import net.ictcampus.chess.model.Piece;

import java.io.FileNotFoundException;
import java.util.List;

public class Controller {
    Chess chess;

    public Controller() {
    }


    public static void play(){

    }

    private void createGame(String player1, String player2){
        this.chess = new Chess(player1, player2);
    }

    public List<Piece> createObservablePieces(){
        // TODO make binding in pieces.
        return this.chess.getPieces();
    }

    public void showGamePane(Stage stage) throws FileNotFoundException {
        showPane(stage, new ChessPane(this, stage, "CHESS"));
        createGame("p1", "p2");
    }

    public void showEndPane(Stage stage){
        showPane(stage, new EndPane(this, stage, "CHESS"));
    }

    private void showPane(Stage stage, Pane pane){
        Scene scene = new Scene(pane, 800, 800);
        Style.setStyleSheet(scene, "/css/main.css");
        stage.setScene(scene);
        //stage.setFullScreen(true);
        stage.show();
    }

}
