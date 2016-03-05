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
 * @author Andre Santos <contact.andre.santos@gmail.com>
 */
public class NonupleTest {
    private Nonuple<String, String, String, String,
            String, String, String, String, String> nonuple;
    private Nonuple<String, String, String, String,
            String, String, String, String, String> expected;
    private Nonuple<String, String, String, String,
            String, String, String, String, String> result;
    
    @Before
    public void setUp() {
        nonuple = new Nonuple<>("1", "2", "3", "4", "5", "6", "7", "8", "9");
    }

    @Test
    public void testArity() {
        assertEquals(9, nonuple.arity());
    }

    @Test
    public void testFirst() {
        assertEquals("1", nonuple.first());
    }

    @Test
    public void testFirstCanBeNull() {
        assertNull(nullNonuple().first());
    }

    @Test
    public void testSecond() {
        assertEquals("2", nonuple.second());
    }

    @Test
    public void testSecondCanBeNull() {
        assertNull(nullNonuple().second());
    }

    @Test
    public void testThird() {
        assertEquals("3", nonuple.third());
    }

    @Test
    public void testThirdCanBeNull() {
        assertNull(nullNonuple().third());
    }

    @Test
    public void testFourth() {
        assertEquals("4", nonuple.fourth());
    }

    @Test
    public void testFourthCanBeNull() {
        assertNull(nullNonuple().fourth());
    }
    
    @Test
    public void testFifth() {
        assertEquals("5", nonuple.fifth());
    }

    @Test
    public void testFifthCanBeNull() {
        assertNull(nullNonuple().fifth());
    }
    
    @Test
    public void testSixth() {
        assertEquals("6", nonuple.sixth());
    }

    @Test
    public void testSixthCanBeNull() {
        assertNull(nullNonuple().sixth());
    }
    
    @Test
    public void testSeventh() {
        assertEquals("7", nonuple.seventh());
    }

    @Test
    public void testSeventhCanBeNull() {
        assertNull(nullNonuple().seventh());
    }
    
    @Test
    public void testEighth() {
        assertEquals("8", nonuple.eighth());
    }

    @Test
    public void testEighthCanBeNull() {
        assertNull(nullNonuple().eighth());
    }
    
    @Test
    public void testNinth() {
        assertEquals("9", nonuple.ninth());
    }

    @Test
    public void testNinthCanBeNull() {
        assertNull(nullNonuple().ninth());
    }

    @Test
    public void testInvert() {
        expected = new Nonuple<>("9", "8", "7", "6", "5", "4", "3", "2", "1");

        result = nonuple.invert();

        assertEquals(expected, result);
    }

    @Test
    public void testShiftLeft() {
        expected = new Nonuple<>("2", "3", "4", "5", "6", "7", "8", "9", "1");

        result = nonuple.shiftLeft();

        assertEquals(expected, result);
    }

    @Test
    public void testShiftLeftReturnsNew() {
        assertNotEquals(nonuple, nonuple.shiftLeft());
    }

    @Test
    public void testShiftLeftWithValue() {
        expected = new Nonuple<>("2", "3", "4", "5", "6", "7", "8", "9", "10");

        assertEquals(expected, nonuple.shiftLeft("10"));
    }

    @Test
    public void testShiftLeftWithValueReturnsNew() {
        assertNotEquals(nonuple, nonuple.shiftLeft("10"));
    }

    @Test
    public void testShiftLeftWithNull() {
        expected = new Nonuple<>("2", "3", "4", "5", "6", "7", "8", "9", null);

        assertEquals(expected, nonuple.shiftLeft(null));
    }

    @Test
    public void testShiftRight() {
        expected = new Nonuple<>("9", "1", "2", "3", "4", "5", "6", "7", "8");

        result = nonuple.shiftRight();

        assertEquals(expected, result);
    }

    @Test
    public void testShiftRightReturnsNew() {
        assertNotEquals(nonuple, nonuple.shiftRight());
    }

    @Test
    public void testShiftRightWithValue() {
        expected = new Nonuple<>("0", "1", "2", "3", "4", "5", "6", "7", "8");

        assertEquals(expected, nonuple.shiftRight("0"));
    }

    @Test
    public void testShiftRightWithValueReturnsNew() {
        assertNotEquals(nonuple, nonuple.shiftRight("0"));
    }

    @Test
    public void testShiftRightWithNull() {
        expected = new Nonuple<>(null, "1", "2", "3", "4", "5", "6", "7", "8");

        assertEquals(expected, nonuple.shiftRight(null));
    }

    @Test
    public void testToArray() {
        Object[] expectedArray = new Object[] {
            "1", "2", "3", "4", "5", "6", "7", "8", "9"
        };

        Object[] resultArray = nonuple.toArray();

        assertArrayEquals(expectedArray, resultArray);
    }
    
    @Test
    public void testApplyFirst() {
        result = nonuple.applyFirst(s -> s + s);

        assertEquals("11", result.first());
    }

    @Test
    public void testApplySecond() {
        result = nonuple.applySecond(s -> s + s);

        assertEquals("22", result.second());
    }

    @Test
    public void testApplyThird() {
        result = nonuple.applyThird(s -> s + s);

        assertEquals("33", result.third());
    }

    @Test
    public void testApplyFourth() {
        result = nonuple.applyFourth(s -> s + s);

        assertEquals("44", result.fourth());
    }

    @Test
    public void testApplyFifth() {
        result = nonuple.applyFifth(s -> s + s);

        assertEquals("55", result.fifth());
    }

    @Test
    public void testApplySixth() {
        result = nonuple.applySixth(s -> s + s);

        assertEquals("66", result.sixth());
    }

    @Test
    public void testApplySeventh() {
        result = nonuple.applySeventh(s -> s + s);

        assertEquals("77", result.seventh());
    }

    @Test
    public void testApplyEighth() {
        result = nonuple.applyEighth(s -> s + s);

        assertEquals("88", result.eighth());
    }

    @Test
    public void testApplyNinth() {
        result = nonuple.applyNinth(s -> s + s);

        assertEquals("99", result.ninth());
    }

    @Test
    public void testEqualsIsTrueWhenEqual() {
        Tuple other = new Nonuple<>("1", "2", "3", "4", "5", "6", "7", "8", "9");

        assertTrue(nonuple.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenNotEqual() {
        Tuple other = new Nonuple<>("2", "1", "3", "4", "5", "6", "7", "8", "9");

        assertFalse(nonuple.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenTypesAreDifferent() {
        Tuple other = new Nonuple<>("1", "2", "3", "4", "5", "6", "7", "8", 123);

        assertFalse(nonuple.equals(other));
    }

    @Test
    public void testHashCodeIsTheSameForEqualTuples() {
        Tuple other = new Nonuple<>("1", "2", "3", "4", "5", "6", "7", "8", "9");

        assertEquals(other.hashCode(), nonuple.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("(1, 2, 3, 4, 5, 6, 7, 8, 9)", nonuple.toString());
    }

    private Nonuple<Object, Object, Object, Object,
    		Object, Object, Object, Object, Object> nullNonuple() {
        return new Nonuple<>();
    }

}
