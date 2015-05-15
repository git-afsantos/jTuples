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
package org.jtuples.operations;

import org.jtuples.Pair;
import org.jtuples.Quadruple;
import org.jtuples.Triple;
import org.jtuples.Tuple;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Benjamim Sonntag
 */
public class IntoPairTest {
    private IntoPair<String, String> extender;
    private Tuple expected;
    private Tuple result;
    
    @Before
    public void setup() {
        extender = IntoPair.into(new Pair<>("a", "b"));
    }
    
    @Test
    public void testPutValue() {
        expected = new Triple<>("a", "b", "c");
        
        result = extender.put("c");
        
        assertEquals(expected, result);
    }

    @Test
    public void testAppendPair() {
        expected = new Quadruple<>("a", "b", "c", "d");
        
        result = extender.append(new Pair<>("c", "d"));
        
        assertEquals(expected, result);
    }

    @Test
    public void testAppendTriple() {
        // TODO
    }

    @Test
    public void testAppendQuadruple() {
        // TODO
    }
    
}
