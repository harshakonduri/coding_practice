import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class prob22 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("names.txt")));
			String s = br.readLine();
			s.replaceAll("\"","");
			BigInteger result = new BigInteger("0");
			String [] st = s.split(",");
			Arrays.sort(st);
			for(int i = 1;i<=st.length;i++) {
				int score = 0;
				String temp = st[i-1].substring(1,st[i-1].length()-1);
				System.out.println(temp);
				for(int j = 0;j<temp.length();j++) {
					int k = (int)temp.charAt(j)-65+1;
					score+=k;
				}
				score = score*i;
				result = result.add(new BigInteger(score+""));
			}
			System.out.println(result.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
