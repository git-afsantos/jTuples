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
 * @author Andre Santos
 */
public class OctupleTest {
    private Octuple<String, String, String, String,
            String, String, String, String> octuple;
    private Octuple<String, String, String, String,
            String, String, String, String> expected;
    private Octuple<String, String, String, String,
            String, String, String, String> result;
    
    @Before
    public void setUp() {
        octuple = new Octuple<>("1", "2", "3", "4", "5", "6", "7", "8");
    }

    @Test
    public void testArity() {
        assertEquals(8, octuple.arity());
    }

    @Test
    public void testFirst() {
        assertEquals("1", octuple.first());
    }

    @Test
    public void testFirstCanBeNull() {
        assertNull(nullOctuple().first());
    }

    @Test
    public void testSecond() {
        assertEquals("2", octuple.second());
    }

    @Test
    public void testSecondCanBeNull() {
        assertNull(nullOctuple().second());
    }

    @Test
    public void testThird() {
        assertEquals("3", octuple.third());
    }

    @Test
    public void testThirdCanBeNull() {
        assertNull(nullOctuple().third());
    }

    @Test
    public void testFourth() {
        assertEquals("4", octuple.fourth());
    }

    @Test
    public void testFourthCanBeNull() {
        assertNull(nullOctuple().fourth());
    }
    
    @Test
    public void testFifth() {
        assertEquals("5", octuple.fifth());
    }

    @Test
    public void testFifthCanBeNull() {
        assertNull(nullOctuple().fifth());
    }
    
    @Test
    public void testSixth() {
        assertEquals("6", octuple.sixth());
    }

    @Test
    public void testSixthCanBeNull() {
        assertNull(nullOctuple().sixth());
    }
    
    @Test
    public void testSeventh() {
        assertEquals("7", octuple.seventh());
    }

    @Test
    public void testSeventhCanBeNull() {
        assertNull(nullOctuple().seventh());
    }
    
    @Test
    public void testEighth() {
        assertEquals("8", octuple.eighth());
    }

    @Test
    public void testEighthCanBeNull() {
        assertNull(nullOctuple().eighth());
    }

    @Test
    public void testInvert() {
        expected = new Octuple<>("8", "7", "6", "5", "4", "3", "2", "1");

        result = octuple.invert();

        assertEquals(expected, result);
    }

    @Test
    public void testShiftLeft() {
        expected = new Octuple<>("2", "3", "4", "5", "6", "7", "8", "1");

        result = octuple.shiftLeft();

        assertEquals(expected, result);
    }

    @Test
    public void testShiftLeftReturnsNew() {
        assertNotEquals(octuple, octuple.shiftLeft());
    }

    @Test
    public void testShiftLeftWithValue() {
        expected = new Octuple<>("2", "3", "4", "5", "6", "7", "8", "9");

        assertEquals(expected, octuple.shiftLeft("9"));
    }

    @Test
    public void testShiftLeftWithValueReturnsNew() {
        assertNotEquals(octuple, octuple.shiftLeft("9"));
    }

    @Test
    public void testShiftLeftWithNull() {
        expected = new Octuple<>("2", "3", "4", "5", "6", "7", "8", null);

        assertEquals(expected, octuple.shiftLeft(null));
    }

    @Test
    public void testShiftRight() {
        expected = new Octuple<>("8", "1", "2", "3", "4", "5", "6", "7");

        result = octuple.shiftRight();

        assertEquals(expected, result);
    }

    @Test
    public void testShiftRightReturnsNew() {
        assertNotEquals(octuple, octuple.shiftRight());
    }

    @Test
    public void testShiftRightWithValue() {
        expected = new Octuple<>("0", "1", "2", "3", "4", "5", "6", "7");

        assertEquals(expected, octuple.shiftRight("0"));
    }

    @Test
    public void testShiftRightWithValueReturnsNew() {
        assertNotEquals(octuple, octuple.shiftRight("0"));
    }

    @Test
    public void testShiftRightWithNull() {
        expected = new Octuple<>(null, "1", "2", "3", "4", "5", "6", "7");

        assertEquals(expected, octuple.shiftRight(null));
    }

    @Test
    public void testToArray() {
        Object[] expectedArray = new Object[] {
            "1", "2", "3", "4", "5", "6", "7", "8"
        };

        Object[] resultArray = octuple.toArray();

        assertArrayEquals(expectedArray, resultArray);
    }
    
    @Test
    public void testApplyFirst() {
        result = octuple.applyFirst(s -> s + s);

        assertEquals("11", result.first());
    }

    @Test
    public void testApplySecond() {
        result = octuple.applySecond(s -> s + s);

        assertEquals("22", result.second());
    }

    @Test
    public void testApplyThird() {
        result = octuple.applyThird(s -> s + s);

        assertEquals("33", result.third());
    }

    @Test
    public void testApplyFourth() {
        result = octuple.applyFourth(s -> s + s);

        assertEquals("44", result.fourth());
    }

    @Test
    public void testApplyFifth() {
        result = octuple.applyFifth(s -> s + s);

        assertEquals("55", result.fifth());
    }

    @Test
    public void testApplySixth() {
        result = octuple.applySixth(s -> s + s);

        assertEquals("66", result.sixth());
    }

    @Test
    public void testApplySeventh() {
        result = octuple.applySeventh(s -> s + s);

        assertEquals("77", result.seventh());
    }

    @Test
    public void testApplyEighth() {
        result = octuple.applyEighth(s -> s + s);

        assertEquals("88", result.eighth());
    }

    @Test
    public void testToString() {
        assertEquals("(1, 2, 3, 4, 5, 6, 7, 8)", octuple.toString());
    }

    private Octuple<Object, Object, Object, Object,
    		Object, Object, Object, Object> nullOctuple() {
        return new Octuple<>();
    }

}
