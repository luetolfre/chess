package net.ictcampus.chess;

import javafx.css.PseudoClass;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import net.ictcampus.chess.gui.ChessPane;
import net.ictcampus.chess.gui.EndPane;
import net.ictcampus.chess.gui.Style;
import net.ictcampus.chess.model.Chess;
import net.ictcampus.chess.model.Piece;
import net.ictcampus.chess.model.Position;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Chess Game Controller</h1>
 * The Controller manages Interactions between the model and the GUI
 *
 * @author luetolfre
 * @version 1.0
 * @since 2020-04-24
 */
public class Controller {


    public static void play(){

    }

    /**
     * Creates an instance of the Chess Game, that will be accessible from
     * front end.
     * @param player1 name of player 1
     * @param player2 name of player 2
     * @return new Chess Game
     */
    private static Chess createGame(String player1, String player2){
        return new Chess(player1, player2);
    }

    /**
     * Makes pieces from Game observable from Front-End
     * @param board the board of the game
     * @return the observable Pieces List
     */
    public static List<Position> createObservablePieces(Position[][] board){
        List<Position> pieces = new ArrayList<>();
        for (int i= 0; i<8; i++){
            for (int j=0; j<8; j++){
                if(board[i][j].getPiece() != null){
                    pieces.add(board[i][j]);
                }
            }
        }
        // TODO make binding in pieces.
        return pieces;
    }

    /**
     * This method switches the Scene to the Game View.
     * @param game the current game
     * @param stage the stage in which the new scene is shown
     * @throws FileNotFoundException on not found image File for pieces
     */
    public static void showGamePane(Chess game, Stage stage) throws FileNotFoundException {
        // createGame("p2", "p1");
        showPane(stage, new ChessPane(game, stage, "CHESS"));
    }

    /**
     * This method switches the Scene to the End View.
     * @param game the current game
     * @param stage the stage in which the scene is shown
     */
    public static void showEndPane(Chess game, Stage stage){
        showPane(stage, new EndPane(game, stage, "CHESS"));
    }

    /**
     * This method adds a pane to a new scene and shows it on stage
     * @param stage the stage in which the scene is shown
     * @param pane the pane that will be added to the scene
     */
    private static void showPane(Stage stage, Pane pane){
        Scene scene = new Scene(pane, 800, 800);
        Style.setStyleSheet(scene, "/css/main.css");
        stage.setScene(scene);
        //stage.setFullScreen(true);
        stage.show();
    }


    public static void checkPiece(Chess game, Position position){
        game.getBoard().updatePossibleMoves(position);
        List<Position> possibilities = position.getPiece().getPossibleMoves();
        System.out.println("-----");
        for (Position p:possibilities) {
            //Node node =
            System.out.println(p.getRow() + " " + p.getCol());
        }
    }

    public static Node getNode(GridPane grid, int row, int col){
        for (Node node:grid.getChildren()) {
            if (grid.getRowIndex(node)== row && grid.getColumnIndex(node)== col){
                return node;
            }
        }
        return null;
    }

    public static boolean doMove(Chess game, Position start, Position end) throws Exception {
        return game.move(game.getCurrPlayer(), start, end);

    }

}
