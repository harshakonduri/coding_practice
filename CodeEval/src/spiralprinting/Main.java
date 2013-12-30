package spiralprinting;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br=null;
		try {
			br = new BufferedReader(new FileReader(args[0]));
		String input="";
		while((input=br.readLine())!=null) {
			if(input.length() > 0) {
			String [] values = input.split(";");
			String [] valuess = values[2].split(" ");
			int rows = Integer.parseInt(values[0]);
			int cols = Integer.parseInt(values[1]);
			int [][] matrix = new int[rows][cols];
			for(int i=0;i<rows;i++) {
				for(int j=0;j<cols;j++) {
					matrix[i][j] = Integer.parseInt(valuess[(i*rows)+j]);
				}
			}
			/*for(int i=0;i<rows;i++) {
				for(int j=0;j<cols;j++) {
					System.out.print(matrix[i][j]);
				}
				System.out.println();
			}*/
			int left=0,down=0,up=rows-1,right=cols-1;
			while(rows>=0 && cols >=0) {
			for(int i =left;i<cols;i++) {
				System.out.print(matrix[left][i]+" ");
			}
			
			//System.out.println();
			for(int i =++down;i<rows;i++) {
				System.out.print(matrix[i][cols-1]+" ");
			}
			//System.out.println();
			for(int i =--right;i>=left;i--) {
				System.out.print(matrix[rows-1][i]+" ");
			}
			//System.out.println();
			for(int i =--up;i>left;i--) {
				System.out.print(matrix[i][left]+" ");
			}
			//System.out.println();
			rows--;
			cols--;
			left++;
			}
			}
		}
		br = new BufferedReader(new FileReader(args[0]));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
