package net.ictcampus.chess.gui;

import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import net.ictcampus.chess.Controller;
import java.io.FileNotFoundException;


public class ChessPane extends BorderPane {

    private final Stage STAGE;
    private final Text TITLE;
    private final GridPane BOARD;
    private final Button BUTTON;


    public ChessPane(Stage STAGE, String TITLE) throws FileNotFoundException {
        this.STAGE = STAGE;
        this.TITLE = new Text(TITLE);
        this.BOARD = new BoardGrid();
        this.BUTTON = new Button("end game");
        this.style();
        this.setup();
    }

    private void setup() {
        this.BUTTON.setOnAction(event -> {Controller.showEndPane(STAGE);});
        this.setCenter(this.BOARD);
        //this.setLeft(createVBoxText("player1"));
        //this.setRight(createVBoxText("player2"));
        this.setBottom(this.BUTTON);
    }

    private void style(){
        Style.setStyleSheet(this, "/css/chess.css");
        Style.setStyleClass(this, "chess-pane");
        Style.setStyleClass(this.TITLE, "scene-title");
        Style.setStyleClass(this.BOARD, "board");
        Style.setStyleClass(this.BUTTON, "play-button");
    }
    private VBox createVBoxText(String string){
        Text text = new Text(string);
        Style.setStyleClass(text, "player-name");
        VBox vBox = Style.addToVBox(text);
        Style.setStyleClass(vBox, "player-v-box");
        return vBox;
    }

}
