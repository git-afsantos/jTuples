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
package org.jtuples;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Represents a mathematical ordered pair of objects.
 * The order in which the objects appear in the pair is significant:
 * the ordered pair {@code (a, b)} is different from the ordered pair
 * {@code (b, a)} unless {@code a} and {@code b} are equal.
 *
 * @author Andre Santos
 * @param <A> the type of the first element of the pair
 * @param <B> the type of the second element of the pair
 */
public final class Pair<A, B> extends AbstractTuple {
    private static final int ARITY = 2;

    private final A first;
    private final B second;

    /**
     * Returns a new pair of {@code (null, null)}.
     */
    public Pair() {
        this(null, null);
    }

    /**
     * Returns a new ordered pair, containing the given objects.
     * @param first the first member of the ordered pair
     * @param second the second member of the ordered pair
     */
    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }


    /**
     * Returns the first member of this ordered pair.
     * @return the first member of the pair
     */
    public A first() {
        return first;
    }

    /**
     * Returns the second member of this ordered pair.
     * @return the second member of the pair
     */
    public B second() {
        return second;
    }

    /**
     * Returns the constant {@code 2}.
     * The arity of a pair is defined to be 2.
     * @return the constant 2
     */
    @Override
    public final int arity() {
        return ARITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pair<B, A> invert() {
        return new Pair<>(second, first);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pair<B, A> shiftLeft() {
        return shiftLeft(first);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> Pair<B, V> shiftLeft(V value) {
        return new Pair<>(second, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pair<B, A> shiftRight() {
        return shiftRight(second);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> Pair<V, A> shiftRight(V value) {
        return new Pair<>(value, first);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        return new Object[]{
            first, second
        };
    }


    /**
     * Returns a new pair, transforming the first member of this pair.
     * The first member of the new pair is the result of applying the given
     * function to the first member of this pair.
     * The second member is preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the first member
     * @return a pair with the result of function as the first member
     */
    public <R> Pair<R, B> applyFirst(Function<A, R> function) {
        return new Pair<>(function.apply(first), second);
    }

    /**
     * Returns a new pair, transforming the second member of this pair.
     * The second member of the new pair is the result of applying the given
     * function to the second member of this pair.
     * The first member is preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the second member
     * @return a pair with the result of function as the second member
     */
    public <R> Pair<A, R> applySecond(Function<B, R> function) {
        return new Pair<>(first, function.apply(second));
    }

    /**
     * Returns the result of applying the given function to this pair.
     * @param <R> the type of the function's result
     * @param function the function used to transform this pair
     * @return the function's result
     */
    public <R> R apply(BiFunction<A, B, R> function) {
        return function.apply(first, second);
    }
}
