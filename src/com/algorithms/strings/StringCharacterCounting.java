package com.algorithms.strings;

public class StringCharacterCounting {
	
	/**
	 * Find and print the common characters of the two given strings in sorted order. 
	 * @param str1
	 * @param str2
	 */
	public void commonCharacters(String str1,String str2) {
		boolean barr[] = new boolean[26];
		for(int i=0;i<str1.length();i++) {
			barr[str1.charAt(i)-'a']=true;
		}
		for(int i=0;i<str2.length();i++) {
			int t = str2.charAt(i)-'a';
			if(barr[t]) {
				System.out.print(str2.charAt(i)+" ");
			}
		}
		System.out.println();
	}

	/**
	 * Find and print the uncommon characters of the two given strings in sorted order. 
	 * @param str1
	 * @param str2
	 */
	public void uncommonCharacters(String str1,String str2) {
		boolean barr1[] = new boolean[26];
		boolean barr2[] = new boolean[26];
		for(int i=0;i<str1.length();i++) {
			barr1[str1.charAt(i)-'a']=true;
		}
		for(int i=0;i<str2.length();i++) {
			barr2[str2.charAt(i)-'a']=true;
		}
		for(int i=0;i<str2.length();i++) {
			int t = str2.charAt(i)-'a';
			if(!barr1[t]) {
				System.out.print(str2.charAt(i)+" ");
			}
		}
		for(int i=0;i<str1.length();i++) {
			int t = str1.charAt(i)-'a';
			if(!barr2[t]) {
				System.out.print(str1.charAt(i)+" ");
			}
		}	
		System.out.println();
	}
	
	/**
	 * 
	 * @param str
	 */
	public void kthCharacterString(String str,int k) {
		//TODO
//		String str1 = "",str2 = "", str3 = "";
//		//ab4c12ed3
//		for(int i=0;i<str.length();i++) {
//			char c = str.charAt(i);
//			if(Character.isDigit(c)) {
//				str1 = str1+c;
//			}else if((c>='a' && c<='z') || (c>='A' && c<='Z')) {
//				str2 = str2+c;
//			}
//			if(str1.length()>0 && str2.length()>0) {
//				int temp = Integer.parseInt(str1);
//				for(int j=0;j<temp;j++) {
//					str3 = str3 + str2;
//				}
//				str1 = "";
//				str2 = "";
//			}
//		}
//		System.out.println(str3.charAt(k));
	}
	
	
	/**
	 * Given a string of lower and uppercase characters, 
	 * the task is to find that how many characters are at same position as in English alphabet.
	 * @param str
	 */
	public void countCharactersAtSameAsEnglish(String str) {
		int count = 0;
		for(int i=0;i<str.length();i++) {
			if((str.charAt(i)-'a')==(i) || (str.charAt(i)-'A')==(i)) {
				count++;
			}
		}
		System.out.println(count);
	}

	/**
	 * Given a string, count number of words in it. 
	 * The words are separated by following characters: space (‘ ‘) or new line (‘\n’) or tab (‘\t’) or a combination of these.
	 * @param str
	 */
	public int countWords(String str) {
		int OUT = 0;
		int IN = 1;
		int count = 0;
		int i=0;
		int state = OUT;
		while(i<str.length()) {
			if(str.charAt(i) == ' ' || str.charAt(i) == '\n' || str.charAt(i) == '\t') {
				state = OUT;
			}else if(state==OUT) {
				state = IN;
				++count;
			}
			++i;
		} 
		return count;
	}
	
	
	/**
	 * Given two strings, print all the common characters in lexicographical order. 
	 * If there are no common letters, print -1. All letters are lower case. 
	 * @param str1
	 * @param str2
	 */
	public void commonCharactersInAlphabeticalOrder(String str1,String str2) {
		int carr1[] = new int[26];
		int carr2[] = new int[26];
		for(int i=0;i<str1.length();i++) {
			carr1[str1.charAt(i)-'a']++;
		}
		for(int i=0;i<str2.length();i++) {
			carr2[str2.charAt(i)-'a']++;
		}
		for(int i=0;i<carr1.length;i++) {
			if(carr1[i] == carr2[i]) {
				for(int j=0;j<carr1[i];j++) {
					System.out.print((char)(i+'a'));
				}
			}
		}System.out.println();
	}
	
	
	public void commonCharactersInNStrings(String ...strings) {
		//TODO
	}
	
	
	/**
	 * Given a string, remove the vowels from the string and print the string without vowels. 
	 * @param str
	 */
	public String removeVowels(String str) {
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<str.length();i++) {
			if(!isVowel(str.charAt(i))) {
				builder.append(str.charAt(i));
			}
		}
		return builder.toString();
	}
	
	
	/**
	 * Given a string s of lowercase letters, we need to remove consecutive vowels from the string
	 * @param str
	 * @return String
	 */
	public String removeConsecutiveVowels(String str) {
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<str.length()-1;i++) {
			if(!isVowel(str.charAt(i)) || !isVowel(str.charAt(i+1))){
				builder.append(str.charAt(i));
			}
		}
		return builder.toString();
	}
	
	/**
	 * Program to count vowels in a string 
	 * @param str
	 * @return
	 */
	public int countVowels(String str) {
		int count = 0;
		for(int i=0;i<str.length();i++) {
			if(isVowel(str.charAt(i)))
				count++;
		}
		return count;
	}

	/**
	 * Count consonants in a string
	 * @param str
	 * @param i
	 * @param count
	 * @return
	 */
	public int countConsonents(String str,int i,int count) {
		if(i==str.length()) {
			return count;
		}
		if(!isVowel(str.charAt(i)) && !Character.isWhitespace(str.charAt(i))) {
			count++;
		}
		return countConsonents(str, i+1, count);
	}
	
	/**
	 * Given a string of lowercase characters only, the task is to check if it is possible to split a string 
	 * from the middle which will give two halves having the same characters and same frequency of each character.
	 * @param str
	 * @return
	 */
	public boolean checkIfHalvesAreEqual(String str) {
		int len = str.length();
		int half = len/2;
		int carr[] = new int[26];
		for(int i=0;i<half;i++) {
			carr[str.charAt(i)-'a']++;
		}
		for(int i=half;i<len;i++) {
			carr[str.charAt(i)-'a']--;
		}
		for(int i=0;i<carr.length;i++) {
			if(carr[i]!=0) {
				return false;
			}
		}
		return true;
	}

	
	/**
	 * Write an efficient function that 
	 * takes two strings as arguments and removes the characters from the 
	 * first string which are present in the second string (mask string). 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public String removeFromFirstStringPresentinSecondString(String str1,String str2) {
		int carr[] = new int[26];
		for(int i=0;i<str2.length();i++) {
			carr[str2.charAt(i)-'a']++;
		}
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<str1.length();i++) {
			char c = str1.charAt(i);
			int temp = c-'a';
			if(carr[temp]==0) {
				builder.append(c);
			}
		}
		return builder.toString();
	}
	
	/**
	 * Given a string, find the all distinct (or non-repeating characters) in it.
	 * @param str
	 * @return
	 */
	public String allDistinctCharactersInStringInorder(String str) {
		int carr[] = new int[256];
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			carr[c]++;
			
		}
		for(int i=0;i<carr.length;i++) {
			if(carr[i]==1) {
				builder.append((char)(i));
			}
		}
		return builder.toString();
	}
	
	
	
	
	
	
	
	private boolean isVowel(char c) {
		return c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
	}
}
