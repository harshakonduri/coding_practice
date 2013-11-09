package prefixexp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String input = "";
			while((input = br.readLine())!=null) {
				String [] ele = input.split(" ");
				ArrayList<String> stack = new ArrayList<String>();
				for(String s:ele) {
					if(s.equals("+")) {
						
					}
					else if(s.equals("*")) {
						
					}
					else if(s.equals("/")) {
						
					}
					else {
						int i = Integer.parseInt(s);
					}
				}//end loop of input
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
