import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
Node root;
public static void main(String[] args) {
System.out.println("hello");
		Main b=new Main();
		/*int []a={1,2,3,4,5,6,7,8,9,10};
		b.buildFromArray(a);
		b.disp_inOrder(b.root);*/
		b.insert(30);
		b.insert(8);
		b.insert(52);
		b.insert(3);
		b.insert(20);
		b.insert(10);
		b.insert(29);
		/*b.insert(6);
		b.insert(8);
		b.insert(12);
		b.insert(17);
		b.insert(11);
		b.insert(13);
		b.insert(16);
		b.insert(18);
		*/System.out.println(b.ancestor(b.root, 8, 52));
		
		String file = args[0];
		String line="";
		try
		{
		    BufferedReader br = new BufferedReader(new FileReader(file));
		    while( (line = br.readLine()) != null)
			{
		    	String [] val = line.split(" ");
		    	System.out.println(b.ancestor(b.root, Integer.parseInt(val[0]), Integer.parseInt(val[1])));
		    }
		    br.close();
		}
		catch(Exception e)
		    { System.out.println("exception");}
		//b.disp_inOrder(b.root);
		//System.out.println(b.getSuccessor(5));
		//b.dispSiblings(b.root);
		/*int tree_height=b.getHeight(b.root);
		ArrayList [] a=new ArrayList[tree_height];
		for(int i=0;i<tree_height;i++)
		{
			a[i]=new ArrayList();
		}
		for(int i=1;i<=b.getHeight(b.root);i++)
		{
			a[i-1] = b.disp_levelOrder(b.root, i,a[i-1]);
		}*/
		//System.out.println("List 1: "+a[0]+"List 2"+a[1]+"List 3"+a[2]+"List 4:"+a[3]);
		//Node m=b.getNode(5);
		//System.out.println("recv node = "+m.data);
		//System.out.println("Leaves are :"+b.getNumberOfLeaves(b.root));
	//	System.out.println("height="+b.getHeight(b.root));
		
		//
		//b.disp_inOrder(b.root);
		//b.disp_postOrder(b.root);
		//b.disp_preOrder(b.root);
	}
