package net.ictcampus.chess;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.ictcampus.chess.gui.ChessPane;
import net.ictcampus.chess.gui.EndPane;
import net.ictcampus.chess.gui.StartPane;
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

    public List<Piece> createObservablePieces(){
        Chess chess = new Chess("p1", "p2");
        return chess.getPieces();
    }

    public void showGamePane(Stage stage) throws FileNotFoundException {
        showPane(stage, new ChessPane(this, stage, "CHESS"));
        this.chess = new Chess("p1", "p2");
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
