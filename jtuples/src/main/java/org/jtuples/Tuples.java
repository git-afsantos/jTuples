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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;

/**
 * This class consists exclusively of static methods that return or
 * operate on tuples.
 * It contains some factory methods as well as methods for
 * the following operations:
 * <ul>
 * <li>{@code flatRight} and {@code flatLeft}
 * <li>{@code associateRight} and {@code associateLeft}
 * <li>{@code map}
 * <li>{@code zip}
 * </ul>
 *
 * @author Andre Santos <contact.andre.santos@gmail.com>
 * @author Benjamim Sonntag <benjamimsonntag@gmail.com>
 * @see org.jtuples.Tuple
 */
public final class Tuples {
    /**
     * Creates a pair with the given arguments.
     * @param <A> the type of the first element of the pair
     * @param <B> the type of the second element of the pair
     * @param first the first element of the pair
     * @param second the second element of the pair
     * @return a pair with the given arguments
     */
    public static <A, B> Pair<A, B> with(A first, B second) {
        return new Pair<>(first, second);
    }

    /**
     * Creates a triple with the given arguments.
     * @param <A> the type of the first element of the triple
     * @param <B> the type of the second element of the triple
     * @param <C> the type of the third element of the triple
     * @param first the first element of the triple
     * @param second the second element of the triple
     * @param third the third element of the triple
     * @return a triple with the given arguments
     */
    public static <A, B, C> Triple<A, B, C> with(A first, B second, C third) {
        return new Triple<>(first, second, third);
    }

    /**
     * Creates a quadruple with the given arguments.
     * @param <A> the type of the first element of the quadruple
     * @param <B> the type of the second element of the quadruple
     * @param <C> the type of the third element of the quadruple
     * @param <D> the type of the fourth element of the quadruple
     * @param first the first element of the quadruple
     * @param second the second element of the quadruple
     * @param third the third element of the quadruple
     * @param fourth the fourth element of the quadruple
     * @return a quadruple with the given arguments
     */
    public static <A, B, C, D> Quadruple<A, B, C, D> with(A first, B second,
            C third, D fourth) {
        return new Quadruple<>(first, second, third, fourth);
    }

    /**
     * Creates a quintuple with the given arguments.
     * @param <A> the type of the first element of the quintuple
     * @param <B> the type of the second element of the quintuple
     * @param <C> the type of the third element of the quintuple
     * @param <D> the type of the fourth element of the quintuple
     * @param <E> the type of the fifth element of the quintuple
     * @param first the first element of the quintuple
     * @param second the second element of the quintuple
     * @param third the third element of the quintuple
     * @param fourth the fourth element of the quintuple
     * @param fifth the fifth element of the quintuple
     * @return a quintuple with the given arguments
     */
    public static <A, B, C, D, E> Quintuple<A, B, C, D, E> with(A first,
            B second, C third, D fourth, E fifth) {
        return new Quintuple<>(first, second, third, fourth, fifth);
    }

    /**
     * Creates a sextuple with the given arguments.
     * @param <A> the type of the first element of the sextuple
     * @param <B> the type of the second element of the sextuple
     * @param <C> the type of the third element of the sextuple
     * @param <D> the type of the fourth element of the sextuple
     * @param <E> the type of the fifth element of the sextuple
     * @param <F> the type of the sixth element of the sextuple
     * @param first the first element of the sextuple
     * @param second the second element of the sextuple
     * @param third the third element of the sextuple
     * @param fourth the fourth element of the sextuple
     * @param fifth the fifth element of the sextuple
     * @param sixth the sixth element of the sextuple
     * @return a sextuple with the given arguments
     */
    public static <A, B, C, D, E, F> Sextuple<A, B, C, D, E, F> with(A first,
            B second, C third, D fourth, E fifth, F sixth) {
        return new Sextuple<>(first, second, third, fourth, fifth, sixth);
    }

    /**
     * Creates a septuple with the given arguments.
     * @param <A> the type of the first element of the septuple
     * @param <B> the type of the second element of the septuple
     * @param <C> the type of the third element of the septuple
     * @param <D> the type of the fourth element of the septuple
     * @param <E> the type of the fifth element of the septuple
     * @param <F> the type of the sixth element of the septuple
     * @param <G> the type of the seventh element of the septuple
     * @param first the first element of the septuple
     * @param second the second element of the septuple
     * @param third the third element of the septuple
     * @param fourth the fourth element of the septuple
     * @param fifth the fifth element of the septuple
     * @param sixth the sixth element of the septuple
     * @param seventh the seventh element of the septuple
     * @return a septuple with the given arguments
     */
    public static <A, B, C, D, E, F, G> Septuple<A, B, C, D, E, F, G> with(
            A first, B second, C third, D fourth,
            E fifth, F sixth, G seventh) {
        return new Septuple<>(first, second, third, fourth,
                fifth, sixth, seventh);
    }


