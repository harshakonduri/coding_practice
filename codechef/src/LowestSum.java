
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class LowestSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int testcases = Integer.parseInt(s);
		for(int t = 0;t < testcases;t++) {
		s = br.readLine();
		String [] pq = s.split(" ");
		int chefs = Integer.parseInt(pq[0]);
		int queries = Integer.parseInt(pq[1]);
		s = br.readLine();
		String [] astr = s.split(" ");
		long [] a = new long[chefs];
		for(int i = 0; i < astr.length;i++)
			a[i] = Long.parseLong(astr[i]);
		s = br.readLine();
		String [] bstr = s.split(" ");
		long [] b = new long[chefs];
		for(int i = 0; i < bstr.length;i++)
			b[i] = Long.parseLong(bstr[i]);
		/* */
		 long [] res = new long[chefs*chefs];
		 int k = 0;
		 for(long i : a)
		 {	 for(long j : b)
			 {
				 res[k++] = i+j;
			 } }
		 Arrays.sort(res);
		 /* */
		while(queries-- > 0 && (s = br.readLine())!= null) {
			int q = Integer.parseInt(s);
			System.out.println(res[q-1]);
		}
		}
		}
		catch(IOException iue) {
			System.out.println("hi");
		}
	}

}
