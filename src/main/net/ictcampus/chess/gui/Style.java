package net.ictcampus.chess.gui;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import net.ictcampus.chess.ChessApp;

public class Style {

    public static void setStyleSheet(Pane pane, String stylesheet){
        pane.getStylesheets().add(ChessApp.class.getResource(stylesheet).toExternalForm());
    }
    public static void setStyleSheet(Scene scene, String stylesheet){
        scene.getStylesheets().add(ChessApp.class.getResource(stylesheet).toExternalForm());
    }

    public static void setStyleClass(Node node, String className){
        node.getStyleClass().add(className);
    }

    public static HBox addToHBox(Node... nodes){
        HBox hBox = new HBox();
        setStyleClass(hBox, "h-box");
        hBox.getChildren().addAll(nodes);
        return hBox;
    }

    public static VBox addToVBox(Node... nodes){
        VBox vBox = new VBox();
        setStyleClass(vBox, "h-box");
        vBox.getChildren().addAll(nodes);
        return vBox;
    }
}