    /**
     * Flattens a nested tuple.
     *
     * The resulting tuple will contain all the previous elements
     * in the same order.
     *
     * For example, for a pair {@code ((a, b), c)} the result
     * is the triple {@code (a, b, c)}.
     *
     * @param <A> the type of the first element of the inner pair
     * @param <B> the type of the second element of the inner pair
     * @param <C> the type of the second element of the outer pair
     * @param pair a pair that has another pair in the first position
     * @return a triple
     * @throws NullPointerException if the given pair is null
     *         or if the inner pair is null
     */
    public static <A, B, C>
            Triple<A, B, C> flatFirst(Pair<Pair<A, B>, C> pair) {
        return new Triple<>(
                pair.first().first(),
                pair.first().second(),
                pair.second()
        );
    }

    /**
     * Flattens a nested tuple.
     *
     * The resulting tuple will contain all the previous elements
     * in the same order.
     *
     * For example, for a pair {@code (a, (b, c))} the result
     * is the triple {@code (a, b, c)}.
     *
     * @param <A> the type of the first element of the outer pair
     * @param <B> the type of the first element of the inner pair
     * @param <C> the type of the second element of the inner pair
     * @param pair a pair that has another pair in the second position
     * @return a triple
     * @throws NullPointerException if the given pair is null
     *         or if the inner pair is null
     */
    public static <A, B, C>
            Triple<A, B, C> flatSecond(Pair<A, Pair<B, C>> pair) {
        return new Triple<>(
                pair.first(),
                pair.second().first(),
                pair.second().second()
        );
    }


    /**
     * Associates a nested tuple on the first position.
     *
     * This takes a pair with a nesting in the second member
     * and returns a tuple that contains all the previous elements
     * in the same order, but with the nesting in the first position.
     *
     * For example, for a pair {@code (a, (b, c))} the result
     * is the pair {@code ((a, b), c)}.
     *
     * @param <A> the type of the first element of the outer pair
     * @param <B> the type of the first element of the inner pair
     * @param <C> the type of the second element of the inner pair
     * @param pair a pair that has another pair in the second position
     * @return a pair that has another pair on the first position
     * @throws NullPointerException if the given pair is null
     *         or if the inner pair is null
     */
    public static <A, B, C>
            Pair<Pair<A, B>, C> associateFirst(Pair<A, Pair<B, C>> pair) {
        return new Pair<>(
                new Pair<>(pair.first(), pair.second().first()),
                pair.second().second()
        );
    }

    /**
     * Associates a nested tuple on the second position.
     *
     * This takes a pair with a nesting in the second member
     * and returns a tuple that contains all the previous elements
     * in the same order, but with the nesting in the first position.
     *
     * For example, for a pair {@code (a, (b, c))} the result
     * is the pair {@code ((a, b), c)}.
     *
     * @param <A> the type of the first element of the inner pair
     * @param <B> the type of the second element of the inner pair
     * @param <C> the type of the second element of the outer pair
     * @param pair a pair that has another pair in the first position
     * @return a pair that has another pair on the second position
     * @throws NullPointerException if the given pair is null
     *         or if the inner pair is null
     */
    public static <A, B, C>
            Pair<A, Pair<B, C>> associateSecond(Pair<Pair<A, B>, C> pair) {
        return new Pair<>(
                pair.first().first(),
                new Pair<>(pair.first().second(), pair.second())
        );
    }


    /**
     * Creates a pair by applying a function to each element
     * of the given pair.
     *
     * The resulting pair's elements will be the result of applying
     * the function to each element of the given pair, in order.
     * That is, for a function {@code fn} and a pair {@code (a, b)}
     * the result is the pair {@code (fn(a), fn(b))}.
     *
     * @param <A> the type of the elements of the given pair
     * @param <B> the type of the elements of the resulting pair
     * @param pair a pair whose elements have a common superclass
     * @param f a function to be applied to all elements of {@code pair}
     * @return a pair whose elements are the result of applying {@code f}
     *         to all elements of the given pair
     * @throws NullPointerException if the given pair is null
     *         or if the given function is null
     */
    public static <A, B> Pair<B, B> map(Pair<? extends A, ? extends A> pair,
            Function<A, B> f) {
        return new Pair<>(
                f.apply(pair.first()),
                f.apply(pair.second())
        );
    }

