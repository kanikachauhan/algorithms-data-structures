package com.algorithms.stk;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTest {

	ArrayStack<Integer> stack;
	
	@BeforeEach
	public void setUp() {
		stack = new ArrayStack<Integer>();
	}
	
	@Test
	public void testPushPopPeekArray() {
		stack.push(1); stack.push(2); stack.push(3); stack.push(4); stack.push(5);
		assertTrue("Difference in expected value", stack.pop()==5);
		assertTrue("Difference in expected value", stack.pop()==4);
		assertTrue("Difference in expected value", stack.pop()==3);
		assertTrue("Difference in expected value", stack.peek()==2);
	}
	
	@Test
	public void testConversions() {
		String resultOne = StackOperationOne.convertPrefixToInfix("*-A/BC-/AKL");
		assertTrue("Difference in expected value", resultOne.equals("((A-(B/C))*((A/K)-L))"));
		String resultTwo = StackOperationOne.convertPostfixToPrefix("ABC/-AK/L-*");
		assertTrue("Difference in expected value", resultTwo.equals("*-A/BC-/AKL"));
		String resultThree = StackOperationOne.convertPrefixToPostfix("*+AB-CD");
		assertTrue("Difference in expected value", resultThree.equals("AB+CD-*"));
		int resultFour = StackOperationOne.evaluatePostfix("231*+9-");
		assertTrue("Difference in expected value", resultFour==-4);
		assertTrue("Difference in expected value", StackOperationOne.isBalancedParanthesis("[()]{}{[()()]()}"));
		assertFalse("Difference in expected value", StackOperationOne.isBalancedParanthesis("[(])"));
	}
	
}
