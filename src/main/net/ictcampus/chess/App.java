package net.ictcampus.chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CHESS");
        Scene scene = new Scene(new Pane(), 700, 700);
        scene.getStylesheets().add(App.class.getResource("/css/main.css").toExternalForm());
        primaryStage.setScene(scene);
        // primaryStage.setFullScreen(true);
        primaryStage.show();
        // test
    }
}
