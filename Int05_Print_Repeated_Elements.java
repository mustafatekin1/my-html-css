package interviewquestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Int05_Print_Repeated_Elements {

	public static void main(String[] args) {
		// Print repeated characters in a given String

		
		printRepeated("Karagumruk");
		System.out.println("=====");
		printRepeated("aaabbbbccccd");
		
		System.out.println("=====");
		printRepeatedByMap("aaabbbbccccd");
		
		System.out.println("------");
		printRepeatedByMap1("aaabbbbccccd");
		
	}
	
	//1st way
	public static void printRepeated(String str) {
		int c = 0;
		str = str.toUpperCase();
		String strNew = "";
		for (int i = 0; i<str.length(); i++) {
			
			String s1 = str.substring(i, i+1);
			
			if (str.indexOf(s1) != str.lastIndexOf(s1)) {
				if(!strNew.contains(s1)) {
					strNew = strNew + s1; 
				}

			}
	
		}
	System.out.println(strNew);
	
	}
		
//2nd way
	
	public static void printRepeatedByMap1(String str) {
		
		String arr [] = str.split("");
		
		HashMap <String, Integer> map = new HashMap<>();
		
		
		for (String w:arr) {
			
			if (!map.containsKey(w)) {
				
				map.put(w, 1);
				
			} else {
				map.put(w, map.get(w)+1);
			}
			
			
		}
		// now to get the repeated ones we use entrySet method:
		
		for (Entry<String, Integer> w:map.entrySet()) {
			if (w.getValue()>1) {
				System.out.print(w + " ");
			}
			
		}
		System.out.println();
		// or just to print the characters (in this case keys) we use getKey method
		System.out.println("==--==--==-----====");
		for (Entry<String, Integer> w:map.entrySet()) {
			if (w.getValue()>1) {
				System.out.print(w.getKey() + " ");
			}
			
		}
		
		
		
		
	}
	
	
	
	// 2nd way. Benim denedigim... olmadi!
	public static void printRepeatedByMap(String str) {
		
		String arr[] = str.split("");	
		
		HashMap <String, Integer> map = new HashMap <>();
		
		
		
		Arrays.stream(arr).distinct().forEach(System.out::print);
	
	}
	

	
	
	
	

}


