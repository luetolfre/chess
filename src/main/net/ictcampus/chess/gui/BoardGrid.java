package net.ictcampus.chess.gui;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import net.ictcampus.chess.Controller;
import net.ictcampus.chess.constant.Color;
import net.ictcampus.chess.model.Board;
import net.ictcampus.chess.model.Chess;
import net.ictcampus.chess.model.Position;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BoardGrid extends GridPane {

    private final Chess GAME;
    private final static int SIZE = 8;
    private List<Rectangle> tiles;
    private List<Position> pieces;
    private Position currPosition;


    public BoardGrid(Chess game) throws FileNotFoundException {
        this.GAME = game;
        this.pieces = Controller.createObservablePieces(game.getBoard().getTiles());
        this.tiles = new ArrayList<>();
        this.createBoard();
        this.updatePieces();
        this.style();
    }


    private void createBoard(){
        for (int row = 0; row<SIZE; row++){
            for (int col = 0; col<SIZE; col++){
                //StackPane tile = new StackPane();
                Rectangle tile = new Rectangle();
                Style.addStyleClass(tile,"tile");
                if ((row + col) % 2 == 0) {
                    Style.addStyleClass(tile, "light-tile");
                } else {
                    Style.addStyleClass(tile, "dark-tile");
                }
                //setMouseClickListener(tile);
                int finalRow = row;
                int finalCol = col;
                tile.setOnMouseClicked(event -> {
                    try {
                        checkTile(finalRow, finalCol);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                bindSize(tile, this, col, row);
                tiles.add(tile);
                this.add(tile, col, row);
            }
        }
        //setConstraints(board);
    }

    private void updatePieces() throws FileNotFoundException {
        for (Position position : pieces){
            ImageView img = getImage(position.getPiece().getImagePath());
            img.setOnMouseClicked(event -> {
                try {
                    checkPiece(img, position);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            this.add(img, position.getCol(), position.getRow());
        }
    }

    private ImageView getImage(String path) throws FileNotFoundException {
        Image image = new Image(new FileInputStream(path));
        ImageView img = new ImageView(image);
        Style.addStyleClass(img, "piece-img");
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
        Style.addStyleClass(this, "board");
    }

    private void checkPiece(ImageView img, Position positionPiece) {
        Board board = this.GAME.getBoard();
        Color color =this.GAME.getCurrPlayer().getColor();
        unHighlight();
        if(board.isColoredPiece(positionPiece.getRow(),positionPiece.getCol(),color)) {
            this.GAME.getBoard().update();
            List<Position> possibilities = positionPiece.getPiece().getPossibleMoves();
            System.out.println("-----");
            setCurrPosition(positionPiece);
            for (Position possiblePosition : possibilities) {
                Node node = Controller.getNode(this, possiblePosition.getRow(), possiblePosition.getCol());
                assert node != null;
                Style.addStyleClass(node, "highlight");
                node.setOnMouseClicked(e -> movable(img, possiblePosition, positionPiece));
                    // TODO reset mouseclickevent after this.
                    // TODO set Mouseclickevent outside of function

                System.out.println(possiblePosition.getRow() + " " + possiblePosition.getCol());
            }
        }
    }

    private void movable(ImageView img, Position possiblePosition, Position position){
        try {
            if(Controller.doMove(GAME, currPosition, possiblePosition)){
                //GAME.getBoard().printBoard();
                this.getChildren().remove(getImage(possiblePosition.getRow(), possiblePosition.getCol()));
                this.getChildren().remove(img);

                this.add(img, possiblePosition.getCol(), possiblePosition.getRow());
                /*
                img.setOnMouseClicked(event -> {
                    try {
                        checkPiece(img, position);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                });*/
                for (Node n : this.getChildren()) {
                    Style.delStyleClass(n, "highlight");
                }
            };
            setMouseClickListener();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void checkTile(int row, int col) throws Exception {
        Board board = this.GAME.getBoard();
        Color color =this.GAME.getCurrPlayer().getColor();
        if(board.isPiece(row,col) && board.getPiece(row,col).getColor()==color){
            ImageView img = getImage(row, col); //getImage(board.getPiece(row, col).getImagePath());
            checkPiece(img, this.GAME.getBoard().getTile(row,col));
        }
    }


    public void setCurrPosition(Position currPosition) {
        this.currPosition = currPosition;
    }

    private void unHighlight(){
        for (Node node : this.getChildren()) {
            Style.delStyleClass(node, "highlight");
        }
    }

    private void setMouseClickListener(){
        for (int row = 0; row<SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                int finalRow = row;
                int finalCol = col;
                Objects.requireNonNull(getNode(row, col)).setOnMouseClicked(event -> {
                    try {
                        checkTile(finalRow, finalCol);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }

    private Node getNode(int row, int col){
        for (Node node:getChildren()) {
            if (getRowIndex(node)== row && getColumnIndex(node)== col){
                return node;
            }
        }
        return null;
    }

    private ImageView getImage(int row, int col){
        for (Node node:getChildren()) {
            if (getRowIndex(node)== row && getColumnIndex(node)== col && node instanceof ImageView){
                return (ImageView) node;
            }
        }
        return null;
    }


}
