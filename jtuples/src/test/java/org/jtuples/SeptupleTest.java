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
public class SeptupleTest {
    private Septuple<String, String, String, String,
            String, String, String> septuple;
    private Septuple<String, String, String, String,
            String, String, String> expected;
    private Septuple<String, String, String, String,
            String, String, String> result;
    
    @Before
    public void setUp() {
        septuple = new Septuple<>("1", "2", "3", "4", "5", "6", "7");
    }

    @Test
    public void testArity() {
        assertEquals(7, septuple.arity());
    }

    @Test
    public void testFirst() {
        assertEquals("1", septuple.first());
    }

    @Test
    public void testFirstCanBeNull() {
        assertNull(nullSeptuple().first());
    }

    @Test
    public void testSecond() {
        assertEquals("2", septuple.second());
    }

    @Test
    public void testSecondCanBeNull() {
        assertNull(nullSeptuple().second());
    }

    @Test
    public void testThird() {
        assertEquals("3", septuple.third());
    }

    @Test
    public void testThirdCanBeNull() {
        assertNull(nullSeptuple().third());
    }

    @Test
    public void testFourth() {
        assertEquals("4", septuple.fourth());
    }

    @Test
    public void testFourthCanBeNull() {
        assertNull(nullSeptuple().fourth());
    }
    
    @Test
    public void testFifth() {
        assertEquals("5", septuple.fifth());
    }

    @Test
    public void testFifthCanBeNull() {
        assertNull(nullSeptuple().fifth());
    }
    
    @Test
    public void testSixth() {
        assertEquals("6", septuple.sixth());
    }

    @Test
    public void testSixthCanBeNull() {
        assertNull(nullSeptuple().sixth());
    }
    
    @Test
    public void testSeventh() {
        assertEquals("7", septuple.seventh());
    }

    @Test
    public void testSeventhCanBeNull() {
        assertNull(nullSeptuple().seventh());
    }

    @Test
    public void testInvert() {
        expected = new Septuple("7", "6", "5", "4", "3", "2", "1");
        
        result = septuple.invert();

        assertEquals(expected, result);
    }

    @Test
    public void testShiftLeft() {
        expected = new Septuple<>("2", "3", "4", "5", "6", "7", "1");
        
        result = septuple.shiftLeft();
        
        assertEquals(expected, result);
    }

    @Test
    public void testShiftLeftReturnsNew() {
        assertNotEquals(septuple, septuple.shiftLeft());
    }

    @Test
    public void testShiftLeftWithValue() {
        expected = new Septuple<>("2", "3", "4", "5", "6", "7", "8");

        assertEquals(expected, septuple.shiftLeft("8"));
    }

    @Test
    public void testShiftLeftWithValueReturnsNew() {
        assertNotEquals(septuple, septuple.shiftLeft("8"));
    }

    @Test
    public void testShiftLeftWithNull() {
        expected = new Septuple<>("2", "3", "4", "5", "6", "7", null);

        assertEquals(expected, septuple.shiftLeft(null));
    }

    @Test
    public void testShiftRight() {
        expected = new Septuple<>("7", "1", "2", "3", "4", "5", "6");
        
        result = septuple.shiftRight();
        
        assertEquals(expected, result);
    }

    @Test
    public void testShiftRightReturnsNew() {
        assertNotEquals(septuple, septuple.shiftRight());
    }

    @Test
    public void testShiftRightWithValue() {
        expected = new Septuple<>("0", "1", "2", "3", "4", "5", "6");

        assertEquals(expected, septuple.shiftRight("0"));
    }

    @Test
    public void testShiftRightWithValueReturnsNew() {
        assertNotEquals(septuple, septuple.shiftRight("0"));
    }

    @Test
    public void testShiftRightWithNull() {
        expected = new Septuple<>(null, "1", "2", "3", "4", "5", "6");

        assertEquals(expected, septuple.shiftRight(null));
    }

    @Test
    public void testToArray() {
        Object[] expectedArray = new Object[] {
            "1", "2", "3", "4", "5", "6", "7"
        };
        
        Object[] resultArray = septuple.toArray();
        
        assertArrayEquals(expectedArray, resultArray);
    }
    
    @Test
    public void testApplyFirst() {
        result = septuple.applyFirst(s -> s + s);

        assertEquals("11", result.first());
    }

    @Test
    public void testApplySecond() {
        result = septuple.applySecond(s -> s + s);

        assertEquals("22", result.second());
    }

    @Test
    public void testApplyThird() {
        result = septuple.applyThird(s -> s + s);

        assertEquals("33", result.third());
    }

    @Test
    public void testApplyFourth() {
        result = septuple.applyFourth(s -> s + s);

        assertEquals("44", result.fourth());
    }

    @Test
    public void testApplyFifth() {
        result = septuple.applyFifth(s -> s + s);

        assertEquals("55", result.fifth());
    }

    @Test
    public void testApplySixth() {
        result = septuple.applySixth(s -> s + s);

        assertEquals("66", result.sixth());
    }

    @Test
    public void testApplySeventh() {
        result = septuple.applySeventh(s -> s + s);

        assertEquals("77", result.seventh());
    }

    @Test
    public void testEqualsIsTrueWhenEqual() {
        Tuple other = new Septuple<>("1", "2", "3", "4", "5", "6", "7");
        
        assertTrue(septuple.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenNotEqual() {
        Tuple other = new Septuple<>("2", "1", "3", "4", "5", "6", "7");
        
        assertFalse(septuple.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenTypesAreDifferent() {
        Tuple other = new Septuple<>("1", "2", "3", "4", "5", "6", 123);
        
        assertFalse(septuple.equals(other));
    }

    @Test
    public void testHashCodeIsTheSameForEqualTuples() {
        Tuple other = new Septuple<>("1", "2", "3", "4", "5", "6", "7");
        
        assertEquals(other.hashCode(), septuple.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("(1, 2, 3, 4, 5, 6, 7)", septuple.toString());
    }

    private Septuple nullSeptuple() {
        return new Septuple();
    }
    
}
