public class MinimumCoinSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] denom = {1,2,3};
		int Sum = 11;
		findMinCoins(denom,Sum);
	}
	public static void findMinCoins(int []den,int S) {
	    int coins = den.length;
	    int [] Min = new int[S+1];
	    int [] denUsed = new int[S+1];
	    for(int i = 0;i<=S;i++)
		Min[i] = Integer.MAX_VALUE;
	    
	    Min[0]=0;
	    for(int i = 1;i <=S;i++) {
		for(int j = 0;j<coins;j++) {
		    if(den[j]<= i && Min[i-den[j]]+1 < Min[i]) {
			Min[i] = Min[i-den[j]]+1;
			System.out.println("used"+den[j]+" for value "+i);
			denUsed[i] = den[j];
		    }
		}
	    }
	    for(int min:Min) {
		System.out.print(" "+min);
	    }
	    System.out.println();
	    int val = S;
	    while(val > 0) {
		System.out.print(" "+denUsed[val]);
		val = val-denUsed[val];
	    }
	}
}
