package main.com.battleweaver;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game;
        int boardSize = 0;

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
                        break;
                    }
                } else {
                    System.out.println("Try input a number from 2 to 20");
                }

            } catch (Exception ignored) {
            }
        }
        playerLoop:
        while (true) {
            System.out.println("Enter number of human players");
            try {
                String input = scanner.next();
                if (input.matches("^[+-]?\\d+$")) {
                    int playerQuantity = Integer.parseInt(input);
                    if (playerQuantity < 0) {
                        System.out.println("Too little. 0, 1 or 2 players are allowed");
                    } else if (playerQuantity == 0){
                        game = new Game("", 0, boardSize);
                        break;
                    } else if (playerQuantity == 1) {
                        System.out.println("Enter your symbol X or O (letter, not digit)");
                        try {
                            String inputSymbol = scanner.next();
                            if (inputSymbol != null && inputSymbol.length() == 1) {
                                char inputChar;
                                inputChar = inputSymbol.toUpperCase().charAt(0);
                                if (inputChar == 'X') {
                                    game = new Game("Player1", 0, boardSize);
                                    break;
                                } else if (inputChar == 'O') {
                                    game = new Game("Player2", 1, boardSize);
                                    break;
                                } else {
                                    System.out.println("Please, input X or O");
                                }
                            } else {
                                System.out.println("Please, input 1 symbol. X or O");
                            }
                        } catch (Exception ignored) {
                        }

                    } else if (playerQuantity == 2) {
                        game = new Game("Player1", "Player2", boardSize);
                        break;
                    } else {
                        System.out.println("Too many. 0, 1 or 2 players are allowed");
                    }
                }else {
                    System.out.println("Try input a number 0, 1 or 2");
                }

            } catch (Exception ignored) {
            }
        }
        game.start();
        Player winner = game.getWinner();
        System.out.println(winner != null ? "Winner is " + winner.getName() : "Tied");
    }


}
