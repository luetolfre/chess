package net.ictcampus.chess.model;

import net.ictcampus.chess.constant.Color;

public class Board {
    private static final int SIZE = 8;
    private Position[][] tiles;

    public Board() {
        this.tiles = initBoard();
    }

    public Position[][] initBoard(){
        Position[][] tiles = new Position[SIZE][SIZE];
        for (int i = 0; i<SIZE; i++){
            tiles[1][i]= new Position(1,i,new Pawn( Color.BLACK));
            tiles[6][i]= new Position(6,i,new Pawn( Color.WHITE));
        }
        tiles[7][0] = new Position(7,0, new Rook(Color.WHITE));
        tiles[7][1] = new Position(7,1, new Knight(Color.WHITE));
        tiles[7][2] = new Position(7,2, new Bishop(Color.WHITE));
        tiles[7][3] = new Position(7,3, new Queen(Color.WHITE));
        tiles[7][4] = new Position(7,4, new King(Color.WHITE));
        tiles[7][5] = new Position(7,5, new Bishop(Color.WHITE));
        tiles[7][6] = new Position(7,6, new Knight(Color.WHITE));
        tiles[7][7] = new Position(7,7, new Rook(Color.WHITE));

        tiles[0][0] = new Position(0,0, new Rook(Color.BLACK));
        tiles[0][1] = new Position(0,1, new Knight(Color.BLACK));
        tiles[0][2] = new Position(0,2, new Bishop(Color.BLACK));
        tiles[0][3] = new Position(0,3, new Queen(Color.BLACK));
        tiles[0][4] = new Position(0,4, new King(Color.BLACK));
        tiles[0][5] = new Position(0,5, new Bishop(Color.BLACK));
        tiles[0][6] = new Position(0,6, new Knight(Color.BLACK));
        tiles[0][7] = new Position(0,7, new Rook(Color.BLACK));

        for (int row = 2; row < 6; row++) {
            for (int col = 0; col < 8; col++) {
                tiles[row][col] = new Position(row, col, null);
            }
        }
        return tiles;
    }

    public Position getTile(int row, int col) throws Exception {
        if (row<0 || row>=SIZE || col<0 || col>=SIZE){
            throw new Exception("Index out of Bound");
        }
        return tiles[row][col];

    }

    public Position[][] getTiles() {
        return tiles;
    }
    /*
    private List<Position> createBoard() {
        List<Position> board = new ArrayList<>();
        for (int y=0; y<SIZE; y++){
            for (int x=0; x<SIZE; x++){
                board.add(new Position(x,y));
            }
        }
        return board;
    }

     */

    /*
    private List<Piece> createPieces(){
        List<Piece> pieces = new ArrayList<>();
        for (int i = 0; i<SIZE; i++){
            pieces.add(new Pawn(1,i, Color.BLACK));
            pieces.add(new Pawn(6,i, Color.WHITE));
        }
        pieces.add(new Rook(0,0, Color.BLACK));
        pieces.add(new Rook(0,7, Color.BLACK));
        pieces.add(new Rook(7,0, Color.WHITE));
        pieces.add(new Rook(7,7, Color.WHITE));

        pieces.add(new Knight(0,1, Color.BLACK));
        pieces.add(new Knight(0,6, Color.BLACK));
        pieces.add(new Knight(7,1, Color.WHITE));
        pieces.add(new Knight(7,6, Color.WHITE));

        pieces.add(new Bishop(0,2, Color.BLACK));
        pieces.add(new Bishop(0,5, Color.BLACK));
        pieces.add(new Bishop(7,2, Color.WHITE));
        pieces.add(new Bishop(7,5, Color.WHITE));

        pieces.add(new Queen(0,3, Color.BLACK));
        pieces.add(new Queen(7,3, Color.WHITE));

        pieces.add(new King(0,4, Color.BLACK));
        pieces.add(new King(7,4, Color.WHITE));

        return pieces;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public boolean isEmpty(int row, int col){
        return getPiece(row,col) == null;
    }
    public boolean isPiece(int row, int col){
        return getPiece(row, col) != null;
    }

    public Piece getPiece(int row, int col){
        for( Piece p: this.getPieces()){
            if(p.getRow()==row && p.getCol()==col) return p;
        }
        return null;
    }

    public boolean isYourPiece(int row, int col, Color color){
        if(isPiece(row, col)){
            return getPiece(row,col).getColor() == color;
        }
        return false;
    }

    public boolean isOtherPiece(int row, int col, Color color){
        if(isPiece(row, col)){
            return getPiece(row,col).getColor() != color;
        }
        return false;
    }

    public boolean isOnBoard(int row, int col){
        return 0<=row && row <8 && 0<=col && col<8;
    }

     */
}
