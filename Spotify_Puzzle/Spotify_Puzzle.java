class Spotify_Puzzle {
    public static void main(String args[]) {
	int n = 13;
	int m = n;
	int leftmost = -1;
	while (m > 0) {
	    leftmost++;
	    m >>= 1;
	}
   
	// reverse the binary number 
	int i,j;
	int reversednumber = 0;
	for (i=0, j=leftmost; i <= j; ++i, --j) {
	    if ((n & (1 << j)) > 0) {
		reversednumber |= (1 << i);
	    }
	    if ((n & (1 << i)) > 0) {
		reversednumber |= (1 << j);
	    }
	}
		System.out.println(reversednumber);
    }
}
