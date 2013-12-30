package lcs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String input="";
			while((input=br.readLine())!=null) {
				String [] values = input.split(";");
				String [][] store = new String[values[0].length()+1][values[1].length()+1];
				values[0] = values[0].trim();
				values[1] = values[1].trim();
				for(int i=0;i<values[0].length()+1;i++) {
					store[i][0] = 0+":"+0;
				}
				for(int i=0;i<values[1].length()+1;i++) {
					store[0][i] = 0+":"+0;
				}
				for(int i=1;i<=values[0].length();i++) {
					for(int j =1;j<=values[1].length();j++) {

						if(values[0].charAt(i-1) == values[1].charAt(j-1)) {
							/*if(i==0 || j == 0) {
								store[i][j] = 1+":"+1;
								//continue;
							}*/
							//else {
								String preval = store[i-1][j-1];
								String [] sub = preval.split(":");
								int v = Integer.parseInt(sub[0]);
								store[i][j] = (v+1)+":"+1;
							//}
						}
						else {
							/*if(i==0 || j == 0) {
								store[i][j] = 0+":"+0;
								//continue;
							}*/
							//else {
								String preij = store[i-1][j];
								String [] sub = preij.split(":");
								int v = Integer.parseInt(sub[0]);
								String iprej = store[i][j-1];
								String [] isub = iprej.split(":");
								int vv = Integer.parseInt(isub[0]);
								if(vv > v) {
									store[i][j] = vv+":"+0;	
								}
								else {
									store[i][j] = v+":"+2;
								}
							//}
							
						}
						 
					}
				}
				for(int i=0;i<=values[0].length();i++) {
					for(int j=0;j<=values[1].length();j++) {
						System.out.print(store[i][j]+" ");
					}
					System.out.println();
				}
				//for(int i=values[0].length();i>0;) {
				//	for(int j=values[1].length();j>0;) {
				StringBuffer result = new StringBuffer();
			int i=values[0].length();
			int j=values[1].length();
			while(i>0 && j>0) {
				//if(i>=0 && j>=0) {
				//System.out.println(i+" "+j);
						String valij = store[i][j];
						String [] pr = valij.split(":");
						int fromLoc = Integer.parseInt(pr[1]);
						if(fromLoc == 1) {
							result.append(values[0].charAt(i-1));
							//System.out.println(values[0].charAt(i-1));
							//System.out.println(values[0].charAt(j)+" "+values[1].charAt(j));
							i--;
							j--;
							//continue;
						}
						else if(fromLoc == 0) {
							j--;
							//continue;
						}
						else if(fromLoc == 2) {
							i--;
							//continue;
						}
					//}
					}
				//}
			System.out.println(result.reverse());
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
