package net.ictcampus.chess.gui;

import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import net.ictcampus.chess.Controller;
import net.ictcampus.chess.model.Chess;

import java.io.FileNotFoundException;


public class ChessPane extends BorderPane {

    private final Chess GAME;
    private final Stage STAGE;
    private final Text TITLE;
    private final GridPane BOARD;
    private final Button BUTTON;


    public ChessPane(Chess game, Stage STAGE, String TITLE) throws FileNotFoundException {
        this.GAME = game;
        this.STAGE = STAGE;
        this.TITLE = new Text(TITLE);
        this.BOARD = new BoardGrid(game);
        this.BUTTON = new Button("end game");
        this.style();
        this.setup();
    }

    private void setup() {
        this.BUTTON.setOnAction(event -> Controller.showEndPane(this.GAME, STAGE));
        this.setCenter(this.BOARD);
        this.setBottom(this.BUTTON);
    }

    private void style(){
        Style.setStyleSheet(this, "/css/chess.css");
        Style.addStyleClass(this, "chess-pane");
        Style.addStyleClass(this.TITLE, "scene-title");
        Style.addStyleClass(this.BOARD, "board");
        Style.addStyleClass(this.BUTTON, "play-button");
    }
}
