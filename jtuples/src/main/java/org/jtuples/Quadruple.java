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
 * Represents a mathematical ordered quadruple of objects.
 * The order in which the objects appear in the quadruple is significant:
 * the ordered quadruple {@code (a, b, c, d)} is different from the ordered
 * quadruple {@code (b, a, c, d)} unless {@code a} and {@code b} are equal.
 * 
 * @author Benjamim Sonntag <benjamimsonntag@gmail.com>
 * @param <A> the type of the first element of the quadruple
 * @param <B> the type of the second element of the quadruple
 * @param <C> the type of the third element of the quadruple
 * @param <D> the type of the fourth element of the quadruple
 */
public class Quadruple<A, B, C, D> extends AbstractTuple {
    private static final int ARITY = 4;

    private final A first;
    private final B second;
    private final C third;
    private final D fourth;

    /**
     * Returns a new quadruple of {@code (null, null, null, null)}.
     */
    public Quadruple() {
        this(null, null, null, null);
    }

    /**
     * Returns a new ordered quadruple, containing the given objects.
     * @param first the first member of the ordered quadruple
     * @param second the second member of the ordered quadruple
     * @param third the third member of the ordered quadruple
     * @param fourth the fourth member of the ordered quadruple
     */
    public Quadruple(A first, B second, C third, D fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }


    /**
     * Returns the first member of this ordered quadruple.
     * @return the first member of the quadruple
     */
    public A first() {
        return first;
    }

    /**
     * Returns the second member of this ordered quadruple.
     * @return the second member of the quadruple
     */
    public B second() {
        return second;
    }

    /**
     * Returns the third member of this ordered quadruple.
     * @return the third member of the quadruple
     */
    public C third() {
        return third;
    }

    /**
     * Returns the fourth member of this ordered quadruple.
     * @return the fourth member of the quadruple
     */
    public D fourth() {
        return fourth;
    }
    
    /**
     * Returns the constant {@code 4}.
     * The arity of a quadruple is defined to be 4.
     * @return the constant 4
     */
    @Override
    public int arity() {
        return ARITY;
    }

    @Override
    public Quadruple<D, C, B, A> invert() {
        return new Quadruple<>(fourth, third, second, first);
    }

    @Override
    public Quadruple<B, C, D, A> shiftLeft() {
        return shiftLeft(first);
    }

    @Override
    public <V> Quadruple<B, C, D, V> shiftLeft(V value) {
        return new Quadruple<>(second, third, fourth, value);
    }

    @Override
    public Quadruple<D, A, B, C> shiftRight() {
        return shiftRight(fourth);
    }

    @Override
    public <V> Quadruple<V, A, B, C> shiftRight(V value) {
        return new Quadruple<>(value, first, second, third);
    }

    
    @Override
    public Object[] toArray() {
        return new Object[]{
            first, second, third, fourth
        };
    }


    /**
     * Returns a new quadruple, transforming the first member of this quadruple.
     * The first member of the new quadruple is the result of applying the given
     * function to the first member of this quadruple.
     * The second, third and fourth members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the first member
     * @return a quadruple with the result of function as the first member
     */
    public <R> Quadruple<R, B, C, D> applyFirst(Function<A, R> function) {
        return new Quadruple<>(function.apply(first), second, third, fourth);
    }

    /**
     * Returns a new quadruple, transforming the second member of this
     * quadruple.
     * The second member of the new quadruple is the result of applying the
     * given function to the second member of this quadruple.
     * The first, third and fourth members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the second member
     * @return a quadruple with the result of function as the second member
     */
    public <R> Quadruple<A, R, C, D> applySecond(Function<B, R> function) {
        return new Quadruple<>(first, function.apply(second), third, fourth);
    }

    /**
     * Returns a new quadruple, transforming the third member of this quadruple.
     * The third member of the new quadruple is the result of applying the given
     * function to the third member of this quadruple.
     * The first, second and fourth members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the third member
     * @return a quadruple with the result of function as the third member
     */
    public <R> Quadruple<A, B, R, D> applyThird(Function<C, R> function) {
        return new Quadruple<>(first, second, function.apply(third), fourth);
    }

    /**
     * Returns a new quadruple, transforming the fourth member of this quadruple.
     * The fourth member of the new quadruple is the result of applying the given
     * function to the fourth member of this quadruple.
     * The first, second and third members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the fourth member
     * @return a quadruple with the result of function as the fourth member
     */
    public <R> Quadruple<A, B, C, R> applyFourth(Function<D, R> function) {
        return new Quadruple<>(first, second, third, function.apply(fourth));
    }
    
}
