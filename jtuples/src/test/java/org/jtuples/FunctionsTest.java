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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andre Santos
 */
public class FunctionsTest {
    
    public FunctionsTest() {
    }
    
    /**
     * Test of curry method, of class Functions.
     */
    @Test
    public void testCurry() {
        BiFunction<String, String, String> f =
                Functions.curry(pair -> pair.first() + pair.second());
        assertEquals(f.apply("hello ", "world"), "hello world");
    }

    /**
     * Test of uncurry method, of class Functions.
     */
    @Test
    public void testUncurry() {
        Function<Pair<String, String>, String> f =
                Functions.uncurry((a, b) -> a + b);
        assertEquals(f.apply(new Pair<>("hello ", "world")), "hello world");
    }

    /**
     * Test of split method, of class Functions.
     */
    @Test
    public void testSplit_Function_Function() {
        Function<String, Pair<String, Integer>> f = 
                Functions.split(s -> s.trim(), s -> s.length());
        assertEquals(f.apply("  s  "), new Pair<>("s", 5));
    }

    /**
     * Test of split method, of class Functions.
     */
    @Test
    public void testSplit_BiFunction_BiFunction() {
        BiFunction<Integer, Integer, Pair<Integer, Integer>> f =
                Functions.split((a, b) -> a + b, (a, b) -> a * b);
        assertEquals(f.apply(2, 3), new Pair<>(5, 6));
    }

    /**
     * Test of split method, of class Functions.
     */
    @Test
    public void testSplit_Supplier_Supplier() {
        Supplier<Pair<Integer, Integer>> f =
                Functions.split(() -> 1, () -> 2);
        assertEquals(f.get(), new Pair<>(1, 2));
    }

    /**
     * Test of product method, of class Functions.
     */
    @Test
    public void testProduct_Function_Function() {
        Function<Pair<Integer, Integer>, Pair<Integer, Integer>> f =
                Functions.product(a -> a + 1, b -> 2 * b);
        assertEquals(f.apply(new Pair<>(1, 2)), new Pair<>(2, 4));
    }

    /**
     * Test of product method, of class Functions.
     */
    @Test
    public void testProduct_BiFunction_BiFunction() {
        BiFunction<Pair<Integer, Integer>, Pair<Integer, Integer>,
                Pair<Integer, Integer>> f =
                Functions.product((a, b) -> a + b, (a, b) -> a * b);
        assertEquals(f.apply(new Pair<>(1, 2), new Pair<>(3, 4)),
                new Pair<>(4, 8));
    }

    /**
     * Test of product method, of class Functions.
     */
    @Test
    public void testProduct_Supplier_Supplier() {
        Supplier<Pair<Integer, Integer>> f =
                Functions.product(() -> 1, () -> 2);
        assertEquals(f.get(), new Pair<>(1, 2));
    }

    /**
     * Test of product method, of class Functions.
     */
    @Test
    public void testProduct_Consumer_Consumer() {
        Consumer<Pair<Integer, Integer>> f = Functions.product(
                a -> { assertEquals(a.longValue(), 1); },
                b -> { assertEquals(b.longValue(), 2); });
        f.accept(new Pair<>(1, 2));
    }
    
}
