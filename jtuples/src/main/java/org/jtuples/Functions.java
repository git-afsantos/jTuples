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
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * This class provides static methods to support a functional programming style.
 * It provides methods commonly seen in functional programming environments,
 * that revolve around the use of tuples and functions (or lambdas).
 * @author Andre Santos <contact.andre.santos@gmail.com>
 */
public final class Functions {
    private Functions() {
        throw new AssertionError();
    }

    /**
     * Returns a curried version of the given function.
     * Given a function that accepts a pair as its argument, its curried
     * version is a function that accepts the two components of the pair
     * individually.
     * That is, given a function {@code f: ((a, b)) -> c}, it becomes
     * {@code g: (a, b) -> f((a, b))} instead.
     * @param <A> the type of the first component of the pair
     * @param <B> the type of the second component of the pair
     * @param <C> the return type
     * @param function the function to curry
     * @return the curried version of the given function
     */
    public static <A, B, C> BiFunction<A, B, C> curry(
            Function<Pair<A, B>, C> function) {
        return (A a, B b) -> function.apply(new Pair<>(a, b));
    }

    /**
     * Returns an uncurried version of the given function.
     * Given a function that accepts two individual parameters, its uncurried
     * version accepts instead a pair consisting of the two parameters.
     * That is, given a function {@code f: (a, b) -> c}, it becomes
     * {@code g: ((a, b)) -> f(a, b)} instead.
     * @param <A> the type of the first parameter
     * @param <B> the type of the second parameter
     * @param <C> the return type
     * @param function the function to uncurry
     * @return the uncurried version of the given function
     */
    public static <A, B, C> Function<Pair<A, B>, C> uncurry(
            BiFunction<A, B, C> function) {
        return (Pair<A, B> pair) -> function.apply(pair.first(), pair.second());
    }

    /**
     * Returns the split of the two given functions.
     * Given two functions with parameters of the same type, the split of
     * such functions is a single function, with the same parameters, that
     * returns a pair whose components are the application of the original
     * functions to the arguments.
     * That is, given functions {@code f: (a) -> b} and {@code g: (a) -> c},
     * they become {@code h: (a) -> (f(a), g(a))} instead.
     * @param <A> the type of the parameter
     * @param <B> the return type of the first function
     * @param <C> the return type of the second function
     * @param f the first function of the split
     * @param g the second function of the split
     * @return the split of the given functions
     */
    public static <A, B, C> Function<A, Pair<B, C>> split(
            Function<A, B> f, Function<? super A, C> g) {
        return (A a) -> new Pair<>(f.apply(a), g.apply(a));
    }

    /**
     * Returns the split of the two given functions.
     * Given two functions with parameters of the same type, the split of
     * such functions is a single function, with the same parameters, that
     * returns a pair whose components are the application of the original
     * functions to the arguments.
     * That is, given functions {@code f: (a, b) -> c} and
     * {@code g: (a, b) -> d}, they become
     * {@code h: (a, b) -> (f(a, b), g(a, b))} instead.
     * Note that this, in a way, is equivalent to the product of the given
     * functions, although simplified.
     * @param <A> the type of the first parameter
     * @param <B> the type of the second parameter
     * @param <C> the return type of the first function
     * @param <D> the return type of the second function
     * @param f the first function of the split
     * @param g the second function of the split
     * @return the split of the given functions
     */
    public static <A, B, C, D> BiFunction<A, B, Pair<C, D>> split(
            BiFunction<A, B, C> f, BiFunction<? super A, ? super B, D> g) {
        return (A a, B b) -> new Pair<>(f.apply(a, b), g.apply(a, b));
    }

    /**
     * Returns the split of the two given functions.
     * Given two functions with parameters of the same type, the split of
     * such functions is a single function, with the same parameters, that
     * returns a pair whose components are the application of the original
     * functions to the arguments.
     * That is, given functions {@code f: () -> a} and {@code g: () -> b},
     * they become {@code h: () -> (f(), g())} instead.
     * Note that this is equivalent to the product of suppliers.
     * @param <A> the return type of the first function
     * @param <B> the return type of the second function
     * @param f the first function of the split
     * @param g the second function of the split
     * @return the split of the given functions
     */
    public static <A, B> Supplier<Pair<A, B>> split(
            Supplier<A> f, Supplier<B> g) {
        return product(f, g);
    }

