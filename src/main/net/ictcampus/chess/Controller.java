package net.ictcampus.chess;

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

public class Controller {

    // --------EVENTS----------------
    public static void play(){

    }

    public static void showGamePane(Stage stage){
        showPane(stage, new ChessPane(stage, "CHESS"));
    }

    public static void showEndPane(Stage stage){
        showPane(stage, new EndPane(stage, "CHESS"));
    }

    private static void showPane(Stage stage, Pane pane){
        Scene scene = new Scene(pane, 800, 800);
        Style.setStyleSheet(scene, "/css/main.css");
        stage.setScene(scene);
        //stage.setFullScreen(true);
        stage.show();
    }

}
