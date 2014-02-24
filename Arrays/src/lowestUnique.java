public class lowestUnique {
 public static void main(String[] args) {
	int [] a = {3 ,3, 9, 1 ,6, 5, 8, 1, 5,3};
	System.out.println(getlow(a));
 }
	static int getlow(int []a) {
	      int [] b = new int[10];
	      for(int i:a) {
	    	  System.out.print("i value = "+i);
	    	  System.out.println();
	          if(b[i] == 1) { // means already seen
	              b[i] *= -1;
	          }
	          else if(b[i] == 0) {
	              b[i] = b[i]+1;
	          }
	          for(int j : b) {
	        	  System.out.print(j+" ");
	          }
	          System.out.println();
	      }
	      for(int j : b) {
        	  System.out.print(j+" ");
          }
	      for(int i = 1;i <=9;i++) {
	          if(b[i] > 0) {
	        	  for(int l = 1;l <= a.length;l++) {
	        		if(a[l-1] == i) {
	        			return l;
	        		}
	        	  }
	          }
	      }
	      return 0;
	  }

}
