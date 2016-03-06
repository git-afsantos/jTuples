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
 * Represents a mathematical ordered nonuple of objects.
 * The order in which the objects appear in the nonuple is significant:
 * the ordered nonuple {@code (a, b, c, d, e, f, g, h, i)} is different from the
 * ordered nonuple {@code (b, a, c, d, e, f, g, h, i)} unless
 * {@code a} and {@code b} are equal.
 * 
 * @author Andre Santos
 * @param <A> the type of the first element of the nonuple
 * @param <B> the type of the second element of the nonuple
 * @param <C> the type of the third element of the nonuple
 * @param <D> the type of the fourth element of the nonuple
 * @param <E> the type of the fifth element of the nonuple
 * @param <F> the type of the sixth element of the nonuple
 * @param <G> the type of the seventh element of the nonuple
 * @param <H> the type of the eighth element of the nonuple
 * @param <I> the type of the ninth element of the nonuple
 */
public final class Nonuple<A, B, C, D, E, F, G, H, I> extends AbstractTuple {
    private static final int ARITY = 9;

    private final A first;
    private final B second;
    private final C third;
    private final D fourth;
    private final E fifth;
    private final F sixth;
    private final G seventh;
    private final H eighth;
    private final I ninth;

    /**
     * Returns a new nonuple of
     * {@code (null, null, null, null, null, null, null, null, null)}.
     */
    public Nonuple() {
        this(null, null, null, null, null, null, null, null, null);
    }

    /**
     * Returns a new ordered nonuple, containing the given objects.
     * @param first the first member of the ordered nonuple
     * @param second the second member of the ordered nonuple
     * @param third the third member of the ordered nonuple
     * @param fourth the fourth member of the ordered nonuple
     * @param fifth the fifth member of the ordered nonuple
     * @param sixth the sixth member of the ordered nonuple
     * @param seventh the seventh member of the ordered nonuple
     * @param eighth the eighth member of the ordered nonuple
     * @param ninth the ninth member of the ordered nonuple
     */
    public Nonuple(A first, B second, C third, D fourth,
            E fifth, F sixth, G seventh, H eighth, I ninth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.seventh = seventh;
        this.eighth = eighth;
        this.ninth = ninth;
    }

    
    /**
     * Returns the first member of this ordered nonuple.
     * @return the first member of the nonuple
     */
    public A first() {
        return first;
    }
    
    /**
     * Returns the second member of this ordered nonuple.
     * @return the second member of the nonuple
     */
    public B second() {
        return second;
    }
    
    /**
     * Returns the third member of this ordered nonuple.
     * @return the third member of the nonuple
     */
    public C third() {
        return third;
    }
    
    /**
     * Returns the fourth member of this ordered nonuple.
     * @return the fourth member of the nonuple
     */
    public D fourth() {
        return fourth;
    }
    
    /**
     * Returns the fifth member of this ordered nonuple.
     * @return the fifth member of the nonuple
     */
    public E fifth() {
        return fifth;
    }
    
    /**
     * Returns the sixth member of this ordered nonuple.
     * @return the sixth member of the nonuple
     */
    public F sixth() {
        return sixth;
    }
    
    /**
     * Returns the seventh member of this ordered nonuple.
     * @return the seventh member of the nonuple
     */
    public G seventh() {
        return seventh;
    }
    
    /**
     * Returns the eighth member of this ordered nonuple.
     * @return the eighth member of the nonuple
     */
    public H eighth() {
        return eighth;
    }
    
    /**
     * Returns the ninth member of this ordered nonuple.
     * @return the ninth member of the nonuple
     */
    public I ninth() {
        return ninth;
    }

