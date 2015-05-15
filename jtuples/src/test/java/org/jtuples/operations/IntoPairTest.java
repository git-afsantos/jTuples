/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
