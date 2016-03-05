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
 * Represents a mathematical ordered octuple of objects.
 * The order in which the objects appear in the octuple is significant:
 * the ordered octuple {@code (a, b, c, d, e, f, g, h)} is different from the
 * ordered octuple {@code (b, a, c, d, e, f, g, h)} unless
 * {@code a} and {@code b} are equal.
 * 
 * @author Andre Santos <contact.andre.santos@gmail.com>
 * @param <A> the type of the first element of the octuple
 * @param <B> the type of the second element of the octuple
 * @param <C> the type of the third element of the octuple
 * @param <D> the type of the fourth element of the octuple
 * @param <E> the type of the fifth element of the octuple
 * @param <F> the type of the sixth element of the octuple
 * @param <G> the type of the seventh element of the octuple
 * @param <H> the type of the eighth element of the octuple
 */
public final class Octuple<A, B, C, D, E, F, G, H> extends AbstractTuple {
    private static final int ARITY = 8;

    private final A first;
    private final B second;
    private final C third;
    private final D fourth;
    private final E fifth;
    private final F sixth;
    private final G seventh;
    private final H eighth;

    /**
     * Returns a new octuple of
     * {@code (null, null, null, null, null, null, null, null)}.
     */
    public Octuple() {
        this(null, null, null, null, null, null, null, null);
    }

    /**
     * Returns a new ordered octuple, containing the given objects.
     * @param first the first member of the ordered octuple
     * @param second the second member of the ordered octuple
     * @param third the third member of the ordered octuple
     * @param fourth the fourth member of the ordered octuple
     * @param fifth the fifth member of the ordered octuple
     * @param sixth the sixth member of the ordered octuple
     * @param seventh the seventh member of the ordered octuple
     * @param eighth the eighth member of the ordered octuple
     */
    public Octuple(A first, B second, C third, D fourth,
            E fifth, F sixth, G seventh, H eighth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.seventh = seventh;
        this.eighth = eighth;
    }

    
    /**
     * Returns the first member of this ordered octuple.
     * @return the first member of the octuple
     */
    public A first() {
        return first;
    }
    
    /**
     * Returns the second member of this ordered octuple.
     * @return the second member of the octuple
     */
    public B second() {
        return second;
    }
    
    /**
     * Returns the third member of this ordered octuple.
     * @return the third member of the octuple
     */
    public C third() {
        return third;
    }
    
    /**
     * Returns the fourth member of this ordered octuple.
     * @return the fourth member of the octuple
     */
    public D fourth() {
        return fourth;
    }
    
    /**
     * Returns the fifth member of this ordered octuple.
     * @return the fifth member of the octuple
     */
    public E fifth() {
        return fifth;
    }
    
    /**
     * Returns the sixth member of this ordered octuple.
     * @return the sixth member of the octuple
     */
    public F sixth() {
        return sixth;
    }
    
    /**
     * Returns the seventh member of this ordered octuple.
     * @return the seventh member of the octuple
     */
    public G seventh() {
        return seventh;
    }
    
    /**
     * Returns the eighth member of this ordered octuple.
     * @return the eighth member of the octuple
     */
    public H eighth() {
        return eighth;
    }

    /**
     * Returns the constant {@code 8}.
     * The arity of a octuple is defined to be 8.
     * @return the constant 8
     */
    @Override
    public int arity() {
        return ARITY;
    }

    @Override
    public Octuple<H, G, F, E, D, C, B, A> invert() {
        return new Octuple<>(eighth, seventh, sixth, fifth, fourth,
                third, second, first);
    }

    @Override
    public Octuple<B, C, D, E, F, G, H, A> shiftLeft() {
        return shiftLeft(first);
    }

    @Override
    public <V> Octuple<B, C, D, E, F, G, H, V> shiftLeft(V value) {
        return new Octuple<>(second, third, fourth,
                fifth, sixth, seventh, eighth, value);
    }

    @Override
    public Octuple<H, A, B, C, D, E, F, G> shiftRight() {
        return shiftRight(eighth);
    }

