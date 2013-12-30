package fb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) {
		BufferedReader br=null;
		int testcases = 0;
		Integer test = null;
		try {
			InputStreamReader ir = new InputStreamReader(System.in);
			br = new BufferedReader(ir);
		String input="";
		if((input=br.readLine())!=null) {
			testcases = Integer.parseInt(input);
		}
		while(testcases > 0 && (input=br.readLine())!=null) {
			boolean valid = countChanges(input);
			if(valid) {
				System.out.println(0);
			}
			else {
				int minimum = getMin(input);
				System.out.println(minimum);
			}
			testcases--;
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static int getMin(String input) {
		// TODO Auto-generated method stub
		if(input.length() == 1) {
			if(countChanges(input)) {
				return 0;
			}
			else {
				return 1;
			}
		}
		else if(input.length() == 2) {
			if(input.equals("**")) {
				return 2;
			}
			else {
				return 1;
			}
		}
		char begin = input.charAt(0);
		char end = input.charAt(input.length()-1);
		if(begin == 'x') {
			if(end == 'x') {
				return 1+getMin(input.substring(1,input.length()-1));
			}
			else {
				return getMin(input.substring(1,input.length()-1));
			}
		}
		else if(begin == '*'){
		if(end == '*') {
			return Math.min((int)(1+getMin(input.substring(1))),
							(int)(2+getMin(input.substring(1,input.length()-1))));
		}
		else {
			return 2+getMin(input.substring(1,input.length()-1));
		}
		}
		
		return 2+getMin(input.substring(1,input.length()-1));
	}

	private static boolean countChanges(String input) {
		// TODO Auto-generated method stub
		int count = 0;
		//ArrayList<String> stack = new ArrayList<String>();
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i) == '*') {
				if(count >= 2) {
					count--;	
				}
				else {
					return false;
				}
			}
			else {
				//stack.add(input.charAt(i)+"");
				count++;
			}
		}
		if(count == 1) {
			return true;
		}else { return false; }
		
	}
	
}
