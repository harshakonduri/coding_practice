import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ArrayHops {

	public static void main(String[] args) {
		String filePath = args[0];
		//try {
			int [] a =  {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};//readArray(filePath);
			buildPathWithMinHops(a);
		//} catch (IOException e) {
			//System.out.println("Failure");
			//System.exit(0);
			//e.printStackTrace();
		//}		
	}
	/**
	 * Assumptions : Format of Array not known so handle the case of array given using [ ] or
	 * comma separated integers.
	 * @param filePath : the path to file to read input data
	 * @return array : the input array read and built from the file.
	 * @throws IOException : any Exception during File IO
	 */
	private static int[] readArray(String filePath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
		// use string buffer to save on space wasted using immutable strings during 
		// concatenation of the entire file data to one string
		StringBuffer finalArray = new StringBuffer();
		int [] array = null;
		String inp = "";
		while((inp = br.readLine())!= null) {
			finalArray.append(inp);
		}
		if(finalArray.charAt(0) == '[' && finalArray.charAt(finalArray.length()-1) == ']') {
			inp = finalArray.substring(1, finalArray.length()-1);
		}
		else {
			inp = finalArray.toString();
		}
		String [] values = inp.split(",");
		array = new int[values.length];
		for(int i = 0;i<values.length;i++) {
			array[i] = Integer.parseInt(values[i].trim());
		}
		br.close();
		return array;
	}
	/**
	 * Approach : Use a dynamic programming approach to fill the path from
	 * 			  the current index to the position it can reach and move the 
	 * 			  pointer to the index to fill remaining array.
	 * 			  I use an auxiliary Array called Hops to identify the minimum hops 
	 * 			  to reach the current index and fromIndex to store the index it reached
	 * 			  The recurrence for Hops[j] =  Minimum{i<j; Hops[i]+1};
	 * 			  The value of 'i' in the above recurrence is stored in fromIndex[j]
	 *  For Example : Consider the input array 
	 *  			 5 6 0 4 2 4 1 0 0 4
	 *  Hops 	  =  0 1 1 1 1 1 2 2 2 2 3
	 *  FromIndex =  0 0 0 0 0 0 5 5 5 5 9
	 *  Worst Case Complexity : O(n2)
	 *  Average Case Complexity : O(n)
	 *  Best Case Complexity : O(n)
	 * 			   
	 * @param inputArray : input array read from the file.
	 */
	private static void buildPathWithMinHops(int[] inputArray) {
		if(inputArray.length <= 0) {
			System.out.println("Failure");
			return;
		}
		if(inputArray[0] == 0) {
			System.out.println("Failure");
			return;
		}
		int [] hops = new int[inputArray.length+1];
		int [] fromIndex = new int[inputArray.length+1];
		for(int i = 0; i < hops.length;i++) {
			hops[i] = Integer.MAX_VALUE;
		}
		for(int i = 0; i < hops.length;i++) {
			fromIndex[i] = -1;
		}
		hops[0] = 0;
		fromIndex[0] = 0;
		for(int i = 0;i < inputArray.length;i++) {
			int val = inputArray[i];
			for(int j = i; j<=i+val && j < hops.length;j++) {
				if(hops[i]+1 < hops[j]) {
					hops[j] = hops[i]+1;
					fromIndex[j] = i;
				}
			}
			//condition to check if from current index we can hop out of the array
			if(i+val >= hops.length) {
				break;
			}
			// Failure condition, current index not visited from
			// any previous index and value is 0
			if(i == (i+val) && fromIndex[i] < 0) {
				System.out.println("Failure");
				return;
			}
		}

		if(fromIndex[fromIndex.length-1] == -1) {
			System.out.println("Failure");
		}
		else {
			printPath(fromIndex);
		}
	}
	/**
	 * 
	 * @param fromIndex the path array built in the method buildPathWithMinHops
	 */
	private static void printPath(int[] fromIndex) {
		// use string buffer to save on space from creating new string objects
		StringBuffer path = new StringBuffer();
		int end = fromIndex.length-1;
		while(end > 0) {
			path.append(fromIndex[end]+", ");
			end = fromIndex[end];
		}
		System.out.println(path.reverse().substring(2));
	}

}
