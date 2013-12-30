package fb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {

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
			test = Integer.parseInt(input);
			int ones = countones(test);
			int count = 0;
			int temp_res = 0;
			while(true) {
			 temp_res = beautyNumbers(test,ones);
			 if(temp_res < 0) {
				 if(count % 2 == 0) {
					 System.out.println("Second Player");
				 }
				 else {
				 System.out.println("First Player");
				 }
				 break;
			 }
			 else {
				 count++;
//				 System.out.println(temp_res);
				 ones = countones(temp_res);
				 test = temp_res;
			 }
			}
			testcases--;
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static int beautyNumbers(Integer test, int ones) {
		int res = 0;
		int temp=1;
		int countresult = 0;
		Integer beauty = null;
		beauty = test - temp;
		countresult = countones(beauty);
		if(countresult == ones) {
			res = temp;
			
		}
		
		while(temp < test) {
			temp = temp << 1;
			if(temp > test) {
			break;
			}
			else {
				beauty = test-temp;
				countresult = countones(beauty);
				if(countresult == ones) {
					res = temp;
				}
			}			
		}
		if(res > 0) {
			return test - res;
		}
		else {
			return -1;
		}
	}

	private static int countones(Integer test) {
		String s = Integer.toBinaryString(test);
		int count=0;
		for(int i = 0; i < s.length();i++) {
			if(s.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}

}
