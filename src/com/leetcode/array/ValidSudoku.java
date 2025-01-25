package com.leetcode.array;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/valid-sudoku/description/
public class ValidSudoku {

    public static void main(String[] args) {
        System.out.println(isValid(new char[][]{{'5','3','.','.','7','.','.','.','.'}
                                                ,{'6','.','.','1','9','5','.','.','.'}
                                                ,{'.','9','8','.','.','.','.','6','.'}
                                                ,{'8','.','.','.','6','.','.','.','3'}
                                                ,{'4','.','.','8','.','3','.','.','1'}
                                                ,{'7','.','.','.','2','.','.','.','6'}
                                                ,{'.','6','.','.','.','.','2','8','.'}
                                                ,{'.','.','.','4','1','9','.','.','5'}
                                                ,{'.','.','.','.','8','.','.','7','9'}}));
        System.out.println(isValid(new char[][]{{'8','3','.','.','7','.','.','.','.'}
                                                ,{'6','.','.','1','9','5','.','.','.'}
                                                ,{'.','9','8','.','.','.','.','6','.'}
                                                ,{'8','.','.','.','6','.','.','.','3'}
                                                ,{'4','.','.','8','.','3','.','.','1'}
                                                ,{'7','.','.','.','2','.','.','.','6'}
                                                ,{'.','6','.','.','.','.','2','8','.'}
                                                ,{'.','.','.','4','1','9','.','.','5'}
                                                ,{'.','.','.','.','8','.','.','7','9'}}));

        System.out.println(isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'}
                                                    ,{'6','.','.','1','9','5','.','.','.'}
                                                    ,{'.','9','8','.','.','.','.','6','.'}
                                                    ,{'8','.','.','.','6','.','.','.','3'}
                                                    ,{'4','.','.','8','.','3','.','.','1'}
                                                    ,{'7','.','.','.','2','.','.','.','6'}
                                                    ,{'.','6','.','.','.','.','2','8','.'}
                                                    ,{'.','.','.','4','1','9','.','.','5'}
                                                    ,{'.','.','.','.','8','.','.','7','9'}}));
        System.out.println(isValidSudoku(new char[][]{{'8','3','.','.','7','.','.','.','.'}
                                                    ,{'6','.','.','1','9','5','.','.','.'}
                                                    ,{'.','9','8','.','.','.','.','6','.'}
                                                    ,{'8','.','.','.','6','.','.','.','3'}
                                                    ,{'4','.','.','8','.','3','.','.','1'}
                                                    ,{'7','.','.','.','2','.','.','.','6'}
                                                    ,{'.','6','.','.','.','.','2','8','.'}
                                                    ,{'.','.','.','4','1','9','.','.','5'}
                                                    ,{'.','.','.','.','8','.','.','7','9'}}));
    }

    /**
     * Time Complexity - O(n^2)
     * Space Complexity - O(n) - Here n is always 9 so space can be considered constant O(1). Needs 27 HashSets in total
     *
     */
    static boolean isValid(char[][] sudoku) {
        int n = sudoku.length;

        Set<Character>[] rows = new HashSet[n];
        Set<Character>[] columns = new HashSet[n];
        Set<Character>[] boxes = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                char val = sudoku[r][c];

                if (val == '.') {
                    continue;
                }

                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                if (columns[c].contains(val)) {
                    return false;
                }
                columns[c].add(val);

                // boxIdx explanation - https://www.geeksforgeeks.org/check-if-given-sudoku-board-configuration-is-valid-or-not/
                int boxIdx = (r / 3) * 3 + (c / 3);

                if (boxes[boxIdx].contains(val)) {
                    return false;
                }
                boxes[boxIdx].add(val);
            }
        }

        return true;
    }

    // another solution with only 1 HashSet
    static boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                char number = board[row][column];
                if (number != '.') {
                    if (!set.add(number + " in row " + row) ||
                            !set.add(number + " in column " + column) ||
                            !set.add(number + " in block " + (row / 3) + "," + (column / 3)))
                        return false;
                }
            }
        }
        return true;
    }
}