    /**
     * Returns the product of the two given functions.
     * Given two functions, the product of such functions is a single function,
     * with the union of the parameters, as a Pair, that
     * returns a pair whose components are the application of the original
     * functions to the respective arguments.
     * That is, given functions {@code f: (a) -> b} and {@code g: (c) -> d},
     * they become {@code h: ((a, c)) -> (f(a), g(c))} instead.
     * @param <A> the type of the parameter of the first function
     * @param <B> the return type of the first function
     * @param <C> the type of the parameter of the second function
     * @param <D> the return type of the second function
     * @param f the first function of the product
     * @param g the second function of the product
     * @return the product of the given functions
     */
    public static <A, B, C, D> Function<Pair<A, C>, Pair<B, D>> product(
            Function<A, B> f, Function<C, D> g) {
        return (Pair<A, C> pair) ->
            new Pair<>(f.apply(pair.first()), g.apply(pair.second()));
    }

    /**
     * Returns the product of the two given functions.
     * Given two functions, the product of such functions is a single function,
     * with the union of the parameters, as a Pair, that
     * returns a pair whose components are the application of the original
     * functions to the respective arguments.
     * That is, given functions {@code f: (a, b) -> c} and
     * {@code g: (d, e) -> f}, they become
     * {@code h: ((a, d), (b, e)) -> (f(a, b), g(d, e))} instead.
     * @param <F1> the type of the first parameter of the first function
     * @param <F2> the type of the second parameter of the first function
     * @param <F> the return type of the first function
     * @param <G1> the type of the first parameter of the second function
     * @param <G2> the type of the second parameter of the second function
     * @param <G> the return type of the second function
     * @param f the first function of the product
     * @param g the second function of the product
     * @return the product of the given functions
     */
    public static <F1, F2, G1, G2, F, G>
        BiFunction<Pair<F1, G1>, Pair<F2, G2>, Pair<F, G>> product(
                BiFunction<F1, F2, F> f, BiFunction<G1, G2, G> g) {
        return (Pair<F1, G1> pair1, Pair<F2, G2> pair2) ->
            new Pair<>(f.apply(pair1.first(), pair2.first()),
                    g.apply(pair1.second(), pair2.second()));
    }

    /**
     * Returns the product of the two given functions.
     * Given two functions, the product of such functions is a single function,
     * with the union of the parameters, as a Pair, that
     * returns a pair whose components are the application of the original
     * functions to the respective arguments.
     * That is, given functions {@code f: () -> a} and {@code g: () -> b},
     * they become {@code h: () -> (f(), g())} instead.
     * Note that this is equivalent of the split of suppliers.
     * @param <A> the return type of the first function
     * @param <B> the return type of the second function
     * @param f the first function of the split
     * @param g the second function of the split
     * @return the split of the given functions
     */
    public static <A, B> Supplier<Pair<A, B>> product(
            Supplier<A> f, Supplier<B> g) {
        return () -> new Pair<>(f.get(), g.get());
    }

    /**
     * Returns the product of the two given functions.
     * Given two functions, the product of such functions is a single function,
     * with the union of the parameters, as a Pair, that
     * returns a pair whose components are the application of the original
     * functions to the respective arguments.
     * That is, given functions {@code f: (a) -> void} and
     * {@code g: (b) -> void}, they become
     * {@code h: ((a, b)) -> (void) (f(a), g(b))} instead.
     * @param <A> the type of the parameter of the first function
     * @param <B> the type of the parameter of the second function
     * @param f the first function of the split
     * @param g the second function of the split
     * @return the split of the given functions
     */
    public static <A, B> Consumer<Pair<A, B>> product(
            Consumer<A> f, Consumer<B> g) {
        return (Pair<A, B> pair) -> {
            f.accept(pair.first());
            g.accept(pair.second());
        };
    }
}
