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
public class Puzzle {

    /**
     * @param args the command line arguments
     */
    
    private State startState;
    private int[][] target;
    
    public static void main(String[] args) {
        // TODO code application logic here
    }

    void initializeTargetState() {
        
        //the empty place is represented using 0
        target = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
        };
    }
    
    void initializeStartState() {
        int[][] start = new int[][]{
            {6, 2, 3, 4},
            {5, 1, 7, 8},
            {9, 10, 0, 12},
            {13, 14, 15, 11}
        };
        
        int h = calculateManhattanDist(start);
        int g = 0;
        int f = g + h;
        
        int [] position = searchInMatrix(start, 0);
        int emptyPlacei = position[0];
        int emptyPlacej = position[1];
        
        startState = new State(start, h, g, f, emptyPlacei, emptyPlacej);
    }

    private int calculateManhattanDist(int[][] matrix) {
        int manhattanDist = 0;
        
        //all rows have same length
        int matrixRows = matrix.length;
        int matrixColumns = matrix[0].length;
        
        for(int i = 0; i < matrixRows; i++) {
            for(int j = 0; j < matrixColumns; j++) {
                if(matrix[i][j] != 0) {
                    int[] position = searchInMatrix(target, matrix[i][j]);
                    manhattanDist += Math.abs(position[0] - i) + Math.abs(position[1] - j);
                }
            }
        }
        
        return manhattanDist;
    }
    
    private int[] searchInMatrix(int[][] matrix, int item) {
        int[] position = new int [2];
        
        //all rows have same length
        int matrixRows = matrix.length;
        int matrixColumns = matrix[0].length;

        for(int i = 0; i < matrixRows; i++) {
            for(int j = 0; j < matrixColumns; j++) {
                if(item == matrix[i][j]) {
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }
        return null;
    }
}
