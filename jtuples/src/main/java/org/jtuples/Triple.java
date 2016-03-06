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

import java.util.function.Function;

/**
 * Represents a mathematical ordered triple of objects.
 * The order in which the objects appear in the triple is significant:
 * the ordered triple {@code (a, b, c)} is different from the ordered triple
 * {@code (b, a, c)} unless {@code a} and {@code b} are equal.
 *
 * @author Andre Santos
 * @param <A> the type of the first element of the triple
 * @param <B> the type of the second element of the triple
 * @param <C> the type of the third element of the triple
 */
public final class Triple<A, B, C> extends AbstractTuple {
    private static final int ARITY = 3;

    private final A first;
    private final B second;
    private final C third;

    /**
     * Returns a new triple of {@code (null, null, null)}.
     */
    public Triple() {
        this(null, null, null);
    }

    /**
     * Returns a new ordered triple, containing the given objects.
     * @param first the first member of the ordered triple
     * @param second the second member of the ordered triple
     * @param third the third member of the ordered triple
     */
    public Triple(A first, B second, C third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }


    /**
     * Returns the first member of this ordered triple.
     * @return the first member of the triple
     */
    public A first() {
        return first;
    }

    /**
     * Returns the second member of this ordered triple.
     * @return the second member of the triple
     */
    public B second() {
        return second;
    }

    /**
     * Returns the third member of this ordered triple.
     * @return the third member of the triple
     */
    public C third() {
        return third;
    }

    /**
     * Returns the constant {@code 3}.
     * The arity of a triple is defined to be 3.
     * @return the constant 3
     */
    @Override
    public final int arity() {
        return ARITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Triple<C, B, A> invert() {
        return new Triple<>(third, second, first);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Triple<B, C, A> shiftLeft() {
        return shiftLeft(first);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> Triple<B, C, V> shiftLeft(V value) {
        return new Triple<>(second, third, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Triple<C, A, B> shiftRight() {
        return shiftRight(third);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> Triple<V, A, B> shiftRight(V value) {
        return new Triple<>(value, first, second);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        return new Object[]{
            first, second, third
        };
    }


    /**
     * Returns a new triple, transforming the first member of this triple.
     * The first member of the new triple is the result of applying the given
     * function to the first member of this triple.
     * The second and third members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the first member
     * @return a triple with the result of function as the first member
     */
    public <R> Triple<R, B, C> applyFirst(Function<A, R> function) {
        return new Triple<>(function.apply(first), second, third);
    }

    /**
     * Returns a new triple, transforming the second member of this triple.
     * The second member of the new triple is the result of applying the given
     * function to the second member of this triple.
     * The first and third members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the second member
     * @return a triple with the result of function as the second member
     */
    public <R> Triple<A, R, C> applySecond(Function<B, R> function) {
        return new Triple<>(first, function.apply(second), third);
    }

    /**
     * Returns a new triple, transforming the third member of this triple.
     * The third member of the new triple is the result of applying the given
     * function to the third member of this triple.
     * The first and second members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the third member
     * @return a triple with the result of function as the third member
     */
    public <R> Triple<A, B, R> applyThird(Function<C, R> function) {
        return new Triple<>(first, second, function.apply(third));
    }
}
