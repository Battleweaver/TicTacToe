package main.com.battleweaver;

import java.util.Scanner;

public class Main {

    public static final int GRID = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game;
        int boardSize = 0;

        boardLoop:
        while (true) {
            System.out.println("Enter a board size (from 2 to 20)");
            try {
                String input = scanner.next();
                if (input.matches("^[+-]?\\d+$")) {
                    int boardSizeInput = Integer.parseInt(input);
                    if (boardSizeInput < 2) {
                        System.out.println("Too small. 2 to 20 is allowed");
                    } else if (boardSizeInput > 20) {
                        System.out.println("Too large. 2 to 20 is allowed");
                    } else {
                        boardSize = boardSizeInput;
                        break boardLoop;
                    }
                } else {
                    System.out.println("Try input a number from 2 to 20");
                }

            } catch (Exception e) {
            }
        }

        playerLoop:
        while (true) {
            System.out.println("Enter number of human players");
            try {
                String input = scanner.next();
                if (input.matches("^[+-]?\\d+$")) {
                    int playerQuantity = Integer.parseInt(input);
                    if (playerQuantity < 1) {
                        System.out.println("Too little. 1 or 2 players are allowed");
                    } else if (playerQuantity == 1) {
                        game = new Game("Player1", boardSize);
                        break playerLoop;
                    } else if (playerQuantity == 2) {
                        game = new Game("Player1", "Player2", boardSize);
                        break playerLoop;
                    } else if (playerQuantity > 2) {
                        System.out.println("Too many. 1 or 2 players are allowed");
                    }
                }else {
                    System.out.println("Try input a number 1 or 2");
                }

            } catch (Exception e) {
            }
        }
        game.start();
        Player winner = game.getWinner();
        System.out.println(winner != null ? "Winner is " + winner.getName() : "Tied");
    }


}
