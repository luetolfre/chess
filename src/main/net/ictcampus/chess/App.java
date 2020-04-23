package net.ictcampus.chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import net.ictcampus.chess.gui.StartPane;
import net.ictcampus.chess.gui.Style;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("CHESS");
        Pane start = new StartPane(stage, "chess");
        Scene scene = new Scene(start, 900, 900);
        Style.setStyleSheet(scene, "/css/main.css");
        stage.setScene(scene);
        // primaryStage.setFullScreen(true);
        stage.show();
    }

}
