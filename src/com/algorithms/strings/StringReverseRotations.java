package com.algorithms.strings;

public class StringReverseRotations {

	/**
	 * Program to reverse a string iterative
	 * @param str
	 * @return
	 */
	public String reverseIterative(String str) {
		int len = str.length();
		char arr[] = str.toCharArray();
		int half = len/2;
		for(int i=0;i<half;i++) {
			char temp  = arr[i];
			arr[i] = arr[len-i-1];
			arr[len-i-1] = temp;
		}
		return new String(arr);
	}
	
	/**
	 * Program to reverse a string recursive
	 * @param arr
	 * @param t
	 * @return
	 */
	public String reverseRecursive(char arr[],int t) {
		int n = arr.length;
		if(t==arr.length/2) {
			return new String(arr);
		}
		char temp = arr[t];
		arr[t] = arr[n-t-1];
		arr[n-t-1] = temp;
		return reverseRecursive(arr,t+1);
	}
	
	/**
	 * Given a string, that contains a special character 
	 * together with alphabets (‘a’ to ‘z’ and ‘A’ to ‘Z’), 
	 * reverse the string in a way that special characters are not affected.
	 * @param str
	 * @return
	 */
	public String reverseWithoutAffectingSpecialCharacters(String str) {
		char arr[] = str.toCharArray();
		int low = 0;
		int high = arr.length-1;
		while(low<high) {
			if(!isAlphabetic(arr[low])){
				low++;
			}else if(!isAlphabetic(arr[high])) {
				high--;
			}else {
				char c = arr[low];
				arr[low] = arr[high];
				arr[high] = c;
				low++;
				high--;
			}
		}
		return new String(arr);
	}
	

	/**
	 * Given a string s, print reverse of string and remove the 
	 * characters from the reversed string where there are vowels in the original string. 
	 * @param str
	 * @return
	 */
	public String reverseAfterRemovingVowels(String str) {
		String reversedString = reverseIterative(str);
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<reversedString.length();i++) {
			if(!isVowel(str.charAt(i))) {
				builder.append(reversedString.charAt(i));
			}
		}
		return builder.toString();
	}
	
	/**
	 * Given a string, your task is to reverse only the vowels of string.
	 * @param str
	 * @return
	 */
	
	public String reverseVowels(String str) {
		char arr[] = str.toCharArray();
		int low = 0;
		int high = str.length()-1;
		while(low<high) {
			if(!isVowel(arr[low])) {
				low++;
			}else if(!isVowel(arr[high])) {
				high--;
			}else {
				char c = arr[low];
				arr[low] = arr[high];
				arr[high] = c;
				low++;
				high--;
			}
		}
		return new String(arr);
	}

	/**
	 * Given a string str, we need to print reverse of individual words.
	 * @param str
	 * @return
	 */
	public String reverseWords(String str) {
		String arr[] = str.split(" ");
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<arr.length;i++) {
			builder.append(reverseIterative(arr[i])+" ");
		}
		return builder.toString().trim();
	}
	
	/**
	 * You are given a string ‘str’, 
	 * the task is to check that reverses of all possible substrings of ‘str’ are present in ‘str’ or not. 
	 * @param str
	 * @return
	 */
	public boolean isPerfectlyReversible(String str) {
		return reverseIterative(str).equals(str);
	}
	
	
	public void generateRotations(String str) {
		//TODO
	}
	
	public String reverseEquation(String str) {
		//TODO
		return null;
	}
	
	/**
	 * Let the input string be “i like this program very much”. 
	 * The function should change the string to “much very program this like i”
	 * @param str
	 * @return
	 */
	public String reverseWordsInAString(String str) {
		StringBuilder builder = new StringBuilder();
		StringBuilder tempBuilder = new StringBuilder();
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c==' ') {
				builder.append(reverseIterative(tempBuilder.toString()));
				builder.append(c);
				tempBuilder = new StringBuilder();
			}else {
				tempBuilder.append(c);
			}
		}
		builder.append(reverseIterative(tempBuilder.toString()));
		return reverseIterative(builder.toString());
	}
	
	/**
	 * Given a large positive number as string, count all rotations of the given number which are divisible by 4. 
	 * @param str
	 * @return
	 */
	public int countRotationsDivisibleBy4(String str) {
		int len = str.length();
		int count = 0;
		String temp = "";
		for(int i=0;i<len-1;i=i+1) {
			temp = temp + str.charAt(i) + str.charAt(i+1);
			if((Integer.parseInt(temp)%4)==0) {
				count++;
			}
			temp = "";
		}
		temp = ""  + str.charAt(str.length()-1) + str.charAt(0);
		if((Integer.parseInt(temp)%4)==0){
			count++;
		}
		return count;
	}
	
	/**
	 * Given two strings s1 and s2, check whether s2 is a rotation of s1. 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public boolean checkIfStringsAreRotationsOfEachOther(String str1,String str2) {
		String temp = str1 + str1;
		return temp.contains(str2);
	}
	
	
	private boolean isVowel(char c) {
		return c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
	}
	
	private boolean isAlphabetic(char c) {
		return (c>='a'&&c<='z') || (c>='A' && c<='Z');
	}
}
