package net.ictcampus.chess.gui;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import net.ictcampus.chess.Controller;


public class ChessPane extends BorderPane {

    private final Stage STAGE;
    private final Text TITLE;
    private final GridPane BOARD;
    private final Button BUTTON;


    public ChessPane(Stage STAGE, String TITLE) {
        this.STAGE = STAGE;
        this.TITLE = new Text(TITLE);
        this.BOARD = createBoard();
        this.BUTTON = new Button("end game");
        this.style();
        this.setup();
    }

    private void setup(){
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

    private GridPane createBoard(){
        GridPane board = new GridPane();
        final int SIZE = 8;
        for (int row = 0; row<SIZE; row++){
            for (int col = 0; col<SIZE; col++){
                //StackPane tile = new StackPane();
                Rectangle tile = new Rectangle();
                if ((row + col) % 2 == 0) {
                    Style.setStyleClass(tile, "light-tile");
                } else {
                    Style.setStyleClass(tile, "dark-tile");
                }
                bindSize(tile, board, SIZE, col, row);
                board.add(tile, col, row);
            }
        }
        //setConstraints(board);
        return board;
    }

    private void bindSize(Rectangle tile, GridPane board, int SIZE, int col, int row){
        // TODO: make size dynamic
        NumberBinding rectsAreaSize = Bindings.min(board.heightProperty(), board.widthProperty());

        tile.xProperty().bind(rectsAreaSize.multiply(row).divide(SIZE));
        tile.yProperty().bind(rectsAreaSize.multiply(col).divide(SIZE));

        tile.widthProperty().bind(rectsAreaSize.divide(SIZE));
        tile.heightProperty().bind(rectsAreaSize.divide(SIZE));
    }

    private void setConstraints(GridPane board){
        for (int i = 0; i < 8; i++) {
            board.getColumnConstraints().add(new ColumnConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            board.getRowConstraints().add(new RowConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }
    }

    private VBox createVBoxText(String string){
        Text text = new Text(string);
        Style.setStyleClass(text, "player-name");
        VBox vBox = Style.addToVBox(text);
        Style.setStyleClass(vBox, "player-v-box");
        return vBox;
    }

}
