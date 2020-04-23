package net.ictcampus.chess.gui;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import net.ictcampus.chess.App;
import net.ictcampus.chess.Controller;

import java.io.FileNotFoundException;

public class StartPane extends BorderPane {

    private final Stage STAGE;
    private final Text TITLE;
    private final Button BUTTON;

    public StartPane(Stage stage, String title) {
        this.STAGE = stage;
        this.TITLE = new Text(title);
        this.BUTTON = new Button("play");
        this.style();
        this.setup();
    }

    private void style(){
        Style.setStyleSheet(this, "/css/start.css");
        Style.setStyleClass(this.TITLE, "scene-title");
        Style.setStyleClass(this.BUTTON, "play-button");
    }

    private void setup(){
        this.BUTTON.setOnAction(event -> {
            try {
                Controller.showGamePane(STAGE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        VBox main = Style.addToVBox(Style.addToHBox(this.TITLE), Style.addToHBox(this.BUTTON));
        this.setCenter(main);
    }
}
