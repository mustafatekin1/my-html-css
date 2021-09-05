package interviewquestions;

public class Int04_FindEvenFromArrayPairs {

	public static void main(String[] args) {
		// From a given array find all pairs whose sum is a given number.
		//ex: {4, 6, 5, -10, 8, 5, 20} ==> 10
// For example: 4+6=10, 5+5=10, -10+20=10  
		
		int arr[] = {4, 6, 5, -10, 8, 5, 20, 4 , 5};
		
		arrayPairs(arr, 100);
		
		
	}

	public static void arrayPairs(int arr[], int num) {
		int counter = 0;
		for (int i = 0; i<arr.length; i++) {
			
			for (int j=i+1; j<arr.length; j++) {
				
				if (arr[i] + arr[j] == num) {
					
					System.out.print(arr[i] +"+" + arr[j] +"="+ num);
					System.out.println();
					counter++;
					
					};
				
				}

			
		}
			
		if (counter == 0) {
			System.out.println("There is no suitable pairs");	
			
			
		}
		
		
	}
	
	
	
	
}
