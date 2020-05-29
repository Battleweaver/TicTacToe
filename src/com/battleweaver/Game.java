package com.battleweaver;


public class Game {

    private int SIZE = 0;
    public static final String FILLER = " ";
    private String[][] board;
    private Player[] players =
            {new AIPlayer("Computer1", "X"), new AIPlayer("Computer2", "O")};
    private Player currPlayer = null;

    public Game(String player1, String player2, int grid) {
        this(player1, grid);
        players[1] = new Player(player2, "O");
    }

    public Game(String player, int grid) {
        SIZE = grid < 3 ? 3 : grid;
        board = new String[SIZE][SIZE];
        players[0] = new Player(player, "X");
        currPlayer = players[0];
        clearBoard();
    }

    private void clearBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = FILLER;
            }
        }
    }

    public void start() {
        printBoard();
        currPlayer.playMove(this);
    }

    private boolean isNoMovesLeft() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j].equals(FILLER)) {
                    return false;
                }
            }
        }
        return true;
    }


    public void move(int xPosition, int yPosition) {
        if (!isValidMove(xPosition, yPosition))
            currPlayer.playMove(this);
        board[xPosition][yPosition] = currPlayer.getSymbol();
        changePlayer();
        printBoard();
        if (!isGameOver()) {
            currPlayer.playMove(this);
        }
    }

    private boolean isValidMove(int xPosition, int yPosition) {
        if (xPosition >= SIZE || yPosition >= SIZE || xPosition < 0 || yPosition < 0)
            return false;
        if (!board[xPosition][yPosition].equals(FILLER))
            return false;
        return true;
    }


    private void changePlayer() {
        currPlayer = currPlayer.equals(players[1]) ? players[0] : players[1];
    }

    private void printBoard() {
        String header = "  ";
        for (int j = 0; j < SIZE; j++) {
            header += "|" + (j + 1);
        }
        System.out.println(header);
        for (int j = 0; j < SIZE * 3; j++) {
            System.out.print("_");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            String row = (i + 1) + " ";
            for (int j = 0; j < SIZE; j++) {
                row += "|" + board[i][j];
            }
            System.out.println(row);
            for (int j = 0; j < SIZE * 3; j++) {
                System.out.print("_");
            }
            System.out.println();
        }
        System.out.println(currPlayer.getName() + " Turn now");
    }

    private boolean isGameOver() {
        return getWinner() != null || isNoMovesLeft();
    }

    private String rowCrossed() {
        for (int i = 0; i < SIZE; i++) {
            String check = board[i][0];
            for (int j = 1; j < SIZE; j++) {
                if (!check.equals(board[i][j])) {
                    check = FILLER;
                    break;
                }
            }
            if (!check.equals(FILLER)) {
                return check;
            }
        }
        return FILLER;
    }

    private String columnCrossed() {
        for (int i = 0; i < SIZE; i++) {
            String check = board[0][i];
            for (int j = 1; j < SIZE; j++) {
                if (!check.equals(board[j][i])) {
                    check = FILLER;
                    break;
                }
            }
            if (!check.equals(FILLER)) {
                return check;
            }
        }
        return FILLER;
    }

    private String diagonalCrossed() {
        String check = board[0][0];
        for (int i = 1; i < SIZE; i++) {
            if (!check.equals(board[i][i])) {
                check = FILLER;
                break;
            }
        }
        if (!check.equals(FILLER)) {
            return check;
        }
        check = board[0][2];
        for (int i = 1; i < SIZE; i++) {
            if (!check.equals(board[i][SIZE - 1 - i])) {
                check = FILLER;
                break;
            }
        }
        if (!check.equals(FILLER)) {
            return check;
        }
        return FILLER;
    }

    public Player getWinner() {
        String rowSymbol = rowCrossed();
        String columnSymbol = columnCrossed();
        String diagonalSymbol = diagonalCrossed();
        for (Player player : players) {
            if (player.getSymbol().equals(rowSymbol)) return player;
            if (player.getSymbol().equals(columnSymbol)) return player;
            if (player.getSymbol().equals(diagonalSymbol)) return player;
        }
        return null;
    }


    public String[][] getBoard() {
        return board;
    }
}
