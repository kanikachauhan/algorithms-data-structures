package com.algorithms.strings;

public class StringCharacterSpacing {

	/**
	 * Given a string, remove all spaces from the string and return it. 
	 * @param str
	 * @return
	 */
	public String removeSpacing(String str) {
		char carr[] = str.toCharArray();
		int count = 0;
		for(int i=0;i<carr.length;i++) {
			if(carr[i]!=' ') {
				carr[count] = carr[i];
				count++;
			}
		}
		return new String(carr).substring(0,count);
	}
	
	/**
	 * Given a string that has set of words and spaces, 
	 * write a program to move all spaces to front of string, by traversing the string only once.
	 * @param str
	 * @return
	 */
	public String moveSpacesFront(String str) {
		char arr[] = str.toCharArray();
		int i=0,j = str.length()-1;
		for(i=j;i>=0;i--) {
			if(arr[i]!=' ') {
				char c = arr[j];
				arr[j] = arr[i];
				arr[i] = c;
				j--;
			}
		}
		return new String(arr);
	}
	
	/**
	 * You are given an array of characters which is basically a sentence. 
	 * However, there is no space between different words and the first letter of every word is in uppercase. 
	 * You need to print this sentence after following amendments: 
		(i) Put a single space between these words. 
		(ii) Convert the uppercase letters to lowercase.
	 * @param str
	 * @return
	 */
	public String putSpaceStartingCapitalWord(String str) {
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c>='A' && c<='Z') {
				builder.append(" ");
				builder.append((char)(c+32));
			}else {
				builder.append(c);
			}
		}
		return builder.toString();
	}
	
	/**
	 * Write a method to replace all the spaces in a string with ‘%20’.
	 * @param str
	 * @return
	 */
	public String urlifyString(String str) {
		StringBuilder builder = new StringBuilder();
		str = str.trim();
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c==' ') {
				builder.append("%20");
			}else {
				builder.append(c);
			}
		}
		return builder.toString();
	}
}
