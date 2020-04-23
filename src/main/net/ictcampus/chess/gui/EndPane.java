package net.ictcampus.chess.gui;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import net.ictcampus.chess.Controller;

public class EndPane extends BorderPane {

    private final Controller CONTROLLER;
    private final Stage STAGE;
    private final Text TITLE;
    private final Button BUTTON;


    public EndPane(Controller CONTROLLER, Stage STAGE, String TITLE) {
        this.CONTROLLER = CONTROLLER;
        this.STAGE = STAGE;
        this.TITLE = new Text(TITLE);
        this.BUTTON = new Button("end game");
        this.style();
        this.setup();
    }

    private void style() {
    }

    private void setup(){

    }
}
