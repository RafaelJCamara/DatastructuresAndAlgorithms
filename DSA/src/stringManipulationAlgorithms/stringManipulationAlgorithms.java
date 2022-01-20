package stringManipulationAlgorithms;

import java.util.HashSet;
import java.util.Set;

public class stringManipulationAlgorithms {
	
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
	
	private static boolean isVowel(char character) {
		return character=='a' || character=='e' || character=='i' || character=='o' || character=='u';
	}
	
	public static void main(String[] args) {
		//testing countVowels
		System.out.println(stringManipulationAlgorithms.countVowels("HEllo"));
		System.out.println(stringManipulationAlgorithms.countVowels("jqty"));
		System.out.println(stringManipulationAlgorithms.countVowels("Aeiou"));
	}

}
