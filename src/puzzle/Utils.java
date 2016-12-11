/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

/**
 *
 * @author Rana
 */
public class Utils {
    static public MatrixPosition searchInMatrix(int[][] matrix, int item) {
        MatrixPosition position;
        //all rows have same length
        int matrixRows = matrix.length;
        int matrixColumns = matrix[0].length;

        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixColumns; j++) {
                if (item == matrix[i][j]) {
                    position = new MatrixPosition(i, j);
                    return position;
                }
            }
        }
        return null;
    }

    static public void printMatrix(int[][] matrix) {
        int matrixRows = matrix.length;
        int matrixColumns = matrix[0].length;

        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixColumns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("*********************************");
    }

    static public int[][] copyMatrix(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();;
        }
        return copy;
    }
}
