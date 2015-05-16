/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jtuples;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Benjamim Sonntag
 */
public class QuadrupleTest {

    @Test
    public void testArity() {
        Quadruple<String, String, String, String> quadruple = new Quadruple<>();
        
        assertEquals(quadruple.arity(), 4);
    }

    @Test
    public void testFirst() {
        Quadruple<String, String, String, String> quadruple =
                new Quadruple<>("a", "b", "c", "d");

        assertEquals(quadruple.first(), "a");
    }

    @Test
    public void testFirstCanBeNull() {
        Quadruple<Object, Object, Object, Object> quadruple =
                new Quadruple<>(null, null, null, null);

        assertNull(quadruple.first());
    }

    @Test
    public void testSecond() {
        Quadruple<String, String, String, String> quadruple =
                new Quadruple<>("a", "b", "c", "d");

        assertEquals(quadruple.second(), "b");
    }

    @Test
    public void testSecondCanBeNull() {
        Quadruple<Object, Object, Object, Object> quadruple =
                new Quadruple<>(null, null, null, null);

        assertNull(quadruple.second());
    }

    @Test
    public void testThird() {
        Quadruple<String, String, String, String> quadruple =
                new Quadruple<>("a", "b", "c", "d");

        assertEquals(quadruple.third(), "c");
    }

    @Test
    public void testThirdCanBeNull() {
        Quadruple<Object, Object, Object, Object> quadruple =
                new Quadruple<>(null, null, null, null);

        assertNull(quadruple.third());
    }

    @Test
    public void testForth() {
        Quadruple<String, String, String, String> quadruple =
                new Quadruple<>("a", "b", "c", "d");

        assertEquals(quadruple.fourth(), "d");
    }

    @Test
    public void testForthCanBeNull() {
        Quadruple<Object, Object, Object, Object> quadruple =
                new Quadruple<>(null, null, null, null);

        assertNull(quadruple.fourth());
    }

    @Test
    public void testInvert() {
        Quadruple<String, String, String, Integer> quadruple =
                new Quadruple<>("a", "b", "c", 123);

        Quadruple<Integer, String, String, String> other = quadruple.invert();

        assertEquals((int)other.first(), 123);
        assertEquals(other.second(), "c");
        assertEquals(other.third(), "b");
        assertEquals(other.fourth(), "a");
    }

    @Test
    public void testApplyFirst() {
        Quadruple<String, String, String, String> quadruple =
                new Quadruple<>("a", "b", "c", "d");

        Quadruple<String, String, String, String> other =
                quadruple.applyFirst(s -> s + s);

        assertEquals(other.first(), "aa");
    }

    @Test
    public void testApplySecond() {
        Quadruple<String, String, String, String> quadruple =
                new Quadruple<>("a", "b", "c", "d");

        Quadruple<String, String, String, String> other =
                quadruple.applySecond(s -> s + s);

        assertEquals(other.second(), "bb");
    }

    @Test
    public void testApplyThird() {
        Quadruple<String, String, String, String> quadruple =
                new Quadruple<>("a", "b", "c", "d");

        Quadruple<String, String, String, String> other =
                quadruple.applyThird(s -> s + s);

        assertEquals(other.third(), "cc");
    }

    @Test
    public void testApplyForth() {
        Quadruple<String, String, String, String> quadruple =
                new Quadruple<>("a", "b", "c", "d");

        Quadruple<String, String, String, String> other =
                quadruple.applyForth(s -> s + s);

        assertEquals(other.fourth(), "dd");
    }

    @Test
    public void testEqualsIsTrueWhenEqual() {
        Quadruple<String, String, String, String> quadruple =
                new Quadruple<>("a", "b", "c", "d");
        Quadruple<String, String, String, String> other =
                new Quadruple<>("a", "b", "c", "d");

        assertTrue(quadruple.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenNotEqual() {
        Quadruple<String, String, String, String> quadruple =
                new Quadruple<>("a", "b", "c", "d");
        Quadruple<String, String, String, String> other =
                new Quadruple<>("b", "a", "c", "d");

        assertFalse(quadruple.equals(other));
    }

    @Test
    public void testEqualsIsFalseWhenTypesAreDifferent() {
        Quadruple<String, String, String, String> quadruple =
                new Quadruple<>("a", "b", "c", "d");
        Quadruple<String, String, String, Integer> other =
                new Quadruple<>("b", "a", "c", 123);

        assertFalse(quadruple.equals(other));
    }

    @Test
    public void testHashCodeIsTheSameForEqualPairs() {
        Quadruple<String, String, String, String> quadruple =
                new Quadruple<>("a", "b", "c", "d");
        Quadruple<String, String, String, String> other =
                new Quadruple<>("a", "b", "c", "d");

        assertEquals(quadruple.hashCode(), other.hashCode());
    }

    @Test
    public void testShiftLeftReturnsNew() {
        Quadruple<String, String, String, String> quad =
                new Quadruple<>("hello", ",", "world", "!");
        Quadruple<String, String, String, String> other = quad.shiftLeft();

        assertNotEquals(quad, other);
    }

    @Test
    public void testShiftLeft() {
        Quadruple<String, String, String, String> quad =
                new Quadruple<>("1", "2", "3", "4");
        quad = quad.shiftLeft();
        Quadruple<String, String, String, String> expected =
                new Quadruple<>("2", "3", "4", "1");

        assertEquals(quad, expected);
    }

    @Test
    public void testShiftRightReturnsNew() {
        Quadruple<String, String, String, String> quad =
                new Quadruple<>("hello", ",", "world", "!");
        Quadruple<String, String, String, String> other = quad.shiftRight();

        assertNotEquals(quad, other);
    }

    @Test
    public void testShiftRight() {
        Quadruple<String, String, String, String> quad =
                new Quadruple<>("1", "2", "3", "4");
        quad = quad.shiftRight();
        Quadruple<String, String, String, String> expected =
                new Quadruple<>("4", "1", "2", "3");

        assertEquals(quad, expected);
    }
}
