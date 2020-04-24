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

    public static void play(){

    }

    private static Chess createGame(String player1, String player2){
        return new Chess(player1, player2);
    }

    public static List<Piece> createObservablePieces(List<Piece> pieces){
        // TODO make binding in pieces.
        return pieces;
    }

    public static void showGamePane(Chess game, Stage stage) throws FileNotFoundException {
        // createGame("p2", "p1");
        showPane(stage, new ChessPane(game, stage, "CHESS"));
    }

    public static void showEndPane(Chess game, Stage stage){
        showPane(stage, new EndPane(game, stage, "CHESS"));
    }

    private static void showPane(Stage stage, Pane pane){
        Scene scene = new Scene(pane, 800, 800);
        Style.setStyleSheet(scene, "/css/main.css");
        stage.setScene(scene);
        //stage.setFullScreen(true);
        stage.show();
    }

}
