package interviewquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Int06Mountain_Google {

	public static void main(String[] args) {
// check if Mountain array : [0,2,5,4,3,1}
		int arr[] = {5,2,7,1,0};
		int arr2[] = { 0,2,5,4,3,1};
		checkMountain(arr);
		System.out.println("====");
		checkMountain(arr2);
		
		System.out.println("==========");
		checkMountainFunc(arr);
		System.out.println("==========");
		checkMountainFunc(arr2);

	}
	/*1st way eith structured programming:
	 * - Find max value
	 * - Till max value elements should be ascending order
	 * - From max value to end elements should be descending order
	 * - If both are true, the array is "mountain"	
	 */
	public static boolean checkMountain(int arr[]) {
		boolean check = false;
		
		int indexOfMax=0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i<arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				 indexOfMax = i;
			}
		}	 
		 System.out.println(max);
		 System.out.println("index of max is " + indexOfMax);
		 
		
		 boolean increment = false;
		 for (int i=0; i<indexOfMax; i++) {
			 if (arr[i]<arr[i+1]) {
				 increment = true;
			 }  else {
				 increment = false;
				 break;
			 }
		 }
		boolean decrement = false;
		
		for (int i=indexOfMax+2; i<arr.length; i++) {
			if (arr[i-1]>arr[i]) {
				decrement = true;
			} else {
				decrement = false;
				break;
			}
		}
		 
		if (increment&&decrement) {
			check = true;
		}
		 
		 System.out.println("Structured method result = " + check);
		 
		return check;
		
	}
	
/*2nd way using functional programming:
 * -1st step Find max value and index of the max value
 * -2nd step Till max value elements should be ascending order
 * -3rd step From max value to end elements should be descending order
 * -4th step If both are true, the array is "mountain"	
 */
public static void checkMountainFunc(int arr[]) {
	
	// 2nd way to find max with func programming
//	int max2 = Arrays.stream(arr).max().getAsInt();

	// 3rd way for "max"
//	int max3 = Arrays.stream(arr).reduce(Integer.MIN_VALUE, Math::max);
//	System.out.println(max3);
	
	//System.out.println(Arrays.asList(arr).indexOf(max));
	// asList did not work so Lets create an ArrayList
			//-1st step
// a. create a list	and add elements to list with forEach loop functional prog
List<Integer> list = new ArrayList<>();	
Arrays.stream(arr).forEach(t->list.add(t));
// Another way to find max
//int max = IntStream.of(arr).max().getAsInt();

//b. find max
int max = list.stream().reduce(Integer.MIN_VALUE, Math::max);
System.out.println(max);

//c. fin index of max element
int indexOfMax2 = list.indexOf(max);
System.out.println(indexOfMax2);

			//-2nd step:Till max value elements should be ascending order
// Sort the list in ascending order then compare it with the unsorted.

List<Integer> list1 = list.subList(0, indexOfMax2+1);
System.out.println(list1);

List<Integer> list1Sorted = new ArrayList<>();
list1.stream().forEach(t->list1Sorted.add(t));
System.out.println(list1Sorted);//same with list1

Collections.sort(list1Sorted); // sorted list1
System.out.println(list1Sorted);// check the console

boolean isList1Ascending = (list1.equals(list1Sorted));
System.out.println("functional first part: " +isList1Ascending);

				//-3rd step From max value to end elements should be descending order

List<Integer> list2 = new ArrayList<>();
list.stream().filter(t->indexOfMax2<=list.indexOf(t)).forEach(t->list2.add(t));
System.out.println(list2);

List<Integer> list2Sorted = new ArrayList<>();
list2.stream().sorted().forEach(t->list2Sorted.add(t));
Collections.reverse(list2Sorted);
System.out.println(list2Sorted);

boolean isList2Descending = list2.equals(list2Sorted);
System.out.println("Functional second part: " + isList2Descending);

				//-4th step If both are true, the array is "mountain"
boolean check = isList1Ascending&&isList2Descending;
System.out.println("Functional method result = " + check);
}
	
}
