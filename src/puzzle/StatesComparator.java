/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import java.util.Comparator;

/**
 *
 * @author Rana
 */
public class StatesComparator implements Comparator<State> {

    @Override
    public int compare(State s1, State s2) {
        if (s1.getF() > s2.getF()) {
            return 1;
        } else if (s1.getF() < s2.getF()) {
            return -1;
        }
        return 0;
    }
}
