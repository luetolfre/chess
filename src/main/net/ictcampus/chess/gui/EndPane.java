package net.ictcampus.chess.gui;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import net.ictcampus.chess.model.Chess;

public class EndPane extends BorderPane {

    private final Chess GAME;
    private final Stage STAGE;
    private final Text TITLE;
    private final Button BUTTON;


    public EndPane(Chess game, Stage STAGE, String TITLE) {
        this.GAME = game;
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
