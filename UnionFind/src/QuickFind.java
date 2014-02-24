public class QuickFind {
    int [] id;
    int size;
    public QuickFind(int size) {
	this.size = size;
	id = new int[size];
	for(int i = 0;i < size; i++) {
	    id[i] = i;
	}
    }
    /**
     * connect points/components p and q
     */
    void union(int p,int q) {
	int pid = id[p];
	int qid = id[q];
	for(int i = 0;i < size; i++) {
	    if(pid == id[i]) {
		id[i] = qid;
	    }
	}
	//	id[p] = id[q];
	for(int i : id) {
	    System.out.print(i+" ");
	}
	System.out.println();
    }
    boolean find(int p,int q) {
	System.out.println(id[p]+" "+id[q]);
	return (id[p] == id[q]);
    }
    public static void main(String [] args) {
	QuickFind q = new QuickFind(10);
	System.out.println(q.find(0,3));
	q.union(0,3);
	q.union(4,3);
	q.union(5,6);
	q.union(0,5);
	System.out.println(q.find(0,3));
	System.out.println(q.find(0,6));
	System.out.println(q.find(4,6));
    }
}