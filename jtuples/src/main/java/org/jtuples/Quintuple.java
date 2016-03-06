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
 * Represents a mathematical ordered quintuple of objects.
 * The order in which the objects appear in the quintuple is significant:
 * the ordered quintuple {@code (a, b, c, d, e)} is different from the ordered
 * quintuple {@code (b, a, c, d, e)} unless {@code a} and {@code b} are equal.
 * 
 * @author Benjamim Sonntag
 * @param <A> the type of the first element of the quintuple
 * @param <B> the type of the second element of the quintuple
 * @param <C> the type of the third element of the quintuple
 * @param <D> the type of the fourth element of the quintuple
 * @param <E> the type of the fifth element of the quintuple
 */
public final class Quintuple<A, B, C, D, E> extends AbstractTuple {
    private static final int ARITY = 5;

    private final A first;
    private final B second;
    private final C third;
    private final D fourth;
    private final E fifth;

    /**
     * Returns a new quintuple of {@code (null, null, null, null, null)}.
     */
    public Quintuple() {
        this(null, null, null, null, null);
    }

    /**
     * Returns a new ordered quintuple, containing the given objects.
     * @param first the first member of the ordered quintuple
     * @param second the second member of the ordered quintuple
     * @param third the third member of the ordered quintuple
     * @param fourth the fourth member of the ordered quintuple
     * @param fifth the fifth member of the ordered quintuple
     */
    public Quintuple(A first, B second, C third, D fourth, E fifth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
    }

    
    /**
     * Returns the first member of this ordered quintuple.
     * @return the first member of the quintuple
     */
    public A first() {
        return first;
    }
    
    /**
     * Returns the second member of this ordered quintuple.
     * @return the second member of the quintuple
     */
    public B second() {
        return second;
    }
    
    /**
     * Returns the third member of this ordered quintuple.
     * @return the third member of the quintuple
     */
    public C third() {
        return third;
    }
    
    /**
     * Returns the fourth member of this ordered quintuple.
     * @return the fourth member of the quintuple
     */
    public D fourth() {
        return fourth;
    }
    
    /**
     * Returns the fifth member of this ordered quintuple.
     * @return the fifth member of the quintuple
     */
    public E fifth() {
        return fifth;
    }

    /**
     * Returns the constant {@code 5}.
     * The arity of a quintuple is defined to be 5.
     * @return the constant 5
     */
    @Override
    public int arity() {
        return ARITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Quintuple<E, D, C, B, A> invert() {
        return new Quintuple<>(fifth(), fourth(), third(), second(), first());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Quintuple<B, C, D, E, A> shiftLeft() {
        return shiftLeft(first());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> Quintuple<B, C, D, E, V> shiftLeft(V value) {
        return new Quintuple<>(second(), third(), fourth(), fifth(), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Quintuple<E, A, B, C, D> shiftRight() {
        return shiftRight(fifth());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> Quintuple<V, A, B, C, D> shiftRight(V value) {
        return new Quintuple<>(value, first(), second(), third(), fourth());
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        return new Object[] {
            first(), second(), third(), fourth(), fifth()
        };
    }


    /**
     * Returns a new quintuple, transforming the first member of this
     * quintuple.
     * The first member of the new quintuple is the result of applying the
     * given function to the first member of this quintuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the first member
     * @return a quintuple with the result of the function as the first member
     */
    public <R> Quintuple<R, B, C, D, E> applyFirst(Function<A, R> function) {
        return new Quintuple<>(function.apply(first()),
                second(), third(), fourth(), fifth());
    }
    
    /**
     * Returns a new quintuple, transforming the second member of this
     * quintuple.
     * The second member of the new quintuple is the result of applying the
     * given function to the second member of this quintuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the first member
     * @return a quintuple with the result of the function as the second member
     */
    public <R> Quintuple<A, R, C, D, E> applySecond(Function<B, R> function) {
        return new Quintuple<>(first(), function.apply(second()),
                third(), fourth(), fifth());
    }
    
    /**
     * Returns a new quintuple, transforming the third member of this
     * quintuple.
     * The third member of the new quintuple is the result of applying the
     * given function to the third member of this quintuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the first member
     * @return a quintuple with the result of the function as the third member
     */
    public <R> Quintuple<A, B, R, D, E> applyThird(Function<C, R> function) {
        return new Quintuple<>(first(), second(), function.apply(third()),
                fourth(), fifth());
    }
    
    /**
     * Returns a new quintuple, transforming the fourth member of this
     * quintuple.
     * The fourth member of the new quintuple is the result of applying the
     * given function to the fourth member of this quintuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the first member
     * @return a quintuple with the result of the function as the fourth member
     */
    public <R> Quintuple<A, B, C, R, E> applyFourth(Function<D, R> function) {
        return new Quintuple<>(first(), second(), third(),
                function.apply(fourth()), fifth());
    }
    
    /**
     * Returns a new quintuple, transforming the fifth member of this
     * quintuple.
     * The fifth member of the new quintuple is the result of applying the
     * given function to the fifth member of this quintuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the first member
     * @return a quintuple with the result of the function as the fifth member
     */
    public <R> Quintuple<A, B, C, D, R> applyFifth(Function<E, R> function) {
        return new Quintuple<>(first(), second(), third(), fourth(),
                function.apply(fifth()));
    }
}
