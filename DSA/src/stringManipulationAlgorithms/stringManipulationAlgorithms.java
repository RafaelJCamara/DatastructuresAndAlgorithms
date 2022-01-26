package stringManipulationAlgorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class stringManipulationAlgorithms {
	
	/*
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 * */
	public static int countVowels(String string) {
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
	
	/*
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 * */
	public static String reverseString1(String string) {
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
	
	/*
	 * Time complexity: O(n^2)
	 * Space complexity: O(1)
	 * */
	public static String reverseString2(String string) {
		 
		if(string==null) throw new IllegalArgumentException("Please enter a valid string.");
		String finalString = "";
		for(int i=string.length()-1;i>=0;i--) {
			finalString+=string.charAt(i);
		}
		return finalString;
	}
	
	/*
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 * */
	public static String reverseString3(String string) {	 
		if(string==null) throw new IllegalArgumentException("Please enter a valid string.");
		StringBuilder finalString = new StringBuilder();
		for(int i=string.length()-1;i>=0;i--) {
			finalString.append(string.charAt(i));
		}
		return finalString.toString();
	}
	
	public static String reverseWordOrder1(String string) {
		if(string==null) throw new IllegalArgumentException("Please enter a valid string.");
		String[] splitString = string.trim().split(" ");
		StringBuilder reversedString = new StringBuilder();
		for(int i=splitString.length-1;i>=0;i--) reversedString.append(splitString[i]+" ");
		return reversedString.toString().trim();
	}
	
	public static String reverseWordOrder2(String string) {
		if(string==null) throw new IllegalArgumentException("Please enter a valid string.");
		String[] splitString = string.trim().split(" ");
		//reverse splitString array (reverse in-place)
		Collections.reverse(Arrays.asList(splitString));
		return String.join(" ", splitString);
	}
	
	public static boolean isWordRotation(String s1, String s2) {
		if(s1==null||s2==null) throw new IllegalArgumentException("Please provide valid strings.");
		return (s1.length()==s2.length()) && ((s1+s1).contains(s2));
	}
	
	//this algorithm will preserve the original ordering
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	public static String removeDuplicates(String string) {
		if(string==null) throw new IllegalArgumentException("Please provide a valid string.");
		StringBuilder noDuplicateString = new StringBuilder();
		Set<Character> visitedCharacters = new HashSet<Character>();
		for(char c : string.toCharArray()) {
			if(!visitedCharacters.contains(c)) {
				visitedCharacters.add(c);
				noDuplicateString.append(c);
			}
		}
		return noDuplicateString.toString();
	}
	
	//this algorithm will not preserve the original ordering
	/*
	 * Time Complexity: O(n) [can be worse depending on the sort algorithm complexity]
	 * Space Complexity: O(1) [can be worse depending on the sort algorithm complexity]
	 */
	public static String removeDuplicates2(String string) {
		if(string==null) throw new IllegalArgumentException("Please provide a valid string.");
		StringBuilder noDuplicateString = new StringBuilder();
		char[] stringToChar = string.toCharArray();
		Arrays.sort(stringToChar);
		noDuplicateString.append(stringToChar[0]);
		for(int i=1;i!=stringToChar.length;i++) {
			if(stringToChar[i]!=stringToChar[i-1]) noDuplicateString.append(stringToChar[i]);
		}
		return noDuplicateString.toString();
	}
	
	public static char mostRepeatedCharacter(String string) {
		if(string==null) throw new IllegalArgumentException("Please provide a valid string.");
		Map<Character,Integer> characterCount = new HashMap<>();
		for(char c : string.toCharArray()) {
			characterCount.put(c, characterCount.getOrDefault(c, 0)+1);
		}
		
		int max = 0;
		char maxChar = ' ';
		
		for(Map.Entry<Character, Integer> entry: characterCount.entrySet()) {
			 if(entry.getValue()>max) {
				 maxChar=entry.getKey();
				 max = entry.getValue();
			 }
		}
		
		return maxChar;
	}
	
	public static String capitalizeFirstLetter(String string) {
		if(string==null || string.isBlank()) throw new IllegalArgumentException("Please provide a valid string.");
		StringBuilder finalString = new StringBuilder();
		String[] splitString = string.trim().split("\\s+");
		for(String s:splitString) {
			finalString.append(s.substring(0, 1).toUpperCase()+s.substring(1).toLowerCase()+" ");
		}
		return finalString.toString().trim();
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
		/*
		System.out.println(stringManipulationAlgorithms.reverseWordOrder1("Hello"));
		System.out.println(stringManipulationAlgorithms.reverseWordOrder1("Trees are beautiful"));
		System.out.println(stringManipulationAlgorithms.reverseWordOrder1("It's snow outisde in our yard"));
		System.out.println(stringManipulationAlgorithms.reverseWordOrder2("Hello"));
		System.out.println(stringManipulationAlgorithms.reverseWordOrder2("Trees are beautiful"));
		System.out.println(stringManipulationAlgorithms.reverseWordOrder2("It's snow outisde in our yard"));
		*/
		
		//testing isWordRotation
		/*
		System.out.println(stringManipulationAlgorithms.isWordRotation("Hello","R"));
		System.out.println(stringManipulationAlgorithms.isWordRotation("Abba","baAb"));
		System.out.println(stringManipulationAlgorithms.isWordRotation("Car","rCa"));
		*/
		
		//testing removeDuplicates
		/*
		System.out.println(stringManipulationAlgorithms.removeDuplicates("Helloooooooo!!!!"));
		System.out.println(stringManipulationAlgorithms.removeDuplicates("Abbaasdasds"));
		System.out.println(stringManipulationAlgorithms.removeDuplicates("Caraaaaaa"));
		System.out.println(stringManipulationAlgorithms.removeDuplicates2("Helloooooooo!!!!"));
		System.out.println(stringManipulationAlgorithms.removeDuplicates2("Abbaasdasds"));
		System.out.println(stringManipulationAlgorithms.removeDuplicates2("Caraaaaaa"));
		*/
		
		//testing mostRepeatedCharacter
		/*
		System.out.println(stringManipulationAlgorithms.mostRepeatedCharacter("Helloooooooo!!!!"));
		System.out.println(stringManipulationAlgorithms.mostRepeatedCharacter("Abbaasdasdsddddd"));
		System.out.println(stringManipulationAlgorithms.mostRepeatedCharacter("Caraaaaaa"));
		*/
		
		
		//testing mostRepeatedCharacter
		System.out.println(stringManipulationAlgorithms.capitalizeFirstLetter(" hello again"));
		System.out.println(stringManipulationAlgorithms.capitalizeFirstLetter("hello     again"));
		System.out.println(stringManipulationAlgorithms.capitalizeFirstLetter(" hello          again     a"));
		
	}

}