    /**
     * Creates a triple by applying a function to each element
     * of the given triple.
     *
     * The resulting triple's elements will be the result of applying
     * the function to each element of the given triple, in order.
     * That is, for a function {@code fn} and a triple {@code (a, b, c)}
     * the result is the triple {@code (fn(a), fn(b), fn(c))}.
     *
     * @param <A> the type of the elements of the given triple
     * @param <B> the type of the elements of the resulting triple
     * @param triple a triple whose elements have a common superclass
     * @param f a function to be applied to all elements of {@code triple}
     * @return a triple whose elements are the result of applying {@code f}
     *         to all elements of the given triple
     * @throws NullPointerException if the given triple is null
     *         or if the given function is null
     */
    public static <A, B> Triple<B, B, B> map(
            Triple<? extends A, ? extends A, ? extends A> triple,
            Function<A, B> f) {
        return new Triple<>(
                f.apply(triple.first()),
                f.apply(triple.second()),
                f.apply(triple.third())
        );
    }

    /**
     * Creates a quadruple by applying a function to each element
     * of the given quadruple.
     *
     * The resulting quadruple's elements will be the result of applying
     * the function to each element of the given quadruple, in order.
     * That is, for a function {@code fn} and a quadruple {@code (a, b, c, d)}
     * the result is the quadruple {@code (fn(a), fn(b), fn(c), fn(d))}.
     *
     * @param <A> the type of the elements of the given quadruple
     * @param <B> the type of the elements of the resulting quadruple
     * @param quadruple a quadruple whose elements have a common superclass
     * @param f a function to be applied to all elements of {@code quadruple}
     * @return a quadruple whose elements are the result of applying {@code f}
     *         to all elements of the given quadruple
     * @throws NullPointerException if the given quadruple is null
     *         or if the given function is null
     */
    public static <A, B> Quadruple<B, B, B, B> map(
            Quadruple<? extends A, ? extends A, ? extends A, ? extends A> quadruple,
            Function<A, B> f) {
        return new Quadruple<>(
                f.apply(quadruple.first()),
                f.apply(quadruple.second()),
                f.apply(quadruple.third()),
                f.apply(quadruple.fourth())
        );
    }

    /**
     * Creates a quintuple by applying a function to each element
     * of the given quintuple.
     *
     * The resulting quintuple's elements will be the result of applying
     * the function to each element of the given quintuple, in order.
     * That is, for a function {@code fn} and a quintuple {@code (a, b, c, d, e)}
     * the result is the quintuple {@code (fn(a), fn(b), fn(c), fn(d), fn(e))}.
     *
     * @param <A> the type of the elements of the given quintuple
     * @param <B> the type of the elements of the resulting quintuple
     * @param quintuple a quintuple whose elements have a common superclass
     * @param f a function to be applied to all elements of {@code quintuple}
     * @return a quintuple whose elements are the result of applying {@code f}
     *         to all elements of the given quintuple
     * @throws NullPointerException if the given quintuple is null
     *         or if the given function is null
     */
    public static <A, B> Quintuple<B, B, B, B, B> map(
            Quintuple<? extends A, ? extends A, ? extends A, ? extends A, ? extends A> quintuple,
            Function<A, B> f) {
        return new Quintuple<>(
                f.apply(quintuple.first()),
                f.apply(quintuple.second()),
                f.apply(quintuple.third()),
                f.apply(quintuple.fourth()),
                f.apply(quintuple.fifth())
        );
    }

    /**
     * Creates a sextuple by applying a function to each element
     * of the given sextuple.
     *
     * The resulting sextuple's elements will be the result of applying
     * the function to each element of the given sextuple, in order.
     * That is, for a function {@code fn} and a sextuple {@code (a, b, c, d, e, f)}
     * the result is the sextuple {@code (fn(a), fn(b), fn(c), fn(d), fn(e), fn(f))}.
     *
     * @param <A> the type of the elements of the given sextuple
     * @param <B> the type of the elements of the resulting sextuple
     * @param sextuple a sextuple whose elements have a common superclass
     * @param f a function to be applied to all elements of {@code sextuple}
     * @return a sextuple whose elements are the result of applying {@code f}
     *         to all elements of the given sextuple
     * @throws NullPointerException if the given sextuple is null
     *         or if the given function is null
     */
    public static <A, B> Sextuple<B, B, B, B, B, B> map(
            Sextuple<? extends A, ? extends A, ? extends A, ? extends A, ? extends A, ? extends A> sextuple,
            Function<A, B> f) {
        return new Sextuple<>(
                f.apply(sextuple.first()),
                f.apply(sextuple.second()),
                f.apply(sextuple.third()),
                f.apply(sextuple.fourth()),
                f.apply(sextuple.fifth()),
                f.apply(sextuple.sixth())
        );
    }

