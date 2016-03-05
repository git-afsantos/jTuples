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

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andre Santos <contact.andre.santos@gmail.com>
 * @author Benjamim Sonntag <benjamimsonntag@gmail.com>
 */
public class TuplesTest {

    @Test
    public void testPairWith() {
        Tuple expected = new Pair<>("1", "2");
        assertEquals(expected, Tuples.with("1", "2"));
    }

    @Test
    public void testTripleWith() {
        Tuple expected = new Triple<>("1", "2", "3");
        assertEquals(expected, Tuples.with("1", "2", "3"));
    }

    @Test
    public void testFourthWith() {
        Tuple expected = new Quadruple<>("1", "2", "3", "4");
        assertEquals(expected, Tuples.with("1", "2", "3", "4"));
    }

    @Test
    public void testQuintupleWith() {
        Tuple expected = new Quintuple<>("1", "2", "3", "4", "5");
        assertEquals(expected, Tuples.with("1", "2", "3", "4", "5"));
    }

    @Test
    public void testSextupleWith() {
        Tuple expected = new Sextuple<>("1", "2", "3", "4", "5", "6");
        assertEquals(expected, Tuples.with("1", "2", "3", "4", "5", "6"));
    }

    @Test
    public void testSeptupleWith() {
        Tuple expected = new Septuple<>("1", "2", "3", "4", "5", "6", "7");
        assertEquals(expected, Tuples.with("1", "2", "3", "4", "5", "6", "7"));
    }

    @Test
    public void testOctupleWith() {
        Tuple expected = new Octuple<>("1", "2", "3", "4", "5", "6", "7", "8");
        assertEquals(expected, Tuples.with("1", "2", "3", "4", "5", "6", "7", "8"));
    }

    @Test
    public void testFlatFirst() {
        Pair<Pair<String, String>, String> pair = new Pair<>(
                new Pair<>("1", "2"),
                "3"
        );
        Tuple expected = new Triple<>("1", "2", "3");
        assertEquals(expected, Tuples.flatFirst(pair));
    }

    @Test
    public void testFlatSecond() {
        Pair<String, Pair<String, String>> pair = new Pair<>(
                "1",
                new Pair<>("2", "3")
        );
        Tuple expected = new Triple<>("1", "2", "3");
        assertEquals(expected, Tuples.flatSecond(pair));
    }

    @Test
    public void testAssociateFirst() {
        Pair<String, Pair<String, String>> pair = new Pair<>(
                "1",
                new Pair<>("2", "3")
        );
        Tuple expected = new Pair<>(
                new Pair<>("1", "2"),
                "3"
        );
        assertEquals(expected, Tuples.associateFirst(pair));
    }

    @Test
    public void testAssociateSecond() {
        Pair<Pair<String, String>, String> pair = new Pair<>(
                new Pair<>("1", "2"),
                "3"
        );
        Tuple expected = new Pair<>(
                "1",
                new Pair<>("2", "3")
        );
        assertEquals(expected, Tuples.associateSecond(pair));
    }

    @Test
    public void testMap_Pair() {
        Pair<String, String> pair = new Pair<>("1", "2");
        Tuple expected = new Pair<>("11", "22");
        assertEquals(expected, Tuples.map(pair, s -> s + s));
    }

    @Test
    public void testMap_Triple() {
        Triple<String, String, String> triple = new Triple<>("1", "2", "3");
        Tuple expected = new Triple<>("11", "22", "33");
        assertEquals(expected, Tuples.map(triple, s -> s + s));
    }

    @Test
    public void testMap_Quadruple() {
        Quadruple<String, String, String, String> quadruple =
                new Quadruple<>("1", "2", "3", "4");
        Tuple expected = new Quadruple<>("11", "22", "33", "44");
        assertEquals(expected, Tuples.map(quadruple, s -> s + s));
    }

    @Test
    public void testMap_Quintuple() {
        Quintuple<String, String, String, String, String> quintuple =
                new Quintuple<>("1", "2", "3", "4", "5");
        Tuple expected = new Quintuple<>("11", "22", "33", "44", "55");
        assertEquals(expected, Tuples.map(quintuple, s -> s + s));
    }

    @Test
    public void testMap_Sextuple() {
        Sextuple<String, String, String, String, String, String> sextuple =
                new Sextuple<>("1", "2", "3", "4", "5", "6");
        Tuple expected = new Sextuple<>("11", "22", "33", "44", "55", "66");
        assertEquals(expected, Tuples.map(sextuple, s -> s + s));
    }

    @Test
    public void testMap_Septuple() {
        Septuple<String, String, String, String, String, String, String>
                septuple = new Septuple<>("1", "2", "3", "4", "5", "6", "7");
        Tuple expected =
                new Septuple<>("11", "22", "33", "44", "55", "66", "77");
        assertEquals(expected, Tuples.map(septuple, s -> s + s));
    }

    @Test
    public void testMap_Octuple() {
        Octuple<String, String, String, String, String, String, String, String>
                octuple = new Octuple<>("1", "2", "3", "4", "5", "6", "7", "8");
        Tuple expected =
                new Octuple<>("11", "22", "33", "44", "55", "66", "77", "88");
        assertEquals(expected, Tuples.map(octuple, s -> s + s));
    }

    @Test
    public void testZip_Iterable() {
        List<String> firsts = Arrays.asList("1", "2", "3", "4");
        List<Integer> seconds = Arrays.asList(1, 2, 3, 4);
        List<Pair<String, Integer>> expected = Arrays.asList(
                new Pair<>("1", 1),
                new Pair<>("2", 2),
                new Pair<>("3", 3),
                new Pair<>("4", 4)
        );
        assertArrayEquals(expected.toArray(),
                Tuples.zip(firsts, seconds).toArray());
    }

    @Test
    public void testZip_Iterator() {
        List<String> firsts = Arrays.asList("1", "2", "3", "4");
        List<Integer> seconds = Arrays.asList(1, 2, 3, 4);
        Iterator<Pair<String, Integer>> expected = Arrays.asList(
                new Pair<>("1", 1),
                new Pair<>("2", 2),
                new Pair<>("3", 3),
                new Pair<>("4", 4)
        ).iterator();
        
        Iterator<Pair<String, Integer>> iterator =
                Tuples.zip(firsts.iterator(), seconds.iterator());
        
        while (expected.hasNext()) {
          assertEquals(expected.next(), iterator.next());
        }
        assertEquals(expected.hasNext(), iterator.hasNext());
    }
    
}
