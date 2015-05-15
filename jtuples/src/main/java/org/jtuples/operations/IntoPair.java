/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jtuples.operations;

import org.jtuples.*;

/**
 *
 * @author Benjamim Sonntag
 * @param <A>
 * @param <B>
 */
public class IntoPair<A, B> {
    private Pair<A, B> pair;

    public <T> Triple<A, B, T> put(T value) {
        return new Triple<>(pair.first(), pair.second(), value);
    }

    public <C, D> Tuple put(Pair<C, D> pair) {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public <C, D, E> Tuple put(Triple<C, D, E> triple) {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
