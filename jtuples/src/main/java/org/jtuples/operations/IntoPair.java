/*
 * Copyright (c) 2015 git-afsantos
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
     * @return a triple that is equal to this pair extended with the
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
    public <C, D, E> Quintuple<A, B, C, D, E> append(Triple<C, D, E> triple) {
        return new Quintuple<>(getPair().first(), getPair().second(),
                triple.first(), triple.second(), triple.third());
    }

    /**
     * Extends this pair with the specified quadruple.
     * @param quadruple a quadruple to append to this pair
     * @return a sextuple that is equal to this pair appended with the
     *         specified quadruple
     */
    public <C, D, E, F> Sextuple<A, B, C, D, E, F> append(Quadruple<C, D, E, F> quadruple) {
        return new Sextuple<>(getPair().first(), getPair().second(),
                quadruple.first(), quadruple.second(), quadruple.third(), quadruple.fourth());
    }


    private Pair<A, B> getPair() {
        return pair;
    }
}
