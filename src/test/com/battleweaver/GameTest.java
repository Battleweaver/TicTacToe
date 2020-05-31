package test.com.battleweaver;

import main.com.battleweaver.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class GameTest {
    int BOARD_SIZE = 3;
    Game testGame = new Game("", 0, BOARD_SIZE);
    Game testHumanGame = new Game("Player1", "Player2", BOARD_SIZE);
    @org.junit.jupiter.api.Test
    void getBoard() {
        String [][] empty_board = new String[][] {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        String [][] created_board = testGame.getBoard();

        Assertions.assertArrayEquals(empty_board, created_board);
    }
    @Test
    void start() {

    }

    @Test
    void move() {
    }

    @Test
    void getWinner() {

    }


}