    @Override
    public <V> Octuple<V, A, B, C, D, E, F, G> shiftRight(V value) {
        return new Octuple<>(value, first, second,
                third, fourth, fifth, sixth, seventh);
    }

    @Override
    public Object[] toArray() {
        return new Object[] {
            first, second, third, fourth, fifth, sixth, seventh, eighth
        };
    }


    /**
     * Returns a new octuple, transforming the first member of this
     * octuple.
     * The first member of the new octuple is the result of applying the
     * given function to the first member of this octuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the first member
     * @return a octuple with the result of the function as the first member
     */
    public <R> Octuple<R, B, C, D, E, F, G, H> applyFirst(
            Function<A, R> function) {
        return new Octuple<>(function.apply(first),
                second, third, fourth, fifth, sixth, seventh, eighth);
    }

    /**
     * Returns a new octuple, transforming the second member of this
     * octuple.
     * The second member of the new octuple is the result of applying the
     * given function to the second member of this octuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the second member
     * @return a octuple with the result of the function as the second member
     */
    public <R> Octuple<A, R, C, D, E, F, G, H> applySecond(
            Function<B, R> function) {
        return new Octuple<>(first, function.apply(second),
                third, fourth, fifth, sixth, seventh, eighth);
    }

    /**
     * Returns a new octuple, transforming the third member of this
     * octuple.
     * The third member of the new octuple is the result of applying the
     * given function to the third member of this octuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the third member
     * @return a octuple with the result of the function as the third member
     */
    public <R> Octuple<A, B, R, D, E, F, G, H> applyThird(
            Function<C, R> function) {
        return new Octuple<>(first, second, function.apply(third),
                fourth, fifth, sixth, seventh, eighth);
    }

    /**
     * Returns a new octuple, transforming the fourth member of this
     * octuple.
     * The fourth member of the new octuple is the result of applying the
     * given function to the fourth member of this octuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the fourth member
     * @return a octuple with the result of the function as the fourth member
     */
    public <R> Octuple<A, B, C, R, E, F, G, H> applyFourth(
            Function<D, R> function) {
        return new Octuple<>(first, second, third,
                function.apply(fourth), fifth, sixth, seventh, eighth);
    }

    /**
     * Returns a new octuple, transforming the fifth member of this
     * octuple.
     * The fifth member of the new octuple is the result of applying the
     * given function to the fifth member of this octuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the fifth member
     * @return a octuple with the result of the function as the fifth member
     */
    public <R> Octuple<A, B, C, D, R, F, G, H> applyFifth(
            Function<E, R> function) {
        return new Octuple<>(first, second, third, fourth,
                function.apply(fifth), sixth, seventh, eighth);
    }

    /**
     * Returns a new octuple, transforming the sixth member of this
     * octuple.
     * The sixth member of the new octuple is the result of applying the
     * given function to the sixth member of this octuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the sixth member
     * @return a octuple with the result of the function as the sixth member
     */
    public <R> Octuple<A, B, C, D, E, R, G, H> applySixth(
            Function<F, R> function) {
        return new Octuple<>(first, second, third, fourth, fifth,
                function.apply(sixth), seventh, eighth);
    }

    /**
     * Returns a new octuple, transforming the seventh member of this
     * octuple.
     * The seventh member of the new octuple is the result of applying the
     * given function to the seventh member of this octuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the seventh member
     * @return a octuple with the result of the function as the seventh member
     */
    public <R> Octuple<A, B, C, D, E, F, R, H> applySeventh(
            Function<G, R> function) {
        return new Octuple<>(first, second, third, fourth, fifth, sixth,
                function.apply(seventh), eighth);
    }

    /**
     * Returns a new octuple, transforming the eighth member of this
     * octuple.
     * The eighth member of the new octuple is the result of applying the
     * given function to the eighth member of this octuple.
     * The remaining members are preserved.
     * @param <R> the type of the function's result
     * @param function the function used to transform the eighth member
     * @return a octuple with the result of the function as the eighth member
     */
    public <R> Octuple<A, B, C, D, E, F, G, R> applyEighth(
            Function<H, R> function) {
        return new Octuple<>(first, second, third, fourth, fifth, sixth,
                seventh, function.apply(eighth));
    }
}
