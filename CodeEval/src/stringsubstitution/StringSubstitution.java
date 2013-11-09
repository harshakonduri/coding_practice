package stringsubstitution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StringSubstitution {
ArrayList<String> resultString = new ArrayList<String>();

	public StringSubstitution(String input) {
	resultString.add(input);
	}
	public static void main(String[] args) {
		String filename = args[0];
		String [] allinputs=null;
		String [] inputs=null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(filename)));
			String str;
			while ((str = br.readLine()) != null) {
				String result = "";
				allinputs = str.split(";");
				StringSubstitution s = new StringSubstitution(allinputs[0]);
				inputs = allinputs[1].split(",");
				s.findResult(inputs);
				for(String res : s.resultString) {
					if( res.length() > 1 && (res != " " || res != "")) {
						if(res.charAt(res.length()-1) == ':') {
							String t = res.substring(0, res.length()-1);
							result+=t;
						}
						else {
							result+=res;
						}
						
					}
				}
				System.out.println(result);
			}
						
		}
		catch(FileNotFoundException f) {
			//System.out.println("no file");
		}
		catch(IOException e) {
			
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
					e.printStackTrace();
			}
		}

	}
	void findResult(String []inp) {
		String source=null;
		String rep=null;
		for(int i=0;i<inp.length;i++) {
			source = inp[i];
			i++;
			rep = inp[i];
		
			for(int k = 0;k<resultString.size();k++) {
				String eachStr = resultString.get(k);
				searchandSplit(eachStr,source,rep,k);
			}
			
		}
	}
	void searchandSplit(String original,String source, String rep,int pos) {
		if(original.length() < source.length()) {
			return;
		}
		if(original.contains(":")) {
			return;
		}
		for(int i=0;i<original.length();i++) {
			int count=0;
			for(int j=0;j<source.length();j++) {
				if(source.length() <= (original.length() - i)) {
				if(original.charAt(i+count) == source.charAt(j)) {
					count++;
				}
				else {
					break;
				}
				}
			}
			if(count == source.length()) {
				
				resultString.remove(original);
				String sub = original.substring(0, i);
				String end = original.substring(i+source.length());
				resultString.add(pos,sub);
				resultString.add(pos+1,rep+":");
				resultString.add(pos+2,end);
				return;
			}
		}
		
	}

}
