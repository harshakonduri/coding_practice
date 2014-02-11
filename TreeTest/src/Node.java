public class Node {
    Node left;
    int data;
    boolean visited;
    Node right;
    Node sibling;
    public Node(int d,Node l,Node r)
    {
	data=d;
	left=l;
	right=r;
    }
}
