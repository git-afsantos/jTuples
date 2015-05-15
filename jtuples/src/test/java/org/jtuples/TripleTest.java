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
public class TripleTest {

    @Test
    public void testArity() {
        Triple<String, String, String> triple = new Triple<>();
        
        assertEquals(triple.arity(), 3);
    }

    @Test
    public void testFirst() {
        Triple<String, String, String> triple =
                new Triple<>("hello", "world", "!");

        assertEquals(triple.first(), "hello");
    }

    @Test
    public void testFirstCanBeNull() {
        Triple<Object, Object, Object> triple = new Triple<>(null, null, null);

        assertNull(triple.first());
    }

    @Test
    public void testSecond() {
        Triple<String, String, String> triple =
                new Triple<>("hello", "world", "!");

        assertEquals(triple.second(), "world");
    }

    @Test
    public void testSecondCanBeNull() {
        Triple<Object, Object, Object> triple = new Triple<>(null, null, null);

        assertNull(triple.second());
    }

    @Test
    public void testThird() {
        Triple<String, String, String> triple =
                new Triple<>("hello", "world", "!");

        assertEquals(triple.third(), "!");
    }

    @Test
    public void testThirdCanBeNull() {
        Triple<Object, Object, Object> triple = new Triple<>(null, null, null);

        assertNull(triple.third());
    }

    @Test
    public void testInvert() {
        Triple<String, Integer, Boolean> triple =
                new Triple<>("hello", 123, true);

        Triple<Boolean, Integer, String> other = triple.invert();

        assertEquals(other.first(), true);
        assertEquals((int)other.second(), 123);
        assertEquals(other.third(), "hello");
    }

    @Test
    public void testApplyFirst() {
        Triple<String, String, String> triple =
                new Triple<>("hello", "world", "!");

        Triple<Integer, String, String> other =
                triple.applyFirst(s -> s.length());

        assertEquals((int)other.first(), "hello".length());
    }

    @Test
    public void testApplySecond() {
        Triple<String, String, String> triple =
                new Triple<>("hello", "world", "!");

        Triple<String, Integer, String> other =
                triple.applySecond(s -> s.length());

        assertEquals((int)other.second(), "world".length());
    }

    @Test
    public void testApplyThird() {
        Triple<String, String, String> triple =
                new Triple<>("hello", "world", "!");

        Triple<String, String, Integer> other =
                triple.applyThird(s -> s.length());

        assertEquals((int)other.third(), "!".length());
    }

    @Test
    public void testEqualsIsTrueWhenEqual() {
        Triple<String, String, String> triple =
                new Triple<>("hello", "world", "!");
        Triple<String, String, String> other =
                new Triple<>("hello", "world", "!");

        assertTrue(triple.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenNotEqual() {
        Triple<String, String, String> triple =
                new Triple<>("hello", "world", "!");
        Triple<String, String, String> other =
                new Triple<>("goodbye", "world", "!");

        assertFalse(triple.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenTypesAreDifferent() {
        Triple<String, String, String> triple =
                new Triple<>("hello", "world", "!");
        Triple<String, String, Integer> other =
                new Triple<>("hello", "world", 123);

        assertFalse(triple.equals(other));
    }

    @Test
    public void testHashCodeIsTheSameForEqualTriples() {
        Triple<String, String, String> triple =
                new Triple<>("hello", "world", "!");
        Triple<String, String, String> other =
                new Triple<>("hello", "world", "!");

        assertEquals(triple.hashCode(), other.hashCode());
    }

    @Test
    public void testShiftLeftReturnsNew() {
        Triple<String, String, String> triple =
                new Triple<>("hello", "world", "!");
        Triple<String, String, String> other = triple.shiftLeft();

        assertNotEquals(triple, other);
    }

    @Test
    public void testShiftLeft() {
        Triple<String, String, String> triple =
                new Triple<>("hello", "world", "!");
        Triple<String, String, String> other = triple.shiftLeft();

        assertEquals(triple.second(), other.first());
        assertEquals(triple.third(), other.second());
        assertEquals(triple.first(), other.third());
    }

    @Test
    public void testShiftRightReturnsNew() {
        Triple<String, String, String> triple =
                new Triple<>("hello", "world", "!");
        Triple<String, String, String> other = triple.shiftRight();

        assertNotEquals(triple, other);
    }

    @Test
    public void testShiftRight() {
        Triple<String, String, String> triple =
                new Triple<>("hello", "world", "!");
        Triple<String, String, String> other = triple.shiftRight();

        assertEquals(triple.third(), other.first());
        assertEquals(triple.first(), other.second());
        assertEquals(triple.second(), other.third());
    }
}
