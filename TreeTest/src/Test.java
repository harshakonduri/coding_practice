import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Test {

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
		b.insert(6);
		//b.insert(8);
		b.insert(12);
		b.insert(17);
		b.insert(11);
		b.insert(13);
		b.insert(99);
		b.insert(18);
		
		/*
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
		}
		catch(Exception e)
		    { System.out.println("exception");}
		
		*/
		//b.disp_inOrder(b.root);
		//System.out.println(b.getSuccessor(5));
		//b.dispSiblings(b.root);
		int tree_height=b.getHeight(b.root);
		ArrayList [] a=new ArrayList[tree_height];
		for(int i=0;i<tree_height;i++)
		{
			a[i]=new ArrayList();
		}
		for(int i=0;i<b.getHeight(b.root);i++)
		{
			a[i] = b.disp_levelOrder(b.root, i,a[i]);
		}
		//System.out.println(a);
		for(int i=0;i<a.length;i++)
		{
			System.out.println("List "+i+" "+a[i]);
		}

		//Node m=b.getNode(5);
		//System.out.println("recv node = "+m.data);
		//System.out.println("Leaves are :"+b.getNumberOfLeaves(b.root));
	//	System.out.println("height="+b.getHeight(b.root));
		
		//
		//b.disp_inOrder(b.root);
		//b.disp_postOrder(b.root);
		//b.disp_preOrder(b.root);
	}

}
