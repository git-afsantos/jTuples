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
public class QuintupleTest {
    private Quintuple<String, String, String, String, String> quintuple;
    private Quintuple<String, String, String, String, String> expected;
    private Quintuple<String, String, String, String, String> result;
    
    @Before
    public void setup() {
        quintuple = new Quintuple<>("1", "2", "3", "4", "5");
    }

    @Test
    public void testArity() {
        assertEquals(5, quintuple.arity());
    }

    @Test
    public void testFirst() {
        assertEquals("1", quintuple.first());
    }

    @Test
    public void testFirstCanBeNull() {
        assertNull(nullQuintuple().first());
    }

    @Test
    public void testSecond() {
        assertEquals("2", quintuple.second());
    }

    @Test
    public void testSecondCanBeNull() {
        assertNull(nullQuintuple().second());
    }

    @Test
    public void testThird() {
        assertEquals("3", quintuple.third());
    }

    @Test
    public void testThirdCanBeNull() {
        assertNull(nullQuintuple().third());
    }

    @Test
    public void testFourth() {
        assertEquals("4", quintuple.fourth());
    }

    @Test
    public void testFourthCanBeNull() {
        assertNull(nullQuintuple().fourth());
    }
    
    @Test
    public void testFifth() {
        assertEquals("5", quintuple.fifth());
    }

    @Test
    public void testFifthCanBeNull() {
        assertNull(nullQuintuple().fifth());
    }

    @Test
    public void testInvert() {
        expected = new Quintuple("5", "4", "3", "2", "1");
        
        result = quintuple.invert();

        assertEquals(expected, result);
    }

    @Test
    public void testShiftLeft() {
        expected = new Quintuple<>("2", "3", "4", "5", "1");
        
        result = quintuple.shiftLeft();
        
        assertEquals(expected, result);
    }

    @Test
    public void testShiftRight() {
        expected = new Quintuple<>("5", "1", "2", "3", "4");
        
        result = quintuple.shiftRight();
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testToArray() {
        Object[] expectedArray = new Object[] { "1", "2", "3", "4", "5" };
        
        Object[] resultArray = quintuple.toArray();
        
        assertArrayEquals(expectedArray, resultArray);
    }
    
    @Test
    public void testApplyFirst() {
        result = quintuple.applyFirst(s -> s + s);

        assertEquals(result.first(), "11");
    }

    @Test
    public void testApplySecond() {
        result = quintuple.applySecond(s -> s + s);

        assertEquals(result.second(), "22");
    }

    @Test
    public void testApplyThird() {
        result = quintuple.applyThird(s -> s + s);

        assertEquals(result.third(), "33");
    }

    @Test
    public void testApplyFourth() {
        result = quintuple.applyFourth(s -> s + s);

        assertEquals(result.fourth(), "44");
    }

    @Test
    public void testApplyFifth() {
        result = quintuple.applyFifth(s -> s + s);

        assertEquals(result.fifth(), "55");
    }

    @Test
    public void testEqualsIsTrueWhenEqual() {
        Tuple other = new Quintuple<>("1", "2", "3", "4", "5");
        
        assertTrue(quintuple.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenNotEqual() {
        Tuple other = new Quintuple<>("2", "1", "3", "4", "5");
        
        assertFalse(quintuple.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenTypesAreDifferent() {
        Tuple other = new Quintuple<>("1", "2", "3", "4", 123);
        
        assertFalse(quintuple.equals(other));
    }

    @Test
    public void testHashCodeIsTheSameForEqualQuintuples() {
        Tuple other = new Quintuple<>("1", "2", "3", "4", "5");
        
        assertEquals(other.hashCode(), quintuple.hashCode());
    }
    
    private Quintuple<Object, Object, Object, Object, Object> nullQuintuple() {
        return new Quintuple<>(null, null, null, null, null);
    }
    
}
