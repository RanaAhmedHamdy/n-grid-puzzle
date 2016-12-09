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
    private int emptyPlacei;
    private int emptyPlacej;

    public State(int[][] puzzleState, int h, int g, int f, int emptyPlacei, int emptyPlacej) {
        this.puzzleState = puzzleState;
        this.h = h;
        this.g = g;
        this.f = f;
        this.emptyPlacei = emptyPlacei;
        this.emptyPlacej = emptyPlacej;
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

    public int getEmptyPlacei() {
        return emptyPlacei;
    }

    public void setEmptyPlacei(int emptyPlacei) {
        this.emptyPlacei = emptyPlacei;
    }

    public int getEmptyPlacej() {
        return emptyPlacej;
    }

    public void setEmptyPlacej(int emptyPlacej) {
        this.emptyPlacej = emptyPlacej;
    }
}
