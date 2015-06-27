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
public class QuadrupleTest {
    private Quadruple<String, String, String, String> quadruple;
    private Quadruple<String, String, String, String> expected;
    private Quadruple<String, String, String, String> result;
    
    @Before
    public void setup() {
        quadruple = new Quadruple<>("1", "2", "3", "4");
    }

    @Test
    public void testArity() {
        assertEquals(4, quadruple.arity());
    }

    @Test
    public void testFirst() {
        assertEquals("1", quadruple.first());
    }

    @Test
    public void testFirstCanBeNull() {
        assertNull(nullQuadruple().first());
    }

    @Test
    public void testSecond() {
        assertEquals("2", quadruple.second());
    }

    @Test
    public void testSecondCanBeNull() {
        assertNull(nullQuadruple().second());
    }

    @Test
    public void testThird() {
        assertEquals("3", quadruple.third());
    }

    @Test
    public void testThirdCanBeNull() {
        assertNull(nullQuadruple().third());
    }

    @Test
    public void testFourth() {
        assertEquals("4", quadruple.fourth());
    }

    @Test
    public void testFourthCanBeNull() {
        assertNull(nullQuadruple().fourth());
    }

    @Test
    public void testInvert() {
        expected = new Quadruple<>("4", "3", "2", "1");

        assertEquals(expected, quadruple.invert());
    }

    @Test
    public void testApplyFirst() {
        result = quadruple.applyFirst(s -> s + s);

        assertEquals("11", result.first());
    }

    @Test
    public void testApplySecond() {
        result = quadruple.applySecond(s -> s + s);

        assertEquals("22", result.second());
    }

    @Test
    public void testApplyThird() {
        result = quadruple.applyThird(s -> s + s);

        assertEquals("33", result.third());
    }

    @Test
    public void testApplyFourth() {
        result = quadruple.applyFourth(s -> s + s);

        assertEquals("44", result.fourth());
    }

    @Test
    public void testEqualsIsTrueWhenEqual() {
        Tuple other = new Quadruple<>("1", "2", "3", "4");

        assertTrue(quadruple.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenNotEqual() {
        Tuple other = new Quadruple<>("2", "1", "3", "4");

        assertFalse(quadruple.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenTypesAreDifferent() {
        Tuple other = new Quadruple<>("1", "2", "3", 123);

        assertFalse(quadruple.equals(other));
    }

    @Test
    public void testHashCodeIsTheSameForEqualTuples() {
        Tuple other = new Quadruple<>("1", "2", "3", "4");

        assertEquals(other.hashCode(), quadruple.hashCode());
    }

    @Test
    public void testShiftLeft() {
        expected = new Quadruple<>("2", "3", "4", "1");

        assertEquals(expected, quadruple.shiftLeft());
    }

    @Test
    public void testShiftLeftReturnsNew() {
        assertNotEquals(quadruple, quadruple.shiftLeft());
    }

    @Test
    public void testShiftLeftWithValue() {
        expected = new Quadruple<>("2", "3", "4", "5");

        assertEquals(expected, quadruple.shiftLeft("5"));
    }

    @Test
    public void testShiftLeftWithValueReturnsNew() {
        assertNotEquals(quadruple, quadruple.shiftLeft("5"));
    }

    @Test
    public void testShiftLeftWithNull() {
        expected = new Quadruple<>("2", "3", "4", null);

        assertEquals(expected, quadruple.shiftLeft(null));
    }

    @Test
    public void testShiftLeftWithNullReturnsNew() {
        assertNotEquals(quadruple, quadruple.shiftLeft(null));
    }

    @Test
    public void testShiftRight() {
        expected = new Quadruple<>("4", "1", "2", "3");

        assertEquals(expected, quadruple.shiftRight());
    }

    @Test
    public void testShiftRightReturnsNew() {
        assertNotEquals(quadruple, quadruple.shiftRight());
    }

    @Test
    public void testShiftRightWithValue() {
        expected = new Quadruple<>("0", "1", "2", "3");

        assertEquals(expected, quadruple.shiftRight("0"));
    }

    @Test
    public void testShiftRightWithValueReturnsNew() {
        assertNotEquals(quadruple, quadruple.shiftRight("0"));
    }

    @Test
    public void testShiftRightWithNull() {
        expected = new Quadruple<>(null, "1", "2", "3");

        assertEquals(expected, quadruple.shiftRight(null));
    }

    @Test
    public void testShiftRightWithNullReturnsNew() {
        assertNotEquals(quadruple, quadruple.shiftRight(null));
    }
    
    @Test
    public void testToArray() {
        String[] expectedArray = new String[] { "1", "2", "3", "4" };

        assertArrayEquals(expectedArray, quadruple.toArray());
    }
    
    private Quadruple<Object, Object, Object, Object> nullQuadruple() {
        return new Quadruple<>();
    }
}
