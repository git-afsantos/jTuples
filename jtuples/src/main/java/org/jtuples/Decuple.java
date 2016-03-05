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
 * Represents a mathematical ordered decuple of objects.
 * The order in which the objects appear in the decuple is significant:
 * the ordered decuple {@code (a, b, c, d, e, f, g, h, i, j)} is different from
 * the ordered decuple {@code (b, a, c, d, e, f, g, h, i, j)} unless
 * {@code a} and {@code b} are equal.
 * 
 * @author Andre Santos <contact.andre.santos@gmail.com>
 * @param <A> the type of the first element of the decuple
 * @param <B> the type of the second element of the decuple
 * @param <C> the type of the third element of the decuple
 * @param <D> the type of the fourth element of the decuple
 * @param <E> the type of the fifth element of the decuple
 * @param <F> the type of the sixth element of the decuple
 * @param <G> the type of the seventh element of the decuple
 * @param <H> the type of the eighth element of the decuple
 * @param <I> the type of the ninth element of the decuple
 * @param <J> the type of the tenth element of the decuple
 */
public final class Decuple<A, B, C, D, E, F, G, H, I, J> extends AbstractTuple {
    private static final int ARITY = 10;

    private final A first;
    private final B second;
    private final C third;
    private final D fourth;
    private final E fifth;
    private final F sixth;
    private final G seventh;
    private final H eighth;
    private final I ninth;
    private final J tenth;

