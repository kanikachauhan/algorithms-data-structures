package com.algorithms.strings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class StringReverseRotationsTest {

	StringReverseRotations stringReverseRotations;
	
	@BeforeEach
	public void setUp() {
		stringReverseRotations = new StringReverseRotations();
	}
	
	@Test
	public void testReverse() {
		assertTrue("Difference in expected value",stringReverseRotations.reverseIterative("abcdef").equals("fedcba"));
		assertTrue("Difference in expected value",stringReverseRotations.reverseRecursive("abcdef".toCharArray(),0).equals("fedcba"));
		assertTrue("Difference in expected value",stringReverseRotations.reverseWithoutAffectingSpecialCharacters("Ab,c,de!$").equals("ed,c,bA!$"));
		assertTrue("Difference in expected value",stringReverseRotations.reverseAfterRemovingVowels("geeksforgeeks").equals("segrfseg"));
		assertTrue("Difference in expected value",stringReverseRotations.reverseVowels("hello").equals("holle"));
		assertTrue("Difference in expected value",stringReverseRotations.reverseWords("Hello World").equals("olleH dlroW"));
		assertTrue("Difference in expected value",stringReverseRotations.isPerfectlyReversible("aba"));
		assertTrue("Difference in expected value",!stringReverseRotations.isPerfectlyReversible("abab"));
		assertTrue("Difference in expected value",stringReverseRotations.reverseWordsInAString("getting good at coding needs a lot of practice ").equals(" practice of lot a needs coding at good getting"));
	}
	
	@Test
	public void testRotations() {
		stringReverseRotations.generateRotations("geeks");
		assertEquals("Difference in expected value",5,stringReverseRotations.countRotationsDivisibleBy4("43292816"));
		assertTrue("Difference in expected value",stringReverseRotations.checkIfStringsAreRotationsOfEachOther("ABACD", "CDABA"));
		assertTrue("Difference in expected value",stringReverseRotations.checkIfStringsAreRotationsOfEachOther("GEEKS", "EKSGE"));
	}
}
