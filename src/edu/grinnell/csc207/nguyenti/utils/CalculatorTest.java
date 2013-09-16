package edu.grinnell.csc207.nguyenti.utils;

import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigInteger;

public class CalculatorTest {

    @Test
    public void testEva10() {
	assertEquals("0", BigInteger.valueOf(0), Calculator.eval0("0"));
	assertEquals("1 value", BigInteger.valueOf(3), Calculator.eval0("3"));
	assertEquals("addition", BigInteger.valueOf(2), Calculator.eval0("1 + 1"));
	assertEquals("exponentation", BigInteger.valueOf(16), Calculator.eval0("4 ^ 2"));
	assertEquals("division", BigInteger.valueOf(2), Calculator.eval0("6 / 3"));
	assertEquals("subtraction", BigInteger.valueOf(2), Calculator.eval0("4 - 2"));
	assertEquals("multiplication", BigInteger.valueOf(18), Calculator.eval0("6 * 3"));
	assertEquals("more than 2 values addition", BigInteger.valueOf(4), Calculator.eval0("1 + 2 + 1"));
	assertEquals("multiple operations", BigInteger.valueOf(9), Calculator.eval0("1 + 2 * 3"));
	assertEquals("other multiple operations", BigInteger.valueOf(-1), Calculator.eval0("2 - 4 / 2"));
    }

    @Test
    public void testEval0() {
	int[] arrayOne = {3, 0, 1, 0};
	int[] arrayTwo = {1, 1, 1, 1};
	int[] arrayThree = {1, 0, 0, 0};
	int[] arrayFour = {0, 0, 0, 0};
	int[] arrayFive = {0, 2, 0, 0};
	int[] arraySix = {1, 1, 1, 0};
	int[] arraySeven = {0, 4, 0, 0};
	
	assertArrayEquals("two denominations", arrayOne, Calculator.fewestCoins(17));
	assertArrayEquals("one of each", arrayTwo, Calculator.fewestCoins(74));
	assertArrayEquals("one denomination", arrayThree, Calculator.fewestCoins(2));
	assertArrayEquals("0", arrayFour, Calculator.fewestCoins(0));
	assertArrayEquals("two of a denomination", arrayFive, Calculator.fewestCoins(14));
	assertArrayEquals("0", arraySix, Calculator.fewestCoins(20));
	assertArrayEquals("two of a denomination", arraySeven, Calculator.fewestCoins(28));
    }

}
