package main.com.battleweaver;

public class Move {

    private final int row;

    public int getRow() {
        return row;
    }


    @Override
    public String toString() {
        return "Move{" +
                "row=" + row +
                ", column=" + column +
                ", score=" + score +
                '}';
    }

    public int getColumn() {
        return column;
    }


    private final int column;


    public int getScore() {
        return this.score;
    }

    private final int score;

    public Move(int row, int column, int score) {
        this.row = row;
        this.column = column;
        this.score = score;
    }
}
