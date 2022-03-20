package com.algorithms.strings;

public class StringCharacterCountingTest {

	public static void main(String[] args) {
		StringCharacterCounting stringCharacterCounting = new StringCharacterCounting();
		stringCharacterCounting.commonCharacters("characters", "alphabets");
		stringCharacterCounting.uncommonCharacters("characters", "alphabets");
//		stringCharacterCounting.kthCharacterString("ab4c12ed3", 21);
		stringCharacterCounting.countCharactersAtSameAsEnglish("ABcED");
		stringCharacterCounting.countWords("One two       three\n four\tfive ");
	}
}
