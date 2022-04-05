package com.algorithms.strings;

public class StringAnagram {

	/**
	 * Write a function to check whether two given strings are anagram of each other or not. 
	 * An anagram of a string is another string that contains the same characters,
	 *  only the order of characters can be different. For example, “abcd” and “dabc” are an anagram of each other.
	 * @param str1
	 * @param str2
	 * @return
	 */
	public boolean checkAnagrams(String str1,String str2) {
		int c1[] = new int[256];
		int c2[] = new int[256];
		for(int i=0;i<str1.length();i++) {
			c1[str1.charAt(i)]++;
		}
		for(int i=0;i<str2.length();i++) {
			c2[str2.charAt(i)]++;
		}
		for(int i=0;i<c1.length;i++) {
			if(c1[i]!=c2[i]) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Given two strings of lowercase alphabets and a value k, the task is to find if two strings are K-
	 * anagrams of each other or not.Two strings are called k-anagrams if following two conditions are true. 
	 * Both have same number of characters.Two strings can become anagram by changing at most k characters in a string.
	* * @param str1
	 * @param str2
	 * @param k
	 * @return
	 */
	public boolean checkStringsAreKAnagrams(String str1,String str2, int k) {
		int c1[] = new int[256];
		int c2[] = new int[256];
		for(int i=0;i<str1.length();i++) {
			c1[str1.charAt(i)]++;
		}
		for(int i=0;i<str2.length();i++) {
			c2[str2.charAt(i)]++;
		}
		int count = 0;
		for(int i=0;i<c1.length;i++) {
			if(c1[i]>c2[i]) {
				count=  count + Math.abs(c1[i] - c2[i]);
			}
		}
		if(count!=k) {
			return false;
		}
		return true;
	}	

}