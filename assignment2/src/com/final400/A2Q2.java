package com.final400;

import java.util.Scanner;

public class A2Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String lineNumberString = input.nextLine();
        int lineNumber = Integer.parseInt(lineNumberString);
        String[] lines = new String[lineNumber];
        for (int i = 0; i < lineNumber; i++) {
            lines[i] = input.nextLine();
        }
        input.close();
        for (int i = 0; i < lineNumber; i++) {
            String line = lines[i];
            aCase(line);
        }
    }

    public static void aCase(String chessLine) {
        String[] everyChess = chessLine.split(" ");
        boolean legal = true;
        int[][] aBoard = new int[8][8];
        for (int i = 0; i < 8; i++) {
            String nextChess = everyChess[i];
            legal = putChess(nextChess, aBoard);
            if (!legal) break;
        }
        if (legal) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean putChess(String chessLoc, int[][] aBoard) {
        int col = (chessLoc.charAt(0) - 97);
        int row = (chessLoc.charAt(1) - 49);
        if (aBoard[col][row] == 0) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    int colDiffer = Math.abs(i - col);
                    int rowDiffer = Math.abs(j - row);
                    if (i == col) {
                        aBoard[i][j] = 1;
                    }
                    if (j == row) {
                        aBoard[i][j] = 1;
                    }
                    if (colDiffer == rowDiffer) {
                        aBoard[i][j] = 1;
                    }
                }
            }
            return true;

        } else return false;
    }
}
