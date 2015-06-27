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
 * @author Benjamim Sonntag <benjamimsonntag@gmail.com>
 */
public class TripleTest {
    private Triple<String, String, String> triple;
    private Triple<String, String, String> expected;
    private Triple<String, String, String> result;
    
    @Before
    public void setup() {
        triple = new Triple<>("1", "2", "3");
    }

    @Test
    public void testArity() {
        assertEquals(3, triple.arity());
    }

    @Test
    public void testFirst() {
        assertEquals("1", triple.first());
    }

    @Test
    public void testFirstCanBeNull() {
        assertNull(nullTriple().first());
    }

    @Test
    public void testSecond() {
        assertEquals("2", triple.second());
    }

    @Test
    public void testSecondCanBeNull() {
        assertNull(nullTriple().second());
    }

    @Test
    public void testThird() {
        assertEquals("3", triple.third());
    }

    @Test
    public void testThirdCanBeNull() {
        assertNull(nullTriple().third());
    }

    @Test
    public void testInvert() {
        expected = new Triple<>("3", "2", "1");

        assertEquals(expected, triple.invert());
    }

    @Test
    public void testApplyFirst() {
        result = triple.applyFirst(s -> s + s);

        assertEquals("11", result.first());
    }

    @Test
    public void testApplySecond() {
        result = triple.applySecond(s -> s + s);

        assertEquals("22", result.second());
    }

    @Test
    public void testApplyThird() {
        result = triple.applyThird(s -> s + s);

        assertEquals("33", result.third());
    }

    @Test
    public void testEqualsIsTrueWhenEqual() {
        Tuple other = new Triple<>("1", "2", "3");

        assertTrue(triple.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenNotEqual() {
        Tuple other = new Triple<>("2", "1", "3");

        assertFalse(triple.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenTypesAreDifferent() {
        Tuple other = new Triple<>("1", "2", 123);

        assertFalse(triple.equals(other));
    }

    @Test
    public void testHashCodeIsTheSameForEqualTuples() {
        Tuple other = new Triple<>("1", "2", "3");

        assertEquals(other.hashCode(), triple.hashCode());
    }

    @Test
    public void testShiftLeft() {
        expected = new Triple<>("2", "3", "1");

        assertEquals(expected, triple.shiftLeft());
    }

    @Test
    public void testShiftLeftWithValue() {
        expected = new Triple<>("2", "3", "4");

        assertEquals(expected, triple.shiftLeft("4"));
    }

    @Test
    public void testShiftLeftWithValueReturnsNew() {
        assertNotEquals(triple, triple.shiftLeft("4"));
    }

    @Test
    public void testShiftLeftWithNull() {
        expected = new Triple<>("2", "3", null);

        assertEquals(expected, triple.shiftLeft(null));
    }

    @Test
    public void testShiftLeftWithNullReturnsNew() {
        assertNotEquals(triple, triple.shiftLeft(null));
    }

    @Test
    public void testShiftLeftReturnsNew() {
        assertNotEquals(triple, triple.shiftLeft());
    }

    @Test
    public void testShiftRight() {
        expected = new Triple<>("3", "1", "2");

        assertEquals(expected, triple.shiftRight());
    }

    @Test
    public void testShiftRightReturnsNew() {
        assertNotEquals(triple, triple.shiftRight());
    }

    @Test
    public void testShiftRightWithValue() {
        expected = new Triple<>("0", "1", "2");

        assertEquals(expected, triple.shiftRight("0"));
    }

    @Test
    public void testShiftRightWithValueReturnsNew() {
        assertNotEquals(triple, triple.shiftRight("0"));
    }

    @Test
    public void testShiftRightWithNull() {
        expected = new Triple<>(null, "1", "2");

        assertEquals(expected, triple.shiftRight(null));
    }

    @Test
    public void testShiftRightWithNullReturnsNew() {
        assertNotEquals(triple, triple.shiftRight(null));
    }
    
    @Test
    public void testToArray() {
        String[] expectedArray = new String[] { "1", "2", "3" };
        
        assertArrayEquals(expectedArray, triple.toArray());
    }
    
    private Triple<Object, Object, Object> nullTriple() {
        return new Triple<>();
    }
}
