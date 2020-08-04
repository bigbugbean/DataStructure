package com.bugbean.arithmetic;

import java.util.Arrays;

/**
 * 外卖-订单
 *
 * @author dugm
 * @version 1.0.0
 * @module 订单
 * @Description
 */
public class NQueen {

    private String[][] chessboard;
    private int ways;

    public static void main(String[] args) {
        new NQueen().solveNQueens(50);
    }


    public void solveNQueens(int n) {

        chessboard = new String[n][n];

        putRow(0);
        System.out.println("一共有" + ways + "种解法");

    }

    public void putRow(int row) {
        if (row >= chessboard.length) {
            ways++;
            for (String[] rowStr : chessboard) {
                System.out.println(Arrays.toString(rowStr));
            }
            System.out.println("======================================");
            return;
        }
        for (int column = 0; column < chessboard.length; column++) {
            if (canPut(row, column)) {
                put(row, column);
                putRow(row + 1);
            }
        }
    }

    private boolean canPut(int row, int column) {

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < chessboard.length; j++) {
                if ("Q".equals(chessboard[i][j])) {
                    if (j == column) {
                        return false;
                    } else if (row - i == Math.abs(column - j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void put(int row, int column) {

        for (int i = 0; i < chessboard.length; i++) {
            chessboard[row][i] = ".";
        }
        chessboard[row][column] = "Q";
    }
}
