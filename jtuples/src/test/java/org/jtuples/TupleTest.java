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

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Andre Santos <contact.andre.santos@gmail.com>
 */
public class TupleTest {
    @Test
    public void testEqualsIsTrueWhenSame() {
        Tuple pair = new Pair<>("1", "2");

        assertTrue(pair.equals(pair));
    }

    @Test
    public void testEqualsIsFalseWhenNotTuple() {
        Tuple pair = new Pair<>("1", "2");
        Object other = new Object();

        assertFalse(pair.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenAritiesAreDifferent() {
        Tuple pair = new Pair<>("1", "2");
        Tuple other = new Triple<>("1", "2", "3");

        assertFalse(pair.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenTypesAreDifferent() {
        Tuple pair = new Pair<>("1", "2");
        Tuple other = new Pair<>("1", 123);

        assertFalse(pair.equals(other));
    }

    @Test
    public void testHashCodeIsTheSameForEqualTuples() {
        Tuple pair = new Pair<>("1", "2");
    	Tuple other = new Pair<>("1", "2");

        assertEquals(other.hashCode(), pair.hashCode());
    }

    @Test
    public void testEqualsIsTrueWhenEqualPair() {
        Tuple pair = new Pair<>("1", "2");
        Tuple other = new Pair<>("1", "2");

        assertTrue(pair.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenNotEqualPair() {
        Tuple pair = new Pair<>("1", "2");
        Tuple other = new Pair<>("2", "1");

        assertFalse(pair.equals(other));
    }

    @Test
    public void testEqualsIsTrueWhenEqualTriple() {
        Tuple pair = new Triple<>("1", "2", "3");
        Tuple other = new Triple<>("1", "2", "3");

        assertTrue(pair.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenNotEqualTriple() {
        Tuple pair = new Triple<>("1", "2", "3");
        Tuple other = new Triple<>("2", "1", "3");

        assertFalse(pair.equals(other));
    }

    @Test
    public void testEqualsIsTrueWhenEqualQuadruple() {
        Tuple pair = new Quadruple<>("1", "2", "3", "4");
        Tuple other = new Quadruple<>("1", "2", "3", "4");

        assertTrue(pair.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenNotEqualQuadruple() {
        Tuple pair = new Quadruple<>("1", "2", "3", "4");
        Tuple other = new Quadruple<>("2", "1", "3", "4");

        assertFalse(pair.equals(other));
    }

    @Test
    public void testEqualsIsTrueWhenEqualQuintuple() {
        Tuple pair = new Quintuple<>("1", "2", "3", "4", "5");
        Tuple other = new Quintuple<>("1", "2", "3", "4", "5");

        assertTrue(pair.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenNotEqualQuintuple() {
        Tuple pair = new Quintuple<>("1", "2", "3", "4", "5");
        Tuple other = new Quintuple<>("2", "1", "3", "4", "5");

        assertFalse(pair.equals(other));
    }

    @Test
    public void testEqualsIsTrueWhenEqualSextuple() {
        Tuple pair = new Sextuple<>("1", "2", "3", "4", "5", "6");
        Tuple other = new Sextuple<>("1", "2", "3", "4", "5", "6");

        assertTrue(pair.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenNotEqualSextuple() {
        Tuple pair = new Sextuple<>("1", "2", "3", "4", "5", "6");
        Tuple other = new Sextuple<>("2", "1", "3", "4", "5", "6");

        assertFalse(pair.equals(other));
    }

    @Test
    public void testEqualsIsTrueWhenEqualSeptuple() {
        Tuple pair = new Septuple<>("1", "2", "3", "4", "5", "6", "7");
        Tuple other = new Septuple<>("1", "2", "3", "4", "5", "6", "7");

        assertTrue(pair.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenNotEqualSeptuple() {
        Tuple pair = new Septuple<>("1", "2", "3", "4", "5", "6", "7");
        Tuple other = new Septuple<>("2", "1", "3", "4", "5", "6", "7");

        assertFalse(pair.equals(other));
    }

    @Test
    public void testEqualsIsTrueWhenEqualOctuple() {
        Tuple pair = new Octuple<>("1", "2", "3", "4", "5", "6", "7", "8");
        Tuple other = new Octuple<>("1", "2", "3", "4", "5", "6", "7", "8");

        assertTrue(pair.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenNotEqualOctuple() {
        Tuple pair = new Octuple<>("1", "2", "3", "4", "5", "6", "7", "8");
        Tuple other = new Octuple<>("2", "1", "3", "4", "5", "6", "7", "8");

        assertFalse(pair.equals(other));
    }

    @Test
    public void testEqualsIsTrueWhenEqualNonuple() {
        Tuple pair = new Nonuple<>("1", "2", "3", "4", "5", "6", "7", "8", "9");
        Tuple other = new Nonuple<>("1", "2", "3", "4", "5", "6", "7", "8", "9");

        assertTrue(pair.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenNotEqualNonuple() {
        Tuple pair = new Nonuple<>("1", "2", "3", "4", "5", "6", "7", "8", "9");
        Tuple other = new Nonuple<>("2", "1", "3", "4", "5", "6", "7", "8", "9");

        assertFalse(pair.equals(other));
    }

    @Test
    public void testEqualsIsTrueWhenEqualDecuple() {
        Tuple pair = new Decuple<>("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        Tuple other = new Decuple<>("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        assertTrue(pair.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenNotEqualDecuple() {
        Tuple pair = new Decuple<>("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        Tuple other = new Decuple<>("2", "1", "3", "4", "5", "6", "7", "8", "9", "10");

        assertFalse(pair.equals(other));
    }
}
