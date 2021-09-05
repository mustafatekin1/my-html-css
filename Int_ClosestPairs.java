package interviewquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Int_ClosestPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// Find the closes pairs in a given array: {3,67,9,46,55,48}
		
		
		int a[] = {23,45,54,9,46,55,48,56};
		
		getClosestPairs(a);
		System.out.println("=========");
		getClosestPairs2(a);
		
	}

	public static int getClosestPairs(int a[]) {
		
		
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		int idxOfPairs = 0;
		int minDifference = Integer.MAX_VALUE;
		for (int i=0; i<a.length-1; i++) {
			if (minDifference > a[i+1]-a[i]) {
				minDifference = a[i+1]-a[i];
				idxOfPairs = i;
			}
		}
		
		System.out.println(minDifference);
		System.out.println(idxOfPairs);
		
		System.out.println("Closest pairs are " + a[idxOfPairs] + " and " + a[idxOfPairs+1]);
		return 0;
	}
	
	//2nd way
	public static int getClosestPairs2(int a[]) {
		List<Integer> differences = new ArrayList<>();
		List<String> pairs = new ArrayList<>();
		
		Arrays.sort(a);
		for (int i=0; i<a.length-1; i++) {
			differences.add(a[i+1] - a[i]); 
			pairs.add(i+"" +(i+1));
		}
		System.out.println(differences);
		System.out.println(pairs);
		
		
		int minValue = differences.stream().reduce(Integer.MAX_VALUE, Math::min);
		
		int idxOfMinValue = differences.indexOf(minValue);
		System.out.println(minValue);
		
		System.out.println("index: " + idxOfMinValue);
		
		String el = pairs.get(idxOfMinValue);
		
		int firstEl = a[Integer.valueOf(el.substring(0, 1))];
		
		int secondEl = a[Integer.valueOf(el.substring(1,2))];
		
		System.out.println("Pairs are " + firstEl + "-" + secondEl);
		
		return 0;
	
	}
	
	
}
