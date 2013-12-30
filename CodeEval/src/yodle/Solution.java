package yodle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String [] args) {
    	BufferedReader triangleReader = null;
    	try {
    		int [][] triangle = new int [100][100];
    		triangleReader = new BufferedReader(new FileReader(new File("triangle.txt")));
			String str = "";
			int i=0,j=0;
			while((str = triangleReader.readLine()) != null) {
				String [] ip = str.split(" ");
				for(String s : ip) {
					triangle[i][j++] = Integer.parseInt(s);
				}
				i++;
				j=0;
			}
			System.out.println(getMaxPath(triangle));
			
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally {
    		try {
				triangleReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    /**
     * 
     * @param inputTriangle the triangle parsed as an array and passed as Input
     * @return the max sum of the root to leaf path
     * The Solution I used is a Dynamic Programming Solution where in the sub problems  
     * are solved in a bottom up fashion from the leaves to the root.
     * The last row of the triangle form the leaves and the sum is calculated once per node
     * in the above levels.
     * As we travel up towards the root, the max sum is stored in the root.
     */
    static int getMaxPath(int [][]inputTriangle) {
		for(int p = inputTriangle.length-1;p >= 0 ; p--) {
			for(int q = 0;q < p ; q++) {
				inputTriangle[p-1][q] = inputTriangle[p-1][q] + Math.max(inputTriangle[p][q], inputTriangle[p][q+1]);
			}
		}
		return inputTriangle[0][0];
    }
}
