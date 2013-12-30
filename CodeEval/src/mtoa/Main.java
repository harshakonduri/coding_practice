package mtoa;

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
			String [] values = input.split(" ");
			if(values.length > 2) {
			int mtoa = Integer.parseInt(values[values.length -1]);
			int ind = values.length - 1 - mtoa;
			if(ind>=0 && ind<= values.length-1) {
				System.out.println(values[ind]);
			}
			/*int i,j;
			for(i=0,j=mtoa;j<values.length-1;i++,j++) {
				
			}
			System.out.println(values[i]); */
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
