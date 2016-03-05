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

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Benjamim Sonntag <benjamimsonntag@gmail.com>
 */
public class SextupleTest {
    private Sextuple<String, String, String, String, String, String> sextuple;
    private Sextuple<String, String, String, String, String, String> expected;
    private Sextuple<String, String, String, String, String, String> result;
    
    @Before
    public void setUp() {
        sextuple = new Sextuple<>("1", "2", "3", "4", "5", "6");
    }

    @Test
    public void testArity() {
        assertEquals(6, sextuple.arity());
    }

    @Test
    public void testFirst() {
        assertEquals("1", sextuple.first());
    }

    @Test
    public void testFirstCanBeNull() {
        assertNull(nullSextuple().first());
    }

    @Test
    public void testSecond() {
        assertEquals("2", sextuple.second());
    }

    @Test
    public void testSecondCanBeNull() {
        assertNull(nullSextuple().second());
    }

    @Test
    public void testThird() {
        assertEquals("3", sextuple.third());
    }

    @Test
    public void testThirdCanBeNull() {
        assertNull(nullSextuple().third());
    }

    @Test
    public void testFourth() {
        assertEquals("4", sextuple.fourth());
    }

    @Test
    public void testFourthCanBeNull() {
        assertNull(nullSextuple().fourth());
    }
    
    @Test
    public void testFifth() {
        assertEquals("5", sextuple.fifth());
    }

    @Test
    public void testFifthCanBeNull() {
        assertNull(nullSextuple().fifth());
    }
    
    @Test
    public void testSixth() {
        assertEquals("6", sextuple.sixth());
    }

    @Test
    public void testSixthCanBeNull() {
        assertNull(nullSextuple().sixth());
    }

    @Test
    public void testInvert() {
        expected = new Sextuple<>("6", "5", "4", "3", "2", "1");
        
        result = sextuple.invert();

        assertEquals(expected, result);
    }

    @Test
    public void testShiftLeft() {
        expected = new Sextuple<>("2", "3", "4", "5", "6", "1");
        
        result = sextuple.shiftLeft();
        
        assertEquals(expected, result);
    }

    @Test
    public void testShiftLeftReturnsNew() {
        assertNotEquals(sextuple, sextuple.shiftLeft());
    }

    @Test
    public void testShiftLeftWithValue() {
        expected = new Sextuple<>("2", "3", "4", "5", "6", "7");

        assertEquals(expected, sextuple.shiftLeft("7"));
    }

    @Test
    public void testShiftLeftWithValueReturnsNew() {
        assertNotEquals(sextuple, sextuple.shiftLeft("3"));
    }

    @Test
    public void testShiftLeftWithNull() {
        expected = new Sextuple<>("2", "3", "4", "5", "6", null);

        assertEquals(expected, sextuple.shiftLeft(null));
    }

    @Test
    public void testShiftRight() {
        expected = new Sextuple<>("6", "1", "2", "3", "4", "5");
        
        result = sextuple.shiftRight();
        
        assertEquals(expected, result);
    }

    @Test
    public void testShiftRightReturnsNew() {
        assertNotEquals(sextuple, sextuple.shiftRight());
    }

    @Test
    public void testShiftRightWithValue() {
        expected = new Sextuple<>("0", "1", "2", "3", "4", "5");

        assertEquals(expected, sextuple.shiftRight("0"));
    }

    @Test
    public void testShiftRightWithValueReturnsNew() {
        assertNotEquals(sextuple, sextuple.shiftRight("0"));
    }

    @Test
    public void testShiftRightWithNull() {
        expected = new Sextuple<>(null, "1", "2", "3", "4", "5");

        assertEquals(expected, sextuple.shiftRight(null));
    }

    @Test
    public void testToArray() {
        Object[] expectedArray = new Object[] { "1", "2", "3", "4", "5", "6" };
        
        Object[] resultArray = sextuple.toArray();
        
        assertArrayEquals(expectedArray, resultArray);
    }
    
    @Test
    public void testApplyFirst() {
        result = sextuple.applyFirst(s -> s + s);

        assertEquals("11", result.first());
    }

    @Test
    public void testApplySecond() {
        result = sextuple.applySecond(s -> s + s);

        assertEquals("22", result.second());
    }

    @Test
    public void testApplyThird() {
        result = sextuple.applyThird(s -> s + s);

        assertEquals("33", result.third());
    }

    @Test
    public void testApplyFourth() {
        result = sextuple.applyFourth(s -> s + s);

        assertEquals("44", result.fourth());
    }

    @Test
    public void testApplyFifth() {
        result = sextuple.applyFifth(s -> s + s);

        assertEquals("55", result.fifth());
    }

    @Test
    public void testApplySixth() {
        result = sextuple.applySixth(s -> s + s);

        assertEquals("66", result.sixth());
    }

    @Test
    public void testEqualsIsTrueWhenEqual() {
        Tuple other = new Sextuple<>("1", "2", "3", "4", "5", "6");
        
        assertTrue(sextuple.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenNotEqual() {
        Tuple other = new Sextuple<>("2", "1", "3", "4", "5", "6");
        
        assertFalse(sextuple.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenTypesAreDifferent() {
        Tuple other = new Sextuple<>("1", "2", "3", "4", "5", 123);
        
        assertFalse(sextuple.equals(other));
    }

    @Test
    public void testHashCodeIsTheSameForEqualTuples() {
        Tuple other = new Sextuple<>("1", "2", "3", "4", "5", "6");
        
        assertEquals(other.hashCode(), sextuple.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("(1, 2, 3, 4, 5, 6)", sextuple.toString());
    }

    private Sextuple<Object, Object, Object, Object, Object, Object> nullSextuple() {
        return new Sextuple<>();
    }
    
}
