package net.ictcampus.chess.gui;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Rectangle;
import net.ictcampus.chess.Controller;
import net.ictcampus.chess.model.Chess;
import net.ictcampus.chess.model.Piece;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class BoardGrid extends GridPane {

    private Chess game;
    final static int SIZE = 8;
    private List<Rectangle> tiles;
    private List<Piece> pieces;


    public BoardGrid(Chess game) throws FileNotFoundException {
        this.game = game;
        this.pieces = Controller.createObservablePieces(game.getPieces());
        this.createBoard();
        this.updatePieces();
        this.style();
    }


    private void createBoard(){
        for (int row = 0; row<SIZE; row++){
            for (int col = 0; col<SIZE; col++){
                //StackPane tile = new StackPane();
                Rectangle tile = new Rectangle();
                Style.setStyleClass(tile,"tile");
                if ((row + col) % 2 == 0) {
                    Style.setStyleClass(tile, "light-tile");
                } else {
                    Style.setStyleClass(tile, "dark-tile");
                }
                bindSize(tile, this, col, row);
                this.add(tile, col, row);
            }
        }
        //setConstraints(board);
    }

    private void updatePieces() throws FileNotFoundException {
        for (Piece p : pieces){
            this.add(getImage(p.getImagePath()), p.getRow(), p.getCol());
        }
    }

    private ImageView getImage(String path) throws FileNotFoundException {
        Image image = new Image(new FileInputStream(path));
        ImageView img = new ImageView(image);
        Style.setStyleClass(img, "piece-img");
        return img;
    }


    private void bindSize(Rectangle tile, GridPane board, int col, int row){
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

    private void style(){
        Style.setStyleSheet(this, "/css/chess.css");
        Style.setStyleClass(this, "board");
    }

}
