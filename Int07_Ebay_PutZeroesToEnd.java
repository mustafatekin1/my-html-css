package interviewquestions;

import java.util.Arrays;

public class Int07_Ebay_PutZeroesToEnd {

	public static void main(String[] args) {
		// Ebay interview question
		// put zeros to to the end of a given int array
		// {0,2,3,0,0,5,6} ==> {2,3,5,6,0,0,0} 
		int arr[] = {0,2,3,0,0,5,6};
	
		putZerosToEnd(arr);
	
	
	}

	
	public static void putZerosToEnd(int arr[]) {
		
		int brr[] = new int[arr.length];
		int index = 0 ;
		
		for (int i = 0; i<arr.length; i++) {
			if (arr[i]==0) {
				brr[arr.length-1] = 0; //actually no need because empty elements would be filled with 0
			}
			else {
				brr[index]=arr[i];
			index++;
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(brr));
	}
	
	
}
