package com.algorithms.strings;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringAnagramTest {


	StringAnagram stringAnagram;
	
	@BeforeEach
	public void setUp() {
		stringAnagram = new StringAnagram();
	}
	
	@Test
	public void testAnagramProblems() {
		assertTrue("Difference in expected value", stringAnagram.checkAnagrams("listen","silent"));
		assertTrue("Difference in expected value",stringAnagram.checkStringsAreKAnagrams("anagram", "grammer", 3));
	}
	
}
