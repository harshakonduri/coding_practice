package nonrepeatedstring;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class NRString {
public static HashMap<Character,Integer> nr;

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(args[0]));
			String input="";
			while((input = br.readLine())!=null) {
				nr = new HashMap<Character, Integer>();
				for(int i=0;i<input.length();i++) {
					if(nr.containsKey(input.charAt(i))) {
						Integer val = nr.get(input.charAt(i));
						if(val > 2)
							continue;
						else {
						val++;
						nr.remove(input.charAt(i));
						nr.put(input.charAt(i), val);
						}
					}
					else {
						nr.put(input.charAt(i), 1);
					}
				}
				for(int i=0;i<input.length();i++) {
					int val = nr.get(input.charAt(i));
					if(val == 1) {
						System.out.println(input.charAt(i));
						break;
					}
				}
				nr = null;
			}
			br.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
