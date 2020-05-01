package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;

/**
 * <h3> Player Class </h3>
 * represents a chess Move
 *
 * @author luetolfre
 * @version 1.0
 * @since 2020-05-01
 */
public class Player {
    private final String username;
    private final Color color;

    /**
     * Initializes a Player object
     * @param username of the Player
     * @param color of the Players Pieces
     */
    public Player(String username, Color color) {
        this.username = username;
        this.color = color;
    }

    /**
     * Checks if the Player is White
     * @return bool
     */
    public boolean isWhite(){
        return this.color == Color.WHITE;
    }


    public Color getColor() {
        return this.color;
    }
}
