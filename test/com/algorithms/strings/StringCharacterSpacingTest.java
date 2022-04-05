package com.algorithms.strings;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCharacterSpacingTest {

	StringCharacterSpacing stringSpacing;
	
	@BeforeEach
	public void setUp() {
		stringSpacing = new StringCharacterSpacing();
	}
	
	
	@Test
	public void testString() {
		assertTrue("Difference in expected value",stringSpacing.removeSpacing("g e e k s f o r g e e k s").equals("geeksforgeeks"));
		assertTrue("Difference in expected value",stringSpacing.moveSpacesFront("geeks for geeks").equals("  geeksforgeeks"));
		assertTrue("Difference in expected value",stringSpacing.putSpaceStartingCapitalWord("BruceWayneIsBatman").equals(" bruce wayne is batman"));
		assertTrue("Difference in expected value",stringSpacing.urlifyString("Mr John Smith ").equals("Mr%20John%20Smith"));
	}
}