    /**
     * Creates a septuple by applying a function to each element
     * of the given septuple.
     *
     * The resulting septuple's elements will be the result of applying
     * the function to each element of the given septuple, in order.
     * That is, for a function {@code fn} and a septuple
     * {@code (a, b, c, d, e, f, g)}
     * the result is the septuple
     * {@code (fn(a), fn(b), fn(c), fn(d), fn(e), fn(f), fn(g))}.
     *
     * @param <A> the type of the elements of the given septuple
     * @param <B> the type of the elements of the resulting septuple
     * @param septuple a septuple whose elements have a common superclass
     * @param f a function to be applied to all elements of {@code septuple}
     * @return a septuple whose elements are the result of applying {@code f}
     *         to all elements of the given septuple
     * @throws NullPointerException if the given septuple is null
     *         or if the given function is null
     */
    public static <A, B> Septuple<B, B, B, B, B, B, B> map(
            Septuple<? extends A, ? extends A, ? extends A, ? extends A,
                    ? extends A, ? extends A, ? extends A> septuple,
            Function<A, B> f) {
        return new Septuple<>(
                f.apply(septuple.first()),
                f.apply(septuple.second()),
                f.apply(septuple.third()),
                f.apply(septuple.fourth()),
                f.apply(septuple.fifth()),
                f.apply(septuple.sixth()),
                f.apply(septuple.seventh())
        );
    }

    /**
     * Zips the given iterables into a collection of pairs.
     *
     * The resulting collection will contain pairs of all the previous elements,
     * preserving order, and stopping at the size of the smallest of the iterators.
     * That is, for lists {@code [a, b, c]} and {@code [d, e, f, g]} the result
     * is the list of pairs {@code [(a, d), (b, e), (c, f)]}.
     *
     * @param <A> the type of the elements of the first iterable
     * @param <B> the type of the elements of the second iterable
     * @param firsts the elements to place on the first position of each pair
     * @param seconds the elements to place on the second position of each pair
     * @return a collection of pairs
     * @throws NullPointerException if any of the iterables is null
     */
    public static <A, B> Collection<Pair<A, B>> zip(Iterable<A> firsts,
            Iterable<B> seconds) {
        Collection<Pair<A, B>> collection = new ArrayList<>();
        zip(firsts.iterator(), seconds.iterator())
                .forEachRemaining(collection::add);
        return collection;
    }

    /**
     * Zips the given iterators.
     *
     * The resulting iterator will contain pairs of all the previous elements,
     * preserving order, and stopping at the size of the smallest of the iterators.
     * That is, for the iterators of lists {@code [a, b, c]} and {@code [d, e, f, g]}
     * the result is an iterator with pairs {@code [(a, d), (b, e), (c, f)]}.
     *
     * @param <A> the type of the elements of the first iterator
     * @param <B> the type of the elements of the second iterator
     * @param firsts the elements to place on the first position of each pair
     * @param seconds the elements to place on the second position of each pair
     * @return an iterator of pairs
     * @throws NullPointerException if any of the iterators is null
     */
    public static <A, B> Iterator<Pair<A, B>> zip(Iterator<A> firsts,
            Iterator<B> seconds) {
        return new ZippedIterator<>(firsts, seconds);
    }


    private Tuples() {
        throw new AssertionError("This class should not be instantiated.");
    }


    private static final class ZippedIterator<A, B>
            implements Iterator<Pair<A, B>> {

        private final Iterator<A> firsts;
        private final Iterator<B> seconds;

        ZippedIterator(Iterator<A> firsts, Iterator<B> seconds) {
            this.firsts = firsts;
            this.seconds = seconds;
        }

        @Override
        public boolean hasNext() {
            return firsts.hasNext() && seconds.hasNext();
        }

        @Override
        public Pair<A, B> next() {
            return new Pair<>(
                    firsts.next(),
                    seconds.next()
            );
        }
    }
}
