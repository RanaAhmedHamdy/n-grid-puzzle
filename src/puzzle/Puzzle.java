/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Rana
 */
public class Puzzle {

    /**
     * @param args the command line arguments
     */
    private static State startState;
    private static int[][] target;

    public static void main(String[] args) {
        initializeTargetState();
        initializeStartState();
        findSolutionUsingAStar();

    }

    static void findSolutionUsingAStar() {
        List<State> queue = new ArrayList<State>();
        queue.add(startState);

        while (!queue.isEmpty()) {
            //get first state in queue (has least F)
            State state = queue.remove(0);

            System.out.println("Parent");
            System.out.println("f = " + state.getF());
            Utils.printMatrix(state.getPuzzleState());

            //chech if it is the target state
            //if yes return else find all its children
            //push chldren in q
            if (calculateManhattanDist(state.getPuzzleState(), target) == 0) {
                //we reach target
                System.out.println("solution found");
                return;
            } else {
                //all rows have same length
                int[][] matrix = state.getPuzzleState();
                int matrixRows = matrix.length;
                int matrixColumns = matrix[0].length;
                
                int emptyPlacei = state.getemptyPlacePosition().getI();
                int emptyPlacej = state.getemptyPlacePosition().getJ();

                MatrixPosition parentPosition = state.getParentEmptyPlacePosition();

                //System.out.println("Children");
                if (emptyPlacei + 1 < matrixColumns && (emptyPlacei + 1 != parentPosition.getI())) {
                    MatrixPosition newEmptyPlacePosition = new MatrixPosition(emptyPlacei + 1, emptyPlacej);
                    queue.add(createNewState(state, newEmptyPlacePosition));
                }
                if (emptyPlacei - 1 > -1 && (emptyPlacei - 1 != parentPosition.getI())) {                   
                    MatrixPosition newEmptyPlacePosition = new MatrixPosition(emptyPlacei - 1, emptyPlacej);
                    queue.add(createNewState(state, newEmptyPlacePosition));
                }
                if (emptyPlacej + 1 < matrixRows && (emptyPlacej + 1 != parentPosition.getJ())) {                   
                    MatrixPosition newEmptyPlacePosition = new MatrixPosition(emptyPlacei, emptyPlacej + 1);
                    queue.add(createNewState(state, newEmptyPlacePosition));
                }
                if (emptyPlacej - 1 > -1 && (emptyPlacej - 1 != parentPosition.getJ())) {
                    MatrixPosition newEmptyPlacePosition = new MatrixPosition(emptyPlacei, emptyPlacej - 1);
                    queue.add(createNewState(state, newEmptyPlacePosition));
                }
            }

            //sort queue
            Collections.sort(queue, new StatesComparator());
        }
    }

    static void initializeTargetState() {

        //the empty place is represented using 0
        target = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
        };
    }

    static void initializeStartState() {
        int[][] start = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {0, 14, 15, 13}
        };

        int h = calculateManhattanDist(start, target);
        int g = 0;
        int f = g + h;

        MatrixPosition position = Utils.searchInMatrix(start, 0);
        MatrixPosition parent = new MatrixPosition(-1, -1);

        startState = new State(start, h, g, f, position, parent);
    }

    static private int calculateManhattanDist(int[][] matrix, int[][] targetMatrix) {
        int manhattanDist = 0;

        //all rows have same length
        int matrixRows = matrix.length;
        int matrixColumns = matrix[0].length;

        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixColumns; j++) {
                if (matrix[i][j] != 0) {
                    MatrixPosition position = Utils.searchInMatrix(targetMatrix, matrix[i][j]);
                    manhattanDist += Math.abs(position.getI() - i) + Math.abs(position.getJ() - j);
                }
            }
        }

        return manhattanDist;
    }

    static private State createNewState(State state, MatrixPosition newPosition) {
        int[][] newMatrix = Utils.copyMatrix(state.getPuzzleState());
        
        MatrixPosition emptyPosition = state.getemptyPlacePosition();
        int emptyPlacei = state.getemptyPlacePosition().getI();
        int emptyPlacej = state.getemptyPlacePosition().getJ();
        int g = state.getG();
        
        int temp = newMatrix[newPosition.getI()][newPosition.getJ()];
        newMatrix[newPosition.getI()][newPosition.getJ()] = 0;
        newMatrix[emptyPlacei][emptyPlacej] = temp;

        int h = calculateManhattanDist(newMatrix, target);
        int f = h + g + 1; //new g is g + 1

        State newState = new State(newMatrix, h, g + 1, f, newPosition, emptyPosition);

        System.out.println("f = " + f);
        Utils.printMatrix(newMatrix);
        
        return newState;
    }
}
