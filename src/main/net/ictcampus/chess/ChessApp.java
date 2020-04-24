package net.ictcampus.chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import net.ictcampus.chess.gui.StartPane;
import net.ictcampus.chess.gui.Style;
import net.ictcampus.chess.model.Chess;

/**
 * <h1>Chess Application</h1>
 * The ChessApp implements an Application that let's you
 * play a local Chess game.
 *
 * @author luetolfre
 * @version 1.0
 * @since 2020-04-24
 */
public class ChessApp extends Application {
    /**
     * This is the main method which launches the Chess Game
     * @param args unused.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The start method starts a Stage with the StartScene.
     * @param stage window the app runs in.
     */
    @Override
    public void start(Stage stage) {
        Chess game = new Chess("p1", "p2");
        stage.getIcons().add(new Image("/img/b/knight.png"));
        stage.setTitle("CHESS");
        Pane start = new StartPane(game, stage, "chess");
        Scene scene = new Scene(start, 900, 900);
        Style.setStyleSheet(scene, "/css/main.css");
        stage.setScene(scene);
        // primaryStage.setFullScreen(true);
        stage.show();
    }

}
