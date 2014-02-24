public class ElementRepeatedMoreThanHalf {
    public static void main(String []a) {
    	//92,19,19,76,19,21,19,85,19,19,19,94,19,19,22,67,83,19,19,54,59,1,19,19
    	//92,11,30,92,1,11,92,38,92,92,43,92,92,51,92,36,97,92,92,92,43,22,84,92,92
    	int [] A = {92,11,30,92,1,11,92,38,92,92,43,92,92,51,92,36,97,92,92,92,43,22,84,92,92};//{2,2,2,2,2,2,1,2,3,4,1};
    	int key = halfrepeat(A);
    	if(isMajor(A, key))
    		System.out.println(key);
    	else
    		System.out.println("None");
    }
    public static int halfrepeat(int [] a) {
	int elementRepeated = a[0];
	int elementcount = 1;
	for(int i=1;i<a.length;i++) {
		if(a[i] == elementRepeated) {
			elementcount++;
		}
		else {
			elementcount--;
		}
		if(elementcount == 0) {
			elementRepeated = a[i];
			elementcount = 1;
	    }
	}
	return elementRepeated;
    }
    public static boolean isMajor(int [] a,int elem) {
    	int count = 0;
    	for(int i:a) {
    		if(i == elem) {
    			count++;
    		}
    	}
    	if(count > a.length/2) {
    		return true;
    	}
    	else 
    		return false;
    }
}
