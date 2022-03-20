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
	public void countWords(String str) {
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
	
		//One two       three\n four\tfive  
		System.out.println(count);
	}
}