    /**
     * Returns the constant {@code 9}.
     * The arity of a nonuple is defined to be 9.
     * @return the constant 9
     */
    @Override
    public int arity() {
        return ARITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Nonuple<I, H, G, F, E, D, C, B, A> invert() {
        return new Nonuple<>(ninth, eighth, seventh, sixth, fifth, fourth,
                third, second, first);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Nonuple<B, C, D, E, F, G, H, I, A> shiftLeft() {
        return shiftLeft(first);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> Nonuple<B, C, D, E, F, G, H, I, V> shiftLeft(V value) {
        return new Nonuple<>(second, third, fourth,
                fifth, sixth, seventh, eighth, ninth, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Nonuple<I, A, B, C, D, E, F, G, H> shiftRight() {
        return shiftRight(ninth);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> Nonuple<V, A, B, C, D, E, F, G, H> shiftRight(V value) {
        return new Nonuple<>(value, first, second,
                third, fourth, fifth, sixth, seventh, eighth);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        return new Object[] {
            first, second, third, fourth, fifth, sixth, seventh, eighth, ninth
        };
    }


    /**
     * Returns a new nonuple, transforming the first member of this
     * nonuple.
     * The first member of the new nonuple is the result of applying the
     * given function to the first member of this nonuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the first member
     * @return a nonuple with the result of the function as the first member
     */
    public <R> Nonuple<R, B, C, D, E, F, G, H, I> applyFirst(
            Function<A, R> function) {
        return new Nonuple<>(function.apply(first),
                second, third, fourth, fifth, sixth, seventh, eighth, ninth);
    }

    /**
     * Returns a new nonuple, transforming the second member of this
     * nonuple.
     * The second member of the new nonuple is the result of applying the
     * given function to the second member of this nonuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the second member
     * @return a nonuple with the result of the function as the second member
     */
    public <R> Nonuple<A, R, C, D, E, F, G, H, I> applySecond(
            Function<B, R> function) {
        return new Nonuple<>(first, function.apply(second),
                third, fourth, fifth, sixth, seventh, eighth, ninth);
    }

    /**
     * Returns a new nonuple, transforming the third member of this
     * nonuple.
     * The third member of the new nonuple is the result of applying the
     * given function to the third member of this nonuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the third member
     * @return a nonuple with the result of the function as the third member
     */
    public <R> Nonuple<A, B, R, D, E, F, G, H, I> applyThird(
            Function<C, R> function) {
        return new Nonuple<>(first, second, function.apply(third),
                fourth, fifth, sixth, seventh, eighth, ninth);
    }

    /**
     * Returns a new nonuple, transforming the fourth member of this
     * nonuple.
     * The fourth member of the new nonuple is the result of applying the
     * given function to the fourth member of this nonuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the fourth member
     * @return a nonuple with the result of the function as the fourth member
     */
    public <R> Nonuple<A, B, C, R, E, F, G, H, I> applyFourth(
            Function<D, R> function) {
        return new Nonuple<>(first, second, third,
                function.apply(fourth), fifth, sixth, seventh, eighth, ninth);
    }

    /**
     * Returns a new nonuple, transforming the fifth member of this
     * nonuple.
     * The fifth member of the new nonuple is the result of applying the
     * given function to the fifth member of this nonuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the fifth member
     * @return a nonuple with the result of the function as the fifth member
     */
    public <R> Nonuple<A, B, C, D, R, F, G, H, I> applyFifth(
            Function<E, R> function) {
        return new Nonuple<>(first, second, third, fourth,
                function.apply(fifth), sixth, seventh, eighth, ninth);
    }

    /**
     * Returns a new nonuple, transforming the sixth member of this
     * nonuple.
     * The sixth member of the new nonuple is the result of applying the
     * given function to the sixth member of this nonuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the sixth member
     * @return a nonuple with the result of the function as the sixth member
     */
    public <R> Nonuple<A, B, C, D, E, R, G, H, I> applySixth(
            Function<F, R> function) {
        return new Nonuple<>(first, second, third, fourth, fifth,
                function.apply(sixth), seventh, eighth, ninth);
    }

    /**
     * Returns a new nonuple, transforming the seventh member of this
     * nonuple.
     * The seventh member of the new nonuple is the result of applying the
     * given function to the seventh member of this nonuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the seventh member
     * @return a nonuple with the result of the function as the seventh member
     */
    public <R> Nonuple<A, B, C, D, E, F, R, H, I> applySeventh(
            Function<G, R> function) {
        return new Nonuple<>(first, second, third, fourth, fifth, sixth,
                function.apply(seventh), eighth, ninth);
    }

    /**
     * Returns a new nonuple, transforming the eighth member of this
     * nonuple.
     * The eighth member of the new nonuple is the result of applying the
     * given function to the eighth member of this nonuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the eighth member
     * @return a nonuple with the result of the function as the eighth member
     */
    public <R> Nonuple<A, B, C, D, E, F, G, R, I> applyEighth(
            Function<H, R> function) {
        return new Nonuple<>(first, second, third, fourth, fifth, sixth,
                seventh, function.apply(eighth), ninth);
    }

    /**
     * Returns a new nonuple, transforming the ninth member of this
     * nonuple.
     * The ninth member of the new nonuple is the result of applying the
     * given function to the ninth member of this nonuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the ninth member
     * @return a nonuple with the result of the function as the ninth member
     */
    public <R> Nonuple<A, B, C, D, E, F, G, H, R> applyNinth(
            Function<I, R> function) {
        return new Nonuple<>(first, second, third, fourth, fifth, sixth,
                seventh, eighth, function.apply(ninth));
    }
}
