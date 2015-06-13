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
 * Represents a mathematical ordered sextuple of objects.
 * The order in which the objects appear in the sextuple is significant:
 * the ordered sextuple {@code (a, b, c, d, e, f)} is different from the ordered
 * sextuple {@code (b, a, c, d, e, f)} unless {@code a} and {@code b} are equal.
 * 
 * @author Benjamim Sonntag <benjamimsonntag@gmail.com>
 * @param <A> the type of the first element of the sextuple
 * @param <B> the type of the second element of the sextuple
 * @param <C> the type of the third element of the sextuple
 * @param <D> the type of the fourth element of the sextuple
 * @param <E> the type of the fifth element of the sextuple
 * @param <F> the type of the sixth element of the sextuple
 */
public final class Sextuple<A, B, C, D, E, F> extends AbstractTuple {
    private static final int ARITY = 6;

    private final A first;
    private final B second;
    private final C third;
    private final D fourth;
    private final E fifth;
    private final F sixth;

    /**
     * Returns a new sextuple of {@code (null, null, null, null, null, null)}.
     */
    public Sextuple() {
        this(null, null, null, null, null, null);
    }

    /**
     * Returns a new ordered sextuple, containing the given objects.
     * @param first the first member of the ordered sextuple
     * @param second the second member of the ordered sextuple
     * @param third the third member of the ordered sextuple
     * @param fourth the fourth member of the ordered sextuple
     * @param fifth the fifth member of the ordered sextuple
     * @param sixth the sixth member of the ordered sextuple
     */
    public Sextuple(A first, B second, C third, D fourth, E fifth, F sixth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
    }

    
    /**
     * Returns the first member of this ordered sextuple.
     * @return the first member of the sextuple
     */
    public A first() {
        return first;
    }
    
    /**
     * Returns the second member of this ordered sextuple.
     * @return the second member of the sextuple
     */
    public B second() {
        return second;
    }
    
    /**
     * Returns the third member of this ordered sextuple.
     * @return the third member of the sextuple
     */
    public C third() {
        return third;
    }
    
    /**
     * Returns the fourth member of this ordered sextuple.
     * @return the fourth member of the sextuple
     */
    public D fourth() {
        return fourth;
    }
    
    /**
     * Returns the fifth member of this ordered sextuple.
     * @return the fifth member of the sextuple
     */
    public E fifth() {
        return fifth;
    }
    
    /**
     * Returns the sixth member of this ordered sextuple.
     * @return the sixth member of the sextuple
     */
    public F sixth() {
        return sixth;
    }

    /**
     * Returns the constant {@code 6}.
     * The arity of a sextuple is defined to be 6.
     * @return the constant 6
     */
    @Override
    public int arity() {
        return ARITY;
    }

    @Override
    public Sextuple<F, E, D, C, B, A> invert() {
        return new Sextuple<>(sixth(), fifth(), fourth(),
                third(), second(), first());
    }

    @Override
    public Sextuple<B, C, D, E, F, A> shiftLeft() {
        return new Sextuple<>(second(), third(), fourth(),
                fifth(), sixth(), first());
    }

    @Override
    public Sextuple<F, A, B, C, D, E> shiftRight() {
        return new Sextuple<>(sixth(), first(), second(),
                third(), fourth(), fifth());
    }

    @Override
    public Object[] toArray() {
        return new Object[] {
            first(), second(), third(), fourth(), fifth(), sixth()
        };
    }


    /**
     * Returns a new sextuple, transforming the first member of this
     * sextuple.
     * The first member of the new sextuple is the result of applying the
     * given function to the first member of this sextuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the first member
     * @return a sextuple with the result of the function as the first member
     */
    public <R> Sextuple<R, B, C, D, E, F> applyFirst(Function<A, R> function) {
        return new Sextuple<>(function.apply(first()),
                second(), third(), fourth(), fifth(), sixth());
    }

    /**
     * Returns a new sextuple, transforming the second member of this
     * sextuple.
     * The second member of the new sextuple is the result of applying the
     * given function to the second member of this sextuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the second member
     * @return a sextuple with the result of the function as the second member
     */
    public <R> Sextuple<A, R, C, D, E, F> applySecond(Function<B, R> function) {
        return new Sextuple<>(first(), function.apply(second()),
                third(), fourth(), fifth(), sixth());
    }

    /**
     * Returns a new sextuple, transforming the third member of this
     * sextuple.
     * The third member of the new sextuple is the result of applying the
     * given function to the third member of this sextuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the third member
     * @return a sextuple with the result of the function as the third member
     */
    public <R> Sextuple<A, B, R, D, E, F> applyThird(Function<C, R> function) {
        return new Sextuple<>(first(), second(), function.apply(third()),
                fourth(), fifth(), sixth());
    }

    /**
     * Returns a new sextuple, transforming the fourth member of this
     * sextuple.
     * The fourth member of the new sextuple is the result of applying the
     * given function to the fourth member of this sextuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the fourth member
     * @return a sextuple with the result of the function as the fourth member
     */
    public <R> Sextuple<A, B, C, R, E, F> applyFourth(Function<D, R> function) {
        return new Sextuple<>(first(), second(), third(),
                function.apply(fourth()), fifth(), sixth());
    }

    /**
     * Returns a new sextuple, transforming the fifth member of this
     * sextuple.
     * The fifth member of the new sextuple is the result of applying the
     * given function to the fifth member of this sextuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the fifth member
     * @return a sextuple with the result of the function as the fifth member
     */
    public <R> Sextuple<A, B, C, D, R, F> applyFifth(Function<E, R> function) {
        return new Sextuple<>(first(), second(), third(), fourth(),
                function.apply(fifth()), sixth());
    }

    /**
     * Returns a new sextuple, transforming the sixth member of this
     * sextuple.
     * The sixth member of the new sextuple is the result of applying the
     * given function to the sixth member of this sextuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the sixth member
     * @return a sextuple with the result of the function as the sixth member
     */
    public <R> Sextuple<A, B, C, D, E, R> applySixth(Function<F, R> function) {
        return new Sextuple<>(first(), second(), third(), fourth(), fifth(),
                function.apply(sixth()));
    }
}