    /**
     * Returns a new decuple of
     * {@code (null, null, null, null, null, null, null, null, null, null)}.
     */
    public Decuple() {
        this(null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Returns a new ordered decuple, containing the given objects.
     * @param first the first member of the ordered decuple
     * @param second the second member of the ordered decuple
     * @param third the third member of the ordered decuple
     * @param fourth the fourth member of the ordered decuple
     * @param fifth the fifth member of the ordered decuple
     * @param sixth the sixth member of the ordered decuple
     * @param seventh the seventh member of the ordered decuple
     * @param eighth the eighth member of the ordered decuple
     * @param ninth the ninth member of the ordered decuple
     * @param tenth the tenth member of the ordered decuple
     */
    public Decuple(A first, B second, C third, D fourth,
            E fifth, F sixth, G seventh, H eighth, I ninth, J tenth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.seventh = seventh;
        this.eighth = eighth;
        this.ninth = ninth;
        this.tenth = tenth;
    }

    
    /**
     * Returns the first member of this ordered decuple.
     * @return the first member of the decuple
     */
    public A first() {
        return first;
    }
    
    /**
     * Returns the second member of this ordered decuple.
     * @return the second member of the decuple
     */
    public B second() {
        return second;
    }
    
    /**
     * Returns the third member of this ordered decuple.
     * @return the third member of the decuple
     */
    public C third() {
        return third;
    }
    
    /**
     * Returns the fourth member of this ordered decuple.
     * @return the fourth member of the decuple
     */
    public D fourth() {
        return fourth;
    }
    
    /**
     * Returns the fifth member of this ordered decuple.
     * @return the fifth member of the decuple
     */
    public E fifth() {
        return fifth;
    }
    
    /**
     * Returns the sixth member of this ordered decuple.
     * @return the sixth member of the decuple
     */
    public F sixth() {
        return sixth;
    }
    
    /**
     * Returns the seventh member of this ordered decuple.
     * @return the seventh member of the decuple
     */
    public G seventh() {
        return seventh;
    }
    
    /**
     * Returns the eighth member of this ordered decuple.
     * @return the eighth member of the decuple
     */
    public H eighth() {
        return eighth;
    }
    
    /**
     * Returns the ninth member of this ordered decuple.
     * @return the ninth member of the decuple
     */
    public I ninth() {
        return ninth;
    }
    
    /**
     * Returns the tenth member of this ordered decuple.
     * @return the tenth member of the decuple
     */
    public J tenth() {
        return tenth;
    }

    /**
     * Returns the constant {@code 10}.
     * The arity of a decuple is defined to be 10.
     * @return the constant 10
     */
    @Override
    public int arity() {
        return ARITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Decuple<J, I, H, G, F, E, D, C, B, A> invert() {
        return new Decuple<>(tenth, ninth, eighth, seventh, sixth, fifth,
                fourth, third, second, first);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Decuple<B, C, D, E, F, G, H, I, J, A> shiftLeft() {
        return shiftLeft(first);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> Decuple<B, C, D, E, F, G, H, I, J, V> shiftLeft(V value) {
        return new Decuple<>(second, third, fourth,
                fifth, sixth, seventh, eighth, ninth, tenth, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Decuple<J, A, B, C, D, E, F, G, H, I> shiftRight() {
        return shiftRight(tenth);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> Decuple<V, A, B, C, D, E, F, G, H, I> shiftRight(V value) {
        return new Decuple<>(value, first, second,
                third, fourth, fifth, sixth, seventh, eighth, ninth);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        return new Object[] {
            first, second, third, fourth, fifth,
            sixth, seventh, eighth, ninth, tenth
        };
    }


    /**
     * Returns a new decuple, transforming the first member of this
     * decuple.
     * The first member of the new decuple is the result of applying the
     * given function to the first member of this decuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the first member
     * @return a decuple with the result of the function as the first member
     */
    public <R> Decuple<R, B, C, D, E, F, G, H, I, J> applyFirst(
            Function<A, R> function) {
        return new Decuple<>(function.apply(first), second, third,
                fourth, fifth, sixth, seventh, eighth, ninth, tenth);
    }

    /**
     * Returns a new decuple, transforming the second member of this
     * decuple.
     * The second member of the new decuple is the result of applying the
     * given function to the second member of this decuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the second member
     * @return a decuple with the result of the function as the second member
     */
    public <R> Decuple<A, R, C, D, E, F, G, H, I, J> applySecond(
            Function<B, R> function) {
        return new Decuple<>(first, function.apply(second),
                third, fourth, fifth, sixth, seventh, eighth, ninth, tenth);
    }

    /**
     * Returns a new decuple, transforming the third member of this
     * decuple.
     * The third member of the new decuple is the result of applying the
     * given function to the third member of this decuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the third member
     * @return a decuple with the result of the function as the third member
     */
    public <R> Decuple<A, B, R, D, E, F, G, H, I, J> applyThird(
            Function<C, R> function) {
        return new Decuple<>(first, second, function.apply(third),
                fourth, fifth, sixth, seventh, eighth, ninth, tenth);
    }

    /**
     * Returns a new decuple, transforming the fourth member of this
     * decuple.
     * The fourth member of the new decuple is the result of applying the
     * given function to the fourth member of this decuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the fourth member
     * @return a decuple with the result of the function as the fourth member
     */
    public <R> Decuple<A, B, C, R, E, F, G, H, I, J> applyFourth(
            Function<D, R> function) {
        return new Decuple<>(first, second, third, function.apply(fourth),
                fifth, sixth, seventh, eighth, ninth, tenth);
    }

    /**
     * Returns a new decuple, transforming the fifth member of this
     * decuple.
     * The fifth member of the new decuple is the result of applying the
     * given function to the fifth member of this decuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the fifth member
     * @return a decuple with the result of the function as the fifth member
     */
    public <R> Decuple<A, B, C, D, R, F, G, H, I, J> applyFifth(
            Function<E, R> function) {
        return new Decuple<>(first, second, third, fourth,
                function.apply(fifth), sixth, seventh, eighth, ninth, tenth);
    }

    /**
     * Returns a new decuple, transforming the sixth member of this
     * decuple.
     * The sixth member of the new decuple is the result of applying the
     * given function to the sixth member of this decuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the sixth member
     * @return a decuple with the result of the function as the sixth member
     */
    public <R> Decuple<A, B, C, D, E, R, G, H, I, J> applySixth(
            Function<F, R> function) {
        return new Decuple<>(first, second, third, fourth, fifth,
                function.apply(sixth), seventh, eighth, ninth, tenth);
    }

    /**
     * Returns a new decuple, transforming the seventh member of this
     * decuple.
     * The seventh member of the new decuple is the result of applying the
     * given function to the seventh member of this decuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the seventh member
     * @return a decuple with the result of the function as the seventh member
     */
    public <R> Decuple<A, B, C, D, E, F, R, H, I, J> applySeventh(
            Function<G, R> function) {
        return new Decuple<>(first, second, third, fourth, fifth, sixth,
                function.apply(seventh), eighth, ninth, tenth);
    }

    /**
     * Returns a new decuple, transforming the eighth member of this
     * decuple.
     * The eighth member of the new decuple is the result of applying the
     * given function to the eighth member of this decuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the eighth member
     * @return a decuple with the result of the function as the eighth member
     */
    public <R> Decuple<A, B, C, D, E, F, G, R, I, J> applyEighth(
            Function<H, R> function) {
        return new Decuple<>(first, second, third, fourth, fifth, sixth,
                seventh, function.apply(eighth), ninth, tenth);
    }

    /**
     * Returns a new decuple, transforming the ninth member of this
     * decuple.
     * The ninth member of the new decuple is the result of applying the
     * given function to the ninth member of this decuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the ninth member
     * @return a decuple with the result of the function as the ninth member
     */
    public <R> Decuple<A, B, C, D, E, F, G, H, R, J> applyNinth(
            Function<I, R> function) {
        return new Decuple<>(first, second, third, fourth, fifth, sixth,
                seventh, eighth, function.apply(ninth), tenth);
    }

    /**
     * Returns a new decuple, transforming the tenth member of this
     * decuple.
     * The tenth member of the new decuple is the result of applying the
     * given function to the tenth member of this decuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the tenth member
     * @return a decuple with the result of the function as the tenth member
     */
    public <R> Decuple<A, B, C, D, E, F, G, H, I, R> applyTenth(
            Function<J, R> function) {
        return new Decuple<>(first, second, third, fourth, fifth, sixth,
                seventh, eighth, ninth, function.apply(tenth));
    }
}
