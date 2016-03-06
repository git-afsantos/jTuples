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
 * Represents a mathematical ordered septuple of objects.
 * The order in which the objects appear in the septuple is significant:
 * the ordered septuple {@code (a, b, c, d, e, f, g)} is different from the
 * ordered septuple {@code (b, a, c, d, e, f, g)} unless
 * {@code a} and {@code b} are equal.
 * 
 * @author Andre Santos
 * @param <A> the type of the first element of the septuple
 * @param <B> the type of the second element of the septuple
 * @param <C> the type of the third element of the septuple
 * @param <D> the type of the fourth element of the septuple
 * @param <E> the type of the fifth element of the septuple
 * @param <F> the type of the sixth element of the septuple
 * @param <G> the type of the seventh element of the septuple
 */
public final class Septuple<A, B, C, D, E, F, G> extends AbstractTuple {
    private static final int ARITY = 7;

    private final A first;
    private final B second;
    private final C third;
    private final D fourth;
    private final E fifth;
    private final F sixth;
    private final G seventh;

    /**
     * Returns a new septuple of
     * {@code (null, null, null, null, null, null, null)}.
     */
    public Septuple() {
        this(null, null, null, null, null, null, null);
    }

    /**
     * Returns a new ordered septuple, containing the given objects.
     * @param first the first member of the ordered septuple
     * @param second the second member of the ordered septuple
     * @param third the third member of the ordered septuple
     * @param fourth the fourth member of the ordered septuple
     * @param fifth the fifth member of the ordered septuple
     * @param sixth the sixth member of the ordered septuple
     * @param seventh the seventh member of the ordered septuple
     */
    public Septuple(A first, B second, C third, D fourth,
            E fifth, F sixth, G seventh) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.seventh = seventh;
    }

    
    /**
     * Returns the first member of this ordered septuple.
     * @return the first member of the septuple
     */
    public A first() {
        return first;
    }
    
    /**
     * Returns the second member of this ordered septuple.
     * @return the second member of the septuple
     */
    public B second() {
        return second;
    }
    
    /**
     * Returns the third member of this ordered septuple.
     * @return the third member of the septuple
     */
    public C third() {
        return third;
    }
    
    /**
     * Returns the fourth member of this ordered septuple.
     * @return the fourth member of the septuple
     */
    public D fourth() {
        return fourth;
    }
    
    /**
     * Returns the fifth member of this ordered septuple.
     * @return the fifth member of the septuple
     */
    public E fifth() {
        return fifth;
    }
    
    /**
     * Returns the sixth member of this ordered septuple.
     * @return the sixth member of the septuple
     */
    public F sixth() {
        return sixth;
    }
    
    /**
     * Returns the seventh member of this ordered septuple.
     * @return the seventh member of the septuple
     */
    public G seventh() {
        return seventh;
    }

    /**
     * Returns the constant {@code 7}.
     * The arity of a septuple is defined to be 7.
     * @return the constant 7
     */
    @Override
    public int arity() {
        return ARITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Septuple<G, F, E, D, C, B, A> invert() {
        return new Septuple<>(seventh, sixth, fifth, fourth,
                third, second, first);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Septuple<B, C, D, E, F, G, A> shiftLeft() {
        return shiftLeft(first);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> Septuple<B, C, D, E, F, G, V> shiftLeft(V value) {
        return new Septuple<>(second, third, fourth,
                fifth, sixth, seventh, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Septuple<G, A, B, C, D, E, F> shiftRight() {
        return shiftRight(seventh);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <V> Septuple<V, A, B, C, D, E, F> shiftRight(V value) {
        return new Septuple<>(value, first, second,
                third, fourth, fifth, sixth);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        return new Object[] {
            first, second, third, fourth, fifth, sixth, seventh
        };
    }


    /**
     * Returns a new septuple, transforming the first member of this
     * septuple.
     * The first member of the new septuple is the result of applying the
     * given function to the first member of this septuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the first member
     * @return a septuple with the result of the function as the first member
     */
    public <R> Septuple<R, B, C, D, E, F, G> applyFirst(
            Function<A, R> function) {
        return new Septuple<>(function.apply(first),
                second, third, fourth, fifth, sixth, seventh);
    }

    /**
     * Returns a new septuple, transforming the second member of this
     * septuple.
     * The second member of the new septuple is the result of applying the
     * given function to the second member of this septuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the second member
     * @return a septuple with the result of the function as the second member
     */
    public <R> Septuple<A, R, C, D, E, F, G> applySecond(
            Function<B, R> function) {
        return new Septuple<>(first, function.apply(second),
                third, fourth, fifth, sixth, seventh);
    }

    /**
     * Returns a new septuple, transforming the third member of this
     * septuple.
     * The third member of the new septuple is the result of applying the
     * given function to the third member of this septuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the third member
     * @return a septuple with the result of the function as the third member
     */
    public <R> Septuple<A, B, R, D, E, F, G> applyThird(
            Function<C, R> function) {
        return new Septuple<>(first, second, function.apply(third),
                fourth, fifth, sixth, seventh);
    }

    /**
     * Returns a new septuple, transforming the fourth member of this
     * septuple.
     * The fourth member of the new septuple is the result of applying the
     * given function to the fourth member of this septuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the fourth member
     * @return a septuple with the result of the function as the fourth member
     */
    public <R> Septuple<A, B, C, R, E, F, G> applyFourth(
            Function<D, R> function) {
        return new Septuple<>(first, second, third,
                function.apply(fourth), fifth, sixth, seventh);
    }

    /**
     * Returns a new septuple, transforming the fifth member of this
     * septuple.
     * The fifth member of the new septuple is the result of applying the
     * given function to the fifth member of this septuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the fifth member
     * @return a septuple with the result of the function as the fifth member
     */
    public <R> Septuple<A, B, C, D, R, F, G> applyFifth(
            Function<E, R> function) {
        return new Septuple<>(first, second, third, fourth,
                function.apply(fifth), sixth, seventh);
    }

    /**
     * Returns a new septuple, transforming the sixth member of this
     * septuple.
     * The sixth member of the new septuple is the result of applying the
     * given function to the sixth member of this septuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the sixth member
     * @return a septuple with the result of the function as the sixth member
     */
    public <R> Septuple<A, B, C, D, E, R, G> applySixth(
            Function<F, R> function) {
        return new Septuple<>(first, second, third, fourth, fifth,
                function.apply(sixth), seventh);
    }

    /**
     * Returns a new septuple, transforming the seventh member of this
     * septuple.
     * The seventh member of the new septuple is the result of applying the
     * given function to the seventh member of this septuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the seventh member
     * @return a septuple with the result of the function as the seventh member
     */
    public <R> Septuple<A, B, C, D, E, F, R> applySeventh(
            Function<G, R> function) {
        return new Septuple<>(first, second, third, fourth, fifth, sixth,
                function.apply(seventh));
    }
}
