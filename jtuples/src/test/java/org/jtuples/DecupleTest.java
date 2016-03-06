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
public class DecupleTest {
    private Decuple<String, String, String, String,
            String, String, String, String, String, String> decuple;
    private Decuple<String, String, String, String,
            String, String, String, String, String, String> expected;
    private Decuple<String, String, String, String,
            String, String, String, String, String, String> result;
    
    @Before
    public void setUp() {
        decuple = new Decuple<>("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    }

    @Test
    public void testArity() {
        assertEquals(10, decuple.arity());
    }

    @Test
    public void testFirst() {
        assertEquals("1", decuple.first());
    }

    @Test
    public void testFirstCanBeNull() {
        assertNull(nullDecuple().first());
    }

    @Test
    public void testSecond() {
        assertEquals("2", decuple.second());
    }

    @Test
    public void testSecondCanBeNull() {
        assertNull(nullDecuple().second());
    }

    @Test
    public void testThird() {
        assertEquals("3", decuple.third());
    }

    @Test
    public void testThirdCanBeNull() {
        assertNull(nullDecuple().third());
    }

    @Test
    public void testFourth() {
        assertEquals("4", decuple.fourth());
    }

    @Test
    public void testFourthCanBeNull() {
        assertNull(nullDecuple().fourth());
    }
    
    @Test
    public void testFifth() {
        assertEquals("5", decuple.fifth());
    }

    @Test
    public void testFifthCanBeNull() {
        assertNull(nullDecuple().fifth());
    }
    
    @Test
    public void testSixth() {
        assertEquals("6", decuple.sixth());
    }

    @Test
    public void testSixthCanBeNull() {
        assertNull(nullDecuple().sixth());
    }
    
    @Test
    public void testSeventh() {
        assertEquals("7", decuple.seventh());
    }

    @Test
    public void testSeventhCanBeNull() {
        assertNull(nullDecuple().seventh());
    }
    
    @Test
    public void testEighth() {
        assertEquals("8", decuple.eighth());
    }

    @Test
    public void testEighthCanBeNull() {
        assertNull(nullDecuple().eighth());
    }
    
    @Test
    public void testNinth() {
        assertEquals("9", decuple.ninth());
    }

    @Test
    public void testNinthCanBeNull() {
        assertNull(nullDecuple().ninth());
    }
    
    @Test
    public void testTenth() {
        assertEquals("10", decuple.tenth());
    }

    @Test
    public void testTenthCanBeNull() {
        assertNull(nullDecuple().tenth());
    }

    @Test
    public void testInvert() {
        expected = new Decuple<>("10", "9", "8", "7", "6", "5", "4", "3", "2", "1");

        result = decuple.invert();

        assertEquals(expected, result);
    }

    @Test
    public void testShiftLeft() {
        expected = new Decuple<>("2", "3", "4", "5", "6", "7", "8", "9", "10", "1");

        result = decuple.shiftLeft();

        assertEquals(expected, result);
    }

    @Test
    public void testShiftLeftReturnsNew() {
        assertNotEquals(decuple, decuple.shiftLeft());
    }

    @Test
    public void testShiftLeftWithValue() {
        expected = new Decuple<>("2", "3", "4", "5", "6", "7", "8", "9", "10", "11");

        assertEquals(expected, decuple.shiftLeft("11"));
    }

    @Test
    public void testShiftLeftWithValueReturnsNew() {
        assertNotEquals(decuple, decuple.shiftLeft("11"));
    }

    @Test
    public void testShiftLeftWithNull() {
        expected = new Decuple<>("2", "3", "4", "5", "6", "7", "8", "9", "10", null);

        assertEquals(expected, decuple.shiftLeft(null));
    }

    @Test
    public void testShiftRight() {
        expected = new Decuple<>("10", "1", "2", "3", "4", "5", "6", "7", "8", "9");

        result = decuple.shiftRight();

        assertEquals(expected, result);
    }

    @Test
    public void testShiftRightReturnsNew() {
        assertNotEquals(decuple, decuple.shiftRight());
    }

    @Test
    public void testShiftRightWithValue() {
        expected = new Decuple<>("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

        assertEquals(expected, decuple.shiftRight("0"));
    }

    @Test
    public void testShiftRightWithValueReturnsNew() {
        assertNotEquals(decuple, decuple.shiftRight("0"));
    }

    @Test
    public void testShiftRightWithNull() {
        expected = new Decuple<>(null, "1", "2", "3", "4", "5", "6", "7", "8", "9");

        assertEquals(expected, decuple.shiftRight(null));
    }

    @Test
    public void testToArray() {
        Object[] expectedArray = new Object[] {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
        };

        Object[] resultArray = decuple.toArray();

        assertArrayEquals(expectedArray, resultArray);
    }
    
    @Test
    public void testApplyFirst() {
        result = decuple.applyFirst(s -> s + s);

        assertEquals("11", result.first());
    }

    @Test
    public void testApplySecond() {
        result = decuple.applySecond(s -> s + s);

        assertEquals("22", result.second());
    }

    @Test
    public void testApplyThird() {
        result = decuple.applyThird(s -> s + s);

        assertEquals("33", result.third());
    }

    @Test
    public void testApplyFourth() {
        result = decuple.applyFourth(s -> s + s);

        assertEquals("44", result.fourth());
    }

    @Test
    public void testApplyFifth() {
        result = decuple.applyFifth(s -> s + s);

        assertEquals("55", result.fifth());
    }

    @Test
    public void testApplySixth() {
        result = decuple.applySixth(s -> s + s);

        assertEquals("66", result.sixth());
    }

    @Test
    public void testApplySeventh() {
        result = decuple.applySeventh(s -> s + s);

        assertEquals("77", result.seventh());
    }

    @Test
    public void testApplyEighth() {
        result = decuple.applyEighth(s -> s + s);

        assertEquals("88", result.eighth());
    }

    @Test
    public void testApplyNinth() {
        result = decuple.applyNinth(s -> s + s);

        assertEquals("99", result.ninth());
    }

    @Test
    public void testApplyTenth() {
        result = decuple.applyTenth(s -> s + s);

        assertEquals("1010", result.tenth());
    }

    @Test
    public void testToString() {
        assertEquals("(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)", decuple.toString());
    }

    private Decuple<Object, Object, Object, Object, Object,
    		Object, Object, Object, Object, Object> nullDecuple() {
        return new Decuple<>();
    }

}
