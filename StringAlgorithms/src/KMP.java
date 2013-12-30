class KMP {
    public static void main(String [] args) {
	String text = "abacabac";
	String pattern = "abab";
	int [] tab = new int[pattern.length()];
	tab = prefixTable(tab,pattern);
	for(int i:tab) {
		System.out.print(i+ " ");
	}
	System.out.println(kmpSearch(text,pattern,tab));
    }
    public static int [] prefixTable(int [] pat,String pattern) {
	int i=0,j=1;
	pat[i]=0;
	while(j<pattern.length()) {
	    if(pattern.charAt(i) == pattern.charAt(j)) {
		pat[j] = i+1;
		i++;j++;		
	    }
	    else {
	    	if(i > 0) {
	    		i = pat[i-1];
	    	}
	    	else {
	    		pat[j] = 0;
	    		j++;
	    	}
	    }
	    
	}
    	return pat;
    }
    public static boolean kmpSearch(String text,String pattern,int []pat) {
	int i=0,j=0;
	while(j<text.length()) {
	    if(text.charAt(j) == pattern.charAt(i)) {
		if(i == pattern.length()-1) {
			System.out.println(text.charAt(j)+" "+j);
			System.out.println(pattern.charAt(i)+" "+i);
		    return true;
		}
		i++;
		j++;
	    }
	    else {
		if(i<=0) {
		    j++; // if value of fx is 0 increment only j
		}
		else {
		    i = pat[i];
		}
	    }
	}
	return false;
    }
}
