
public class ActivitySelection {

	public static void main(String[] args) {
	     int start[]  =  {1, 3, 0, 5, 8, 5, 9};
	     int finish[] =  {2, 4, 6, 7, 9, 9, 10};
	     int i =0,j=0;
	     System.out.println("Scheduling "+start[i]+"- ends at"+finish[j]);
	     i++;
	     while(i<start.length-1) {
	    	 if(start[i]<finish[j]) {
	    		 i++;
	    	 }
	    	 if(start[i]>=finish[j]) {
	    		 j = i;
	    		 System.out.println("Scheduling "+start[i]+"- ends at"+finish[j]);
	    	 }
	     }
	}

}
