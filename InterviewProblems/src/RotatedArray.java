public class RotatedArray {
	static int [][]a = {{1,2,3},{4,5,6},{7,8,9}};
    public static void main(String [] args) {
	spiralPrint(a);//print(a);
	for(int i = 0;i<a.length-1;i++) {
	 //   rotateArray(a,i,a.length-1);
	}
//	print(a);
    }
    static void rotateArray(int [][] a, int st,int end) {
	for(int k = st;k < end-st;k++) {
		System.out.println((st+k)+" "+" " + (end - (st+k)));
		int temp = a[st][st+k];
	    a[st][st+k] = a[end - (st+k)][st];
	    a[end - (st+k)][st] = a[end - st][end - (st+k)];
	    a[end - st][end - (st+k)] = a[st+k][end -st];
	    a[st+k][end -st] = temp;
	}
	print(a);
    }
    static void print(int [][]a) {
	for(int i = 0;i<a.length;i++) {
	    for(int j = 0; j < a.length;j++) {
		System.out.print(a[i][j]+" ");
	    }
	    System.out.println();
	}
    }
    static void spiralPrint(int [][]a) {
    	//System.out.println(a.length+" "+a[0].length);
    	int rows = a.length;
    	int cols = a[0].length;
    	int i = 0,j=0;
    	int in = 0;
    	int c = rows*cols;
    	while(c>0) {
    		while(j <= cols - 1 - in && c>0) {
    			System.out.print(a[i][j]+" ");
    			j++;
    			c--;
    		}
    		//System.out.println();
    		j--;
    		i++;
    		while(i <= rows - 1 - in&& c>0) {
    		System.out.print(a[i][j]+" ");
    		i++;
    		c--;
    		}
    		//System.out.println();
    		i--;
    		j--;
    		while(j>= in&& c>0) {
    			System.out.print(a[i][j]+" ");
    			j--;
    			c--;
    		}
    		//System.out.println();
    		in++;
    		j++;
    		i--;
    		while(i>=in&& c>0){
    			System.out.print(a[i][j]+" ");
    			i--;
    			c--;
    		}
    		i++;
    		j++;
    		//System.out.println();
    		
    	}
    }
}
