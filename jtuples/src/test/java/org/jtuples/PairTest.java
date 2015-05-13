/*
 *  Copyright (c) 2015 git-afsantos
 *
 *  Permission is hereby granted, free of charge,
 *  to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without
 *  restriction, including without limitation the rights to use, copy,
 *  modify, merge, publish, distribute, sublicense, and/or sell copies
 *  of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included
 *  in all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 *  IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 *  CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 *  TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 *  OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.jtuples;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Benjamim Sonntag <benjamimsonntag@gmail.com>
 */
public class PairTest {

    @Test
    public void testArity() {
        Pair<String, String> pair = new Pair<>();
        
        assertEquals(pair.arity(), 2);
    }

    @Test
    public void testFirst() {
        Pair<String, String> pair = new Pair<>("hello", "world");

        assertEquals(pair.first(), "hello");
    }

    @Test
    public void testFirstCanBeNull() {
        Pair<Object, Object> pair = new Pair<>(null, null);

        assertNull(pair.first());
    }

    @Test
    public void testSecond() {
        Pair<String, String> pair = new Pair<>("hello", "world");

        assertEquals(pair.second(), "world");
    }

    @Test
    public void testSecondCanBeNull() {
        Pair<Object, Object> pair = new Pair<>(null, null);

        assertNull(pair.second());
    }

    @Test
    public void testInvert() {
        Pair<String, Integer> pair = new Pair<>("hello", 123);

        Pair<Integer, String> other = pair.invert();

        assertEquals((int)other.first(), 123);
        assertEquals(other.second(), "hello");
    }

    @Test
    public void testApplyFirst() {
        Pair<String, String> pair = new Pair<>("hello", "world");

        Pair<Integer, String> other = pair.applyFirst(s -> s.length());

        assertEquals((int)other.first(), "hello".length());
    }

    @Test
    public void testApplySecond() {
        Pair<String, String> pair = new Pair<>("hello", "world");

        Pair<String, Integer> other = pair.applySecond(s -> s.length());

        assertEquals((int)other.second(), "world".length());
    }

    @Test
    public void testEqualsIsTrueWhenEqual() {
        Pair<String, String> pair = new Pair<>("hello", "world");
        Pair<String, String> other = new Pair<>("hello", "world");

        assertTrue(pair.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenNotEqual() {
        Pair<String, String> pair = new Pair<>("hello", "world");
        Pair<String, String> other = new Pair<>("goodbye", "world");

        assertFalse(pair.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenTypesAreDifferent() {
        Pair<String, String> pair = new Pair<>("hello", "world");
        Pair<String, Integer> other = new Pair<>("hello", 123);

        assertFalse(pair.equals(other));
    }

    @Test
    public void testHashCodeIsTheSameForEqualPairs() {
        Pair<String, String> pair = new Pair<>("hello", "world");
        Pair<String, String> other = new Pair<>("hello", "world");

        assertEquals(pair.hashCode(), other.hashCode());
    }

    @Test
    public void testApply() {
        Pair<String, String> pair = new Pair<>("hello", "world");

        assertTrue(pair.apply((a, b) -> {
            return "hello".equals(a) && "world".equals(b) ?
                    Boolean.TRUE : Boolean.FALSE;
        }));
    }
}
