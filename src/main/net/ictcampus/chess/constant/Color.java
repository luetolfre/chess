package net.ictcampus.chess.constant;

public enum Color {
    WHITE(-1), BLACK(1);

    private int dir;

    Color(int dir) {
        this.dir = dir;
    }

    public int getDir() {
        return dir;
    }
}
