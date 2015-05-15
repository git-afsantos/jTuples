/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jtuples.operations;

import org.jtuples.*;

/**
 *
 * @author Benjamim Sonntag <benjamimsonntag@gmail.com>
 * @param <A> the type of the first element of the pair
 * @param <B> the type of the second element of the pair
 */
public final class IntoPair<A, B> {
    /**
     * Creates an extender for the specified pair.
     * @param pair a pair to extend
     * @return an extender for the specified pair
     */
    public static <A, B> IntoPair<A, B> into(Pair<A, B> pair) {
        return new IntoPair<>(pair);
    }
    
    private final Pair<A, B> pair;
    
    private IntoPair(Pair<A, B> pair) {
        this.pair = pair;
    }

    /**
     * Extends this pair with the specified value.
     * @param value a value to append to this pair
     * @return a triple that is equal to this pair appended with the
     *         specified value
     */
    public <T> Triple<A, B, T> put(T value) {
        return new Triple<>(getPair().first(), getPair().second(), value);
    }

    /**
     * Extends this pair with the specified pair.
     * @param pair a pair to append to this pair
     * @return a quadruple that is equal to this pair appended with the
     *         specified pair
     */
    public <C, D> Quadruple<A, B, C, D> append(Pair<C, D> pair) {
        return new Quadruple<>(getPair().first(), getPair().second(),
                pair.first(), pair.second());
    }

    /**
     * Extends this pair with the specified triple.
     * @param triple a triple to append to this pair
     * @return a quintuple that is equal to this pair appended with the
     *         specified triple
     */
    public <C, D, E> Tuple append(Triple<C, D, E> triple) {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Extends this pair with the specified quadruple.
     * @param quadruple a quadruple to append to this pair
     * @return a sextuple that is equal to this pair appended with the
     *         specified quadruple
     */
    public <C, D, E, F> Tuple append(Quadruple<C, D, E, F> quadruple) {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private Pair<A, B> getPair() {
        return pair;
    }
}
