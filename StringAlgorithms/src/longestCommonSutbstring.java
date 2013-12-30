
public class longestCommonSutbstring {

	static int len[][];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "abab";
		String s2 = "baba";
		len = new int[s1.length()+1][s2.length()+1];
		System.out.println(lcs(s1,s2));

	}

	 static int lcs(String s1, String s2) {
		int result=0;
		 for(int i=0;i<=s1.length();i++) {
			 for(int j=0;j<=s2.length();j++) {
				 if(i ==0 || j == 0) {
					 len[i][j] = 0;
				 }
				 else if(s1.charAt(i-1) == s2.charAt(j-1)) {
					 len[i][j] = len[i-1][j-1] + 1;
					 result = (result>len[i][j])?result:len[i][j];
				 }
				 else {
					 len[i][j] = Math.max(len[i-1][j], len[i][j-1]);
				 }
			 }
		 }
		 return result;
	}

}