public void insert(int d)
{
	root = insert(root,d);
}
//Recursive Solution
public Node insert(Node r,int d)
{
	if(r==null)
	{
		r=new Node(d,null,null);
	}
	else
	{
		if(d<=r.data)
			r.left = insert(r.left,d);
		else
			r.right = insert(r.right,d);
	}
	return r;
}
public void buildFromArray(int [] a)
{
	root = buildTree(a,0,a.length-1);
}
public Node buildTree(int []a,int begin,int end)
{
	if(begin>end)
		return null;
	int mid=(begin+end)/2;
	Node temp=new Node(a[mid],null,null);
	temp.left=buildTree(a, begin, mid-1);
	temp.right=buildTree(a, mid+1, end);

return temp;
}
public boolean search(int d)
{
return search(root,d);	
}
public boolean search(Node r,int d)
{
	if(r==null)
	{
		return false;
	}
	if(d == r.data)
	{
		return true;
	}
	else if(d<r.data)
	{
		return search(r.left,d);
	}
	else if(d>r.data)
	{
		return search(r.right,d);
	}
	return false;
}
//recursively
/*public int getNumberOfNodes(Node r)
{
	if(r==null)
		return 0;
	//System.out.println(r.data);
	return (getNumberOfNodes(r.left)+1+getNumberOfNodes(r.right));
}*/
//non-recursively
public int getNumberOfNodes(Node r)
{
	int count=0;
ArrayList<Node> a=new ArrayList<Node>();
a.add(r);
while(!a.isEmpty())
{
	Node temp=a.remove(0);
	System.out.print(temp.data+" ");
	count++;
	if(temp.left!=null)
		a.add(temp.left);
	if(temp.right!=null)
		a.add(temp.right);
}
return count;
}
public Node getNode(int val)
{
	Node p= getNode(root,val);
	return p;
}
public Node getNode(Node r,int v)
{
	if(r==null)
	{
		if(r==root)
			System.out.println("is root null?");
		
		return null;
	}
	if(r.data == v)
	{
		System.out.println(r.data);
		return r;
	}
	else if(v < r.data)
	{
		System.out.println("search left");
		return getNode(r.left,v);
	}
	else if(v > r.data)
	{
		System.out.println("search right");
		return getNode(r.right,v);
	}
	
	return null;
}
public int getNumberOfLeaves(Node r)
{
	int count=0;
ArrayList<Node> a=new ArrayList<Node>();
a.add(r);
while(!a.isEmpty())
{
	Node temp=a.remove(0);
	System.out.println(a.isEmpty() + " size : "+a.size());
	if(temp.left==null && temp.right==null)
		count++;
	
	if(temp.left!=null)
		a.add(temp.left);
	if(temp.right!=null)
		a.add(temp.right);
}
return count;
}
public int getHeight(Node r)
{
	int leftHeight=0,rightHeight=0;
	if(r.left!=null)
		leftHeight=getHeight(r.left);
	if(r.right!=null)
		rightHeight=getHeight(r.right);
	
	return (Math.max(leftHeight, rightHeight)+1);
}
boolean isFound=false;
int res=999;
public int getSuccessor(int val)
{
	return getSuccessor(root, val);
}
public int getSuccessor(Node r,int val)
{
	if(r == null)
		return -1;

	
	getSuccessor(r.left,val);
	

	if(isFound)
{
	System.out.println("Successor is"+r.data);
	res=r.data;
	isFound = false;
}
//	System.out.println(r.data);
	if(r.data == val)
		isFound=true;
	getSuccessor(r.right,val);
	
	//System.out.println("111111111111"+val);
	//}
	return res;
}
public void disp_levelOrder(Node r,int level)
{
	if(r==null)
		return;
	if(level == 1)
		System.out.println(r.data);
	
	disp_levelOrder(r.left, level-1);
	disp_levelOrder(r.right, level-1);
	
}
public ArrayList disp_levelOrder(Node r,int level,ArrayList a)
{
	if(r==null)
	{
		//System.out.println();
		return a;
	}
	if(level == 0)
		{
			a.add(r.data);
			System.out.print(r.data+ " ");
			return a;
		}
	
	a = disp_levelOrder(r.left, level-1,a);
	a = disp_levelOrder(r.right, level-1,a);
	
	return a;
}
public void dispSiblings(Node root)
{
	if(root==null)
		return;
	if(root.left!=null && root.right!=null)
	System.out.println("Siblings:"+root.left.data+"and "+root.right.data);
	dispSiblings(root.left);
	dispSiblings(root.right);
}
public void iter_pre(Node root)
{
	ArrayList<Node> a=new ArrayList<Node>();
	a.add(root);
	while(!a.isEmpty())
	{
		int size=a.size();
		Node temp=a.remove(size-1);
		System.out.print(temp.data+" ");
		if(temp.right!=null)
			a.add(temp.right);
		if(temp.left!=null)
			a.add(temp.left);
	}
}
public void iter_post(Node root)
{
	ArrayList<Node> a=new ArrayList<Node>();
	a.add(root);
	root.visited=true;
	while(!a.isEmpty())
	{
		int size=a.size();
		Node temp=a.get(size-1);
		if(((temp.left==null || temp.left.visited)) && ((temp.right==null)||(temp.right.visited)))
		{
			temp=a.remove(size-1);
		System.out.print(temp.data+" ");
		}
		else{
		if(temp.right!=null)
		{
			a.add(temp.right);
			temp.right.visited=true;
		}
		if(temp.left!=null)
		{
			a.add(temp.left);
			temp.left.visited=true;
		}
		}
	}
}
public int ancestor(Node root,int left,int right)
{
	if((left < root.data) && (right > root.data))
	{
		return root.data;
	}
	else if((left < root.data) && (right < root.data))
	{
		return ancestor(root.left, left, right);
	}
	else
	{
		return ancestor(root.right, left, right);
	}
	
}
public boolean isBST(Node root)
{
	boolean b=false;
	if(root == null)
		return false;
	if(root.left!=null && root.right!=null){
	if(root.left.data < root.data && root.right.data > root.data)
		b=true;
	else
		b=false;
	
	isBST(root.left);
	isBST(root.right);
	}
		return b;
}
public void disp_inOrder(Node root)
{
	if(root == null)
		return;
	disp_inOrder(root.left);
	System.out.print(root.data+" ");
	disp_inOrder(root.right);
}
public void disp_preOrder(Node root)
{
	if(root == null)
		return;
	System.out.print(root.data+" ");
	disp_preOrder(root.left);
	disp_preOrder(root.right);
}
public void disp_postOrder(Node root)
{
	if(root == null)
		return;
	disp_postOrder(root.left);
	disp_postOrder(root.right);
	System.out.print(root.data+" ");
}
}
