package edu.grinnell.csc207.nguyenti.utils;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testEva10() {
	assertEquals(BigInteger.valueOf(0), Calculator.eval0("0"));
	assertEquals(BigInteger.valueOf(2), Calculator.eval0("1 + 1"));
	assertEquals(BigInteger.valueOf(4), Calculator.eval0("1 + 2 + 1"));
	assertEquals(BigInteger.valueOf(9), Calculator.eval0("1 + 2 * 3"));
    }

}
