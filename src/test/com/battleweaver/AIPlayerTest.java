package test.com.battleweaver;

import main.com.battleweaver.Game;
import main.com.battleweaver.AIPlayer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AIPlayerTest {
    private final int BOARD_SIZE = 3;
    String[][] resultBoard = new String[][] {{"O", "O", "X"}, {"X", "X", "O"}, {"O", "X", "X"}};
    Game testGame = new Game("", 0, BOARD_SIZE);
    @Test
    void works3x3() {
        testGame.start();
        String[][] final_board = testGame.getBoard();

        assertArrayEquals(resultBoard,final_board);
    }
}