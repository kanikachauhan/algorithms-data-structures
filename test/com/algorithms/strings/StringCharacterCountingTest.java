package com.algorithms.strings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class StringCharacterCountingTest {
	
	StringCharacterCounting stringCharacterCounting = new StringCharacterCounting();
	

	public static void main(String[] args) {
		StringCharacterCounting stringCharacterCounting = new StringCharacterCounting();
		stringCharacterCounting.commonCharacters("characters", "alphabets");
		stringCharacterCounting.uncommonCharacters("characters", "alphabets");
//		stringCharacterCounting.kthCharacterString("ab4c12ed3", 21);
		stringCharacterCounting.countCharactersAtSameAsEnglish("ABcED");
		stringCharacterCounting.commonCharactersInAlphabeticalOrder("geeks", "forgeeks");
	}
	
	@Test
	public void testRemovals() {
		assertTrue("Difference in expected value",stringCharacterCounting.removeVowels("welcome to geeksforgeeks").equals("wlcm t gksfrgks"));
		assertTrue("Difference in expected value",stringCharacterCounting.removeConsecutiveVowels("your article is in queue").equals("yur article is in q"));
		assertTrue("Difference in expected value",stringCharacterCounting.removeFromFirstStringPresentinSecondString("geeksforgeeks","mask").equals("geeforgee"));
	}
	
	@Test
	public void testCounts() {
		assertEquals("Difference in expected value",7,stringCharacterCounting.countVowels("geeksforgeeks portal"));
		assertEquals("Difference in expected value",12,stringCharacterCounting.countConsonents("geeksforgeeks portal", 0, 0) );
		assertEquals("Difference in expected value",5, stringCharacterCounting.countWords("One two       three\n four\tfive "));
	}
	
	@Test
	public void testcheckIfHalvesAreEqual() {
		assertTrue("Difference in expected value", stringCharacterCounting.checkIfHalvesAreEqual("abccab"));
	}
	
	@Test
	public void testallDistinctCharactersInStringInorder() {
		assertTrue("Difference in expected value", stringCharacterCounting.allDistinctCharactersInStringInorder("GeeksforGeeks").equals("for"));
	}
}
