package stringManipulationAlgorithms;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class stringManipulationAlgorithms {
	
	public static int countVowels(String string) {
		/*
		 * Time complexity: O(n)
		 * Space complexity: O(1)
		 * */
		if(string==null) return 0;
		int num = 0;
		string = string.toLowerCase();
		for(int i=0;i!=string.length();i++) {
			if(isVowel(string.charAt(i))) {
				num+=1;
			}
		}
		return num;
	}
	
	public static String reverseString1(String string) {
		/*
		 * Time complexity: O(n)
		 * Space complexity: O(n)
		 * */
		
		if(string==null) throw new IllegalArgumentException("Please enter a valid string.");
		String finalString = "";
		Stack<Character> invertedString = new Stack<Character>();
		
		for(char c: string.toCharArray()) {
			invertedString.push(c);
		}
		
		while(!invertedString.isEmpty()) {
			finalString+=Character.toString(invertedString.pop());
		}
		
		return finalString;
	}
	
	public static String reverseString2(String string) {
		/*
		 * Time complexity: O(n^2)
		 * Space complexity: O(1)
		 * */
		 
		if(string==null) throw new IllegalArgumentException("Please enter a valid string.");
		String finalString = "";
		for(int i=string.length()-1;i>=0;i--) {
			finalString+=string.charAt(i);
		}
		return finalString;
	}
	
	public static String reverseString3(String string) {
		/*
		 * Time complexity: O(n)
		 * Space complexity: O(1)
		 * */
		 
		if(string==null) throw new IllegalArgumentException("Please enter a valid string.");
		StringBuilder finalString = new StringBuilder();
		for(int i=string.length()-1;i>=0;i--) {
			finalString.append(string.charAt(i));
		}
		return finalString.toString();
	}
	
	public static String reverseWordOrder(String string) {
		if(string==null) throw new IllegalArgumentException("Please enter a valid string.");
		String[] splitString = string.split(" ");
		StringBuilder reversedString = new StringBuilder();
		for(int i=splitString.length-1;i>=0;i--) reversedString.append(splitString[i]+" ");
		return reversedString.toString().trim();
	}
	
	private static boolean isVowel(char character) {
		return character=='a' || character=='e' || character=='i' || character=='o' || character=='u';
	}
	
	public static void main(String[] args) {
		//testing countVowels
//		System.out.println(stringManipulationAlgorithms.countVowels("HEllo"));
//		System.out.println(stringManipulationAlgorithms.countVowels("jqty"));
//		System.out.println(stringManipulationAlgorithms.countVowels("Aeiou"));
		
		//testing reverseString
//		System.out.println(stringManipulationAlgorithms.reverseString1("Hello"));
//		System.out.println(stringManipulationAlgorithms.reverseString2("Hello"));
//		System.out.println(stringManipulationAlgorithms.reverseString3("Hello"));
		
		//testing reverseWordOrder
		System.out.println(stringManipulationAlgorithms.reverseWordOrder("Hello"));
		System.out.println(stringManipulationAlgorithms.reverseWordOrder("Trees are beautiful"));
		System.out.println(stringManipulationAlgorithms.reverseWordOrder("It's snow outisde in our yard"));
	}

}
