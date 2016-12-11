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
class State {

    private int[][] puzzleState;
    private int h;
    private int g;
    private int f;
    private MatrixPosition emptyPlacePosition;
    private MatrixPosition parentEmptyPlacePosition;

    public State(int[][] puzzleState, int h, int g, int f, MatrixPosition emptyPlacePosition, MatrixPosition parentEmptyPlacePosition) {
        this.puzzleState = puzzleState;
        this.h = h;
        this.g = g;
        this.f = f;
        this.emptyPlacePosition = emptyPlacePosition;
        this.parentEmptyPlacePosition = parentEmptyPlacePosition;
    }

    public MatrixPosition getParentEmptyPlacePosition() {
        return parentEmptyPlacePosition;
    }

    public void setParentEmptyPlacePosition(MatrixPosition parentEmptyPlacePosition) {
        this.parentEmptyPlacePosition = parentEmptyPlacePosition;
    }

    public int[][] getPuzzleState() {
        return puzzleState;
    }

    public void setPuzzleState(int[][] puzzleState) {
        this.puzzleState = puzzleState;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public MatrixPosition getemptyPlacePosition() {
        return emptyPlacePosition;
    }

    public void setemptyPlacePosition(MatrixPosition emptyPlacePosition) {
        this.emptyPlacePosition = emptyPlacePosition;
    }
}
