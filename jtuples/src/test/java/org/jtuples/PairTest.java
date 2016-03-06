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
import org.junit.Before;

/**
 * @author Benjamim Sonntag
 */
public class PairTest {
    private Pair<String, String> pair;
    private Pair<String, String> expected;
    private Pair<String, String> result;
    
    @Before
    public void setup() {
        pair = new Pair<>("1", "2");
    }

    @Test
    public void testArity() {
        assertEquals(2, pair.arity());
    }

    @Test
    public void testFirst() {
        assertEquals("1", pair.first());
    }

    @Test
    public void testFirstCanBeNull() {
        assertNull(nullPair().first());
    }

    @Test
    public void testSecond() {
        assertEquals("2", pair.second());
    }

    @Test
    public void testSecondCanBeNull() {
        assertNull(nullPair().second());
    }

    @Test
    public void testInvert() {
        expected = new Pair<>("2", "1");

        assertEquals(expected, pair.invert());
    }

    @Test
    public void testApplyFirst() {
        result = pair.applyFirst(s -> s + s);

        assertEquals("11", result.first());
    }

    @Test
    public void testApplySecond() {
        result = pair.applySecond(s -> s + s);

        assertEquals("22", result.second());
    }

    @Test
    public void testEqualsIsTrueWhenEqual() {
        Tuple other = new Pair<>("1", "2");

        assertTrue(pair.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenNotEqual() {
        Tuple other = new Pair<>("2", "1");

        assertFalse(pair.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenTypesAreDifferent() {
        Tuple other = new Pair<>("1", 123);

        assertFalse(pair.equals(other));
    }

    @Test
    public void testHashCodeIsTheSameForEqualTuples() {
       Tuple other = new Pair<>("1", "2");

        assertEquals(other.hashCode(), pair.hashCode());
    }

    @Test
    public void testApply() {
        boolean testResult = pair.apply((a, b) -> {
            return "1".equals(a) && "2".equals(b);
        });
        
        assertTrue(testResult);
    }

    @Test
    public void testShiftLeft() {
        expected = new Pair<>("2", "1");

        assertEquals(expected, pair.shiftLeft());
    }

    @Test
    public void testShiftLeftReturnsNew() {
        assertNotEquals(pair, pair.shiftLeft());
    }

    @Test
    public void testShiftLeftWithValue() {
        expected = new Pair<>("2", "3");

        assertEquals(expected, pair.shiftLeft("3"));
    }

    @Test
    public void testShiftLeftWithValueReturnsNew() {
        assertNotEquals(pair, pair.shiftLeft("3"));
    }

    @Test
    public void testShiftLeftWithNull() {
        expected = new Pair<>("2", null);

        assertEquals(expected, pair.shiftLeft(null));
    }

    @Test
    public void testShiftRight() {
        expected = new Pair<>("2", "1");

        assertEquals(expected, pair.shiftRight());
    }

    @Test
    public void testShiftRightReturnsNew() {
        assertNotEquals(pair, pair.shiftRight());
    }

    @Test
    public void testShiftRightWithValue() {
        expected = new Pair<>("0", "1");

        assertEquals(expected, pair.shiftRight("0"));
    }

    @Test
    public void testShiftRightWithValueReturnsNew() {
        assertNotEquals(pair, pair.shiftRight("0"));
    }

    @Test
    public void testShiftRightWithNull() {
        expected = new Pair<>(null, "1");

        assertEquals(expected, pair.shiftRight(null));
    }
    
    @Test
    public void testToArray() {
        String[] expectedArray = new String[] { "1", "2" };
        
        assertArrayEquals(expectedArray, pair.toArray());
    }

    @Test
    public void testToString() {
        assertEquals("(1, 2)", pair.toString());
    }

    private Pair<Object, Object> nullPair() {
        return new Pair<>();
    }
}